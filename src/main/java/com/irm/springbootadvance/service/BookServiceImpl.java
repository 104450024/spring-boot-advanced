package com.irm.springbootadvance.service;

import com.irm.springbootadvance.domain.Book;
import com.irm.springbootadvance.domain.BookRepository;
import com.irm.springbootadvance.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements Bookservice{         //Book BookRepository  BookController
                                                                   //Bookservice    BookServicelmpl
    private final BookRepository bookRepository;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //獲取一個書單信息
    @Override
    public Book getBookById(Long id) {
        Book book=bookRepository.getOne(id);
        if (book == null)
        {
            throw new BookNotFoundException("書單訊息不存在");
        }
        return book;
    }
}
