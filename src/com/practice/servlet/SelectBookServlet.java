package com.practice.servlet;

import java.io.IOException;
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
import com.practice.domain.Book;
import com.practice.service.LibService;
import com.practice.service.impl.LibServiceImpl;
import com.practice.utils.Utils;

/**
 * Servlet implementation class SelectBookServlet
 */
@WebServlet("/selectbook")
public class SelectBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LibService libService = new LibServiceImpl();   //Service实例
    
    public SelectBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String bookID = request.getParameter("bookID");
		String bookName = request.getParameter("bookName");
		String catgoryName = request.getParameter("catgoryName");

		Map<String, Object> notFound = new HashMap<String, Object>();   //用于查询信息
		System.out.println(bookID+"-------");

		List<Book> list = libService.getBookByCondition(bookID, bookName, catgoryName);
		if (list == null){

			notFound.put("notFound",LibDaoImpl.getBooks());
			response.getWriter().print(JSON.toJSONString(notFound));
		}else{
			String booksJson = JSON.toJSONString(list);
			System.out.println(booksJson);
			response.getWriter().print(booksJson);
		}

//		request.getServletContext().setAttribute("bookList", LibDaoImpl.getBooks());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
