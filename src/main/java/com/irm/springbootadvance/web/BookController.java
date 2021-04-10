package com.irm.springbootadvance.web;


import com.irm.springbootadvance.domain.Book;
import com.irm.springbootadvance.exception.BookNotFoundException;
import com.irm.springbootadvance.service.Bookservice;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
@RequestMapping("/books")
public class BookController {

        //Book      BookRepository          BookController  -- web
             //     Bookservice             BookServicelmpl -- 提供找尋方法


    private final Logger logger= LoggerFactory.getLogger(BookController.class);

    private final Bookservice bookservice;

    @Autowired  //依賴注入物件
    public BookController(Bookservice bookservice) {
        this.bookservice = bookservice;
    }

    //書單詳情
    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id,Model model)
    {
        Book book = bookservice.getBookById(id);

        model.addAttribute("book",book);
        return "book";
    }


    /**
     * 異常處理
     * **/
    @ExceptionHandler({Exception.class})
    public ModelAndView handleException(HttpServletRequest request,Exception e) throws Exception {

        logger.error("Request URL : {} , Exception : {}",request.getRequestURL(),e.getMessage());

        if(AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class)!=null)
        {
            throw e;
        }
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.addObject("exception",e);
        modelAndView.setViewName("error/error");


        return modelAndView;

    }
}
