package com.lmh.service.impl;

import com.lmh.Exception.SystemException;
import com.lmh.controller.Code;
import com.lmh.dao.BookDao;
import com.lmh.domain.Book;
import com.lmh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.SyncFailedException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    public boolean save(Book book) {
        bookDao.save(book);

        return true;
    }

    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    public Book getById(Integer id) {
        if(id==1){
            throw new SystemException("错误",Code.System_Err);

        }
        try {
            int a=1/0;
        }catch (ArithmeticException e){
            throw new SystemException("服务器出现异常", Code.Business_Err);
        }


        return bookDao.getById(id);
    }

    public List<Book> getAll() {
        //将可能出现的异常进行包装，转换成自定义异常

        return bookDao.getAll();
    }
}
