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
import com.practice.domain.Book;
import com.practice.service.LibService;
import com.practice.service.impl.LibServiceImpl;
import com.practice.utils.Utils;

/**
 * Servlet implementation class AddBookServlet
 * 添加图书的Servlet
 * @author Albert
 */
@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibService libService = new LibServiceImpl();

	public AddBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> valBook = new HashMap<String, String>();    //用于存取添加信息
		PrintWriter out = response.getWriter();
		String bookID = request.getParameter("id");
		String bookName = request.getParameter("bookName");
		String catgoryName = request.getParameter("catgoryName");
		String price =request.getParameter("price");
		String description = request.getParameter("description");
		String []booksInfo = {bookID,bookName,catgoryName,description};
		for(Book b:LibDaoImpl.getBooks()){

		}
		if(Utils.noValidPrice(price)){      //价格合法
		    /*书籍信息正确添加图书*/
			if(!Utils.isEmpatyStrings(booksInfo)){
				Book book = new Book();
				book.setBookID(bookID);
				book.setBookName(bookName);
				book.setCatgoryName(catgoryName);
				book.setPrice(price);
				book.setDescription(description);
				libService.addBook(book);
				this.getServletContext().setAttribute("bookList", LibDaoImpl.getBooks());
                valBook.put("addSuccess", "添加成功");
                out.print(JSON.toJSONString(valBook));
			}else{
				valBook.put("illegalBook", "信息有误");
				out.print(JSON.toJSONString(valBook));
			}
		}else{
			valBook.put("illegalPrice", "价格有误");
			out.print(JSON.toJSONString(valBook));
		}

		out.flush();
		out.close();


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
