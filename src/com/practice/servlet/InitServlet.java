package com.practice.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.impl.LibDaoImpl;
import com.practice.domain.User;



public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		List<User> userList = LibDaoImpl.getUserdb();
		this.getServletContext().setAttribute("userList", userList);
	}

}
