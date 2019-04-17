package com.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.practice.dao.impl.LibDaoImpl;
import com.practice.domain.User;
import com.practice.service.LibService;
import com.practice.service.impl.LibServiceImpl;


@WebServlet("/adduser")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LibService libService = new LibServiceImpl();

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        String usernameRegx = "[a-zA-Z_0-9]{3,12}"; //用户名为3-12位字母数字或下划线组合
        String passwordRegx = "[0-9]{6,12}";
        String phoneRegx = "[1][3579]\\d{9}";
        String emailRegx = "[a-zA-Z_0-9]{3,}@([a-zA-Z]+|\\d+)(\\.[a-zA-Z]+)+";
        Map<String, String> json = new HashMap<String,String>();
        PrintWriter out = response.getWriter();
        if (libService.isUserExist(username) == 1) {

            String existedName = "existedName";
            String existedNameValue = "用户名存在";

//            String json = "{"+existedName +':'+existedNameValue+"}";
            json.put(existedName, existedNameValue);
            System.out.println(JSON.toJSONString(json));
            out.print(JSON.toJSONString(json));
            return;
        } else {




            boolean usernameFlag = username.matches(usernameRegx);
            boolean passwordFlag = password.matches(passwordRegx);
            boolean phoneFlag = phone.matches(phoneRegx);
            boolean emailFlag = email.matches(emailRegx);


            if (usernameFlag && passwordFlag && phoneFlag && emailFlag) {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setPhone(phone);
                user.setEmail(email);

                libService.regist(user);
                this.getServletContext().setAttribute("userList", LibDaoImpl.getUserdb());

                request.getSession().setAttribute("username", user.getUsername());
                System.out.println("注册成功");
//            response.sendRedirect(request.getContextPath());

                json.put("registSuccess", "注册成功");
                String registSuccessJson = JSON.toJSONString(json);
                out.print(registSuccessJson);

            } else {
                String registError =  "registError";
                String registErrorMsg = "信息有误，请检测后再输入";


                 json.put(registError,registErrorMsg);

                out.print(JSON.toJSONString(json));
                System.out.println(JSON.toJSONString(json));

            }
        }
        out.flush();
        out.close();

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
