package com.southwind.springboottest.reporesity;

import com.southwind.springboottest.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookReposityTest {

  @Autowired
  private BookReposity bookReposity;
  @Test
  void findAll(){
    System.out.println(bookReposity.findAll());
  }

  @Test
  void save(){

    Book book = new Book();
    book.setName("张三");
    book.setAuthor("李四");
    Book save = bookReposity.save(book);
    System.out.println(save);

  }
  @Test
  void findById(){

    Book book = bookReposity.findById(1).get();
    System.out.println(book);

  }

  @Test
  void update(){
    Book book = new Book();
    book.setId(12);
    book.setName("测试测试");
    Book save = bookReposity.save(book);
    System.out.println(save);
  }
  @Test
  void delete(){
    bookReposity.deleteById(12);
  }
}
