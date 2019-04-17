package com.practice.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.practice.dao.impl.LibDaoImpl;
import com.practice.domain.Book;
import com.practice.domain.User;

public class ServletContextInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<User> userList = LibDaoImpl.getUserdb();
		List<Map<String, Object>> catgoryList = LibDaoImpl.getCatgory();
		// 图书表
		List<Book> bookList = LibDaoImpl.getBooks();
		sce.getServletContext().setAttribute("userList", userList);
		sce.getServletContext().setAttribute("catgoryList", catgoryList);
		sce.getServletContext().setAttribute("bookList", bookList);
	}

}
