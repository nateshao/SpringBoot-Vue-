package com.southwind.springboottest.controller;

import com.southwind.springboottest.entity.Book;
import com.southwind.springboottest.reporesity.BookReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {

  @Autowired
  private BookReposity bookReposity;

  @GetMapping("/findAll/{page}/{size}")
  public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
    Pageable pageable = PageRequest.of(page-1,size);
    return bookReposity.findAll(pageable);
  }

  @PostMapping("/save")
  public String  save(@RequestBody Book book ){

    Book result = bookReposity.save(book);
    if(result != null){
      return "success";
    }else {
      return "error";
    }

  }
  @GetMapping("/findById/{id}")
  public Book findById(@PathVariable("id") Integer id){
    return bookReposity.findById(id).get();
  }

  @PutMapping("/update")
  public String update(@RequestBody Book book ) {
    Book result = bookReposity.save(book);
    if (result != null) {
      return "success";
    } else {
      return "error";
    }
  }
  @DeleteMapping("/deleteById/{id}")
  public void deleteById(@PathVariable("id") Integer id){
    bookReposity.deleteById(id);

  }

}
