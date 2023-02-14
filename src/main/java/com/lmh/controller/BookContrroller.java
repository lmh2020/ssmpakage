package com.lmh.controller;

import com.lmh.domain.Book;
import com.lmh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookContrroller {
    @Autowired
    private BookService bookService;


    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.Save_ok : Code.Save_Defeat, flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UpData_ok : Code.UpData_Defeat, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);

        return new Result(flag ? Code.Delete_ok : Code.Delete_Defeat, flag);
    }

    @GetMapping("/{id}")

    public Result getById(@PathVariable Integer id) {

        Book book = bookService.getById(id);
        Integer code = book != null ? Code.Get_ok : Code.Get_Defeat;
        String msg = book != null ? null : "数据查询失败，请重试";


        return new Result(code, book, msg);
    }

    @GetMapping()
    public Result getAll() {
        List<Book> bookList = bookService.getAll();
        Integer code = bookList != null ? Code.Get_ok : Code.Get_Defeat;
        String msg = bookList != null ? " " : "数据查询失败，请重试";


        return new Result(code, bookList, msg);
    }
}
