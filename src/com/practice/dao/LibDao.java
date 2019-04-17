package com.practice.dao;

import java.util.List;
import java.util.Map;

import com.practice.domain.Book;
import com.practice.domain.User;
/**
* 	系统DAO的接口
* 	@author:Albert
*/
public interface LibDao {
	public void regist(User user);	//用户注册
	public int login(String username,String password);		//用户登录
	public int isUserExist(String username);//判断指定的用户名在数据库是否存在
	public void addBookCatgory(Long id,String catgoryName,String description);//获取图书分类
	public List<Map<String,Object>> getAllBookCatgory();//获取所有图书分类
	public void addBook(Book book);//添加图书
	public List<Book>getBookByCondition(String bookID,String bookName,String catgoryName);//根据条件来查询书籍信息
}
