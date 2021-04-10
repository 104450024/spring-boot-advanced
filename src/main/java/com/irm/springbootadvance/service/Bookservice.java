package com.irm.springbootadvance.service;

import com.irm.springbootadvance.domain.Book;
import org.springframework.stereotype.Repository;


public interface Bookservice {

    Book getBookById(Long id);

}

// Book BookService
//      BookRepository