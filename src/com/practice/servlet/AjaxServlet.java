package com.practice.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.practice.dao.impl.LibDaoImpl;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catgoryJson = JSON.toJSONString(LibDaoImpl.getCatgory());
//		String booksJson = JSON.toJSONString(LibDaoImpl.getBooks());
		System.out.println(catgoryJson);

		System.out.println(request.getParameter("catgoryList"));
		if(request.getParameter("catgoryList").equals("catgoryJson")) {
			response.getWriter().print(catgoryJson);
		}else if(request.getParameter("booksList").equals("booksJson")) {
//			response.getWriter().print(booksJson);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
