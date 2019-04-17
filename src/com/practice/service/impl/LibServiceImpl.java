package com.practice.service.impl;

import java.util.List;
import java.util.Map;

import com.practice.dao.LibDao;
import com.practice.dao.impl.LibDaoImpl;
import com.practice.domain.Book;
import com.practice.domain.User;
import com.practice.service.LibService;
/**
* 	系统Service的实现
* 	@author Albert
*/
public class LibServiceImpl implements LibService{
	private LibDao libDao = new LibDaoImpl();
	@Override
	//用户注册
	public void regist(User user) {
		libDao.regist(user);
	}

	@Override
	//用户登录
	public int login(String username, String password) {
		return libDao.login(username, password);
	}

	@Override
	//判断指定的用户名在数据库是否存在
	public int isUserExist(String username) {
		
		return libDao.isUserExist(username);
	}

	@Override
	//添加图书分类
	public void addBookCatgory(Long id, String catgoryName, String description) {
		libDao.addBookCatgory(id, catgoryName, description);
	}

	@Override
	//获取所有图书分类
	public List<Map<String, Object>> getAllBookCatgory() {
		
		return LibDaoImpl.getCatgory();
	}

	@Override
	//添加图书
	public void addBook(Book book) {
		libDao.addBook(book);
	}

	@Override
	//根据条件查询书籍信息
	public List<Book> getBookByCondition(String bookID, String bookName, String catgoryName) {
		return libDao.getBookByCondition(bookID, bookName, catgoryName);
	}
}
