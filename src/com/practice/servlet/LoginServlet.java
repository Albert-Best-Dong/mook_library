package com.practice.servlet;

import com.practice.dao.impl.LibDaoImpl;
import com.practice.domain.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		for (User user: LibDaoImpl.getUserdb()) {
			if(user.getUsername().equals(username)){

				if (user.getPassword().equals(password)){
					request.getSession().setAttribute("loginUser", username);
					break;
				}else {
					//用户密码不对不能登录
					response.sendRedirect(request.getContextPath());
					return;
				}
			}
		}

		response.sendRedirect(request.getContextPath()+"/server.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
