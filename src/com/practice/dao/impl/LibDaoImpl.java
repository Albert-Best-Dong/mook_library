package com.practice.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.practice.dao.LibDao;
import com.practice.domain.Book;
import com.practice.domain.User;
import com.sun.org.apache.bcel.internal.generic.LDIV;
/**
*   系统DAO的实现类
*   @author：Albert
*/
public class LibDaoImpl implements LibDao {
    private static final List<User> userDb = new ArrayList<User>();//用户表
    //图书分类
    private static final List<Map<String, Object>> catgory = new ArrayList<Map<String, Object>>();
    //图书表
    private static final List<Book> books = new ArrayList<Book>();


    public static List<User> getUserdb() {
        return userDb;
    }

    public static List<Map<String, Object>> getCatgory() {
        return catgory;
    }

    public static List<Book> getBooks() {
        return books;
    }

    @Override
    //用户注册
    public void regist(User user) {

        LibDaoImpl.getUserdb().add(user);

    }

    @Override
    //用户登录
    public int login(String username, String password) {
        int loginFlag = userDb.size();

        if (isUserExist(username) != loginFlag) {
            if (password.equals(userDb.get(isUserExist(username)).getPassword())) {
                loginFlag = isUserExist(username);
            }
        }
        return loginFlag;
    }

    @Override
    //判断指定的用户名在数据库是否存在
    public int isUserExist(String username) {
        int i = 0;
        for (User u : userDb) {
            if (u.getUsername().equals(username)) {
                i = 1;
                break;
            }
        }
        return i;
    }

    @Override
    //添加图书分类
    public void addBookCatgory(Long id, String catgoryName, String description) {
        Map<String, Object> catgory = new HashMap<String, Object>();
        catgory.put("id", id);
        catgory.put("catgoryName", catgoryName);
        catgory.put("description", description);
        LibDaoImpl.catgory.add(catgory);
    }

    @Override
    //获取所有图书分类
    public List<Map<String, Object>> getAllBookCatgory() {
        return LibDaoImpl.getCatgory();
    }

    @Override
    //添加图书
    public void addBook(Book book) {
        LibDaoImpl.getBooks().add(book);
    }

    @Override
    //根据条件来查询书籍信息
    public List<Book> getBookByCondition(String bookID, String bookName, String catgoryName) {
        List<Book> list = new ArrayList<Book>();

        for (Book b : LibDaoImpl.books) {
            if (b.getBookID().equals(bookID) || b.getBookName().equals(bookName) || b.getCatgoryName().equals(catgoryName)) {
                System.out.println(b);

                list.add(b);
            }
        }
        if (list.isEmpty()) {
            list = null;
        }
        return list;
    }

}
