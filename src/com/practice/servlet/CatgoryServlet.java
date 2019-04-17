package com.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.practice.dao.impl.LibDaoImpl;
import com.practice.service.LibService;
import com.practice.service.impl.LibServiceImpl;
import com.practice.utils.Utils;

/**
 * Servlet implementation class CatgoryServlet
 */
@WebServlet("/catgory")
public class CatgoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LibService libService = new LibServiceImpl();

    public CatgoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Map<String, String> catgoryAddInfo = new HashMap<String, String>();
		Long id = null;
		String catgoryName = null;
		String description = null;

    	try {
			id = (long) Integer.parseInt(request.getParameter("id"));
			catgoryName = request.getParameter("catgoryName");
			description = request.getParameter("description");

			if(!Utils.isEmpatyString(catgoryName)&&!Utils.isEmpatyString(description)) {
				libService.addBookCatgory(id, catgoryName, description);
			}else{
				catgoryAddInfo.put("catgoryAddError", "请完善信息");
				out.print(JSON.toJSONString(catgoryAddInfo));
			}
		} catch (Exception e) {
//			e.printStackTrace();
			catgoryAddInfo.put("IDError", "ID格式有误");

			out.print(JSON.toJSONString(catgoryAddInfo));
		}
		out.flush();
		out.close();

//		this.getServletContext().setAttribute("catgoryList", catgoryJson);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
