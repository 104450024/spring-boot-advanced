package com.irm.springbootadvance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity //spring數據模型的宣告
public class Book {


    @Id  //primary key
    @GeneratedValue   //自動生成資料庫

    private Long id;
    private String author;
    private String description;
    private String name;
    private Integer status;


    public Book()
    {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
