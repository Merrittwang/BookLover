package com.example.ereading.domain;

public class Book{
    private Integer book_id;
    private String book_name;
    private String author;
    private Integer points;
    private Integer category_id;
    private Integer likes;

    private Long years;

    public Long getYears() {return years;}

    public void setYears(Long years) {this.years = years;}
    public Integer getBook_id() {
        return book_id;
    }
    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }
    public String getBook_name() {
        return book_name;
    }
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Integer getPoints() {
        return points;
    }
    public void setPoints(Integer points) {
        this.points = points;
    }
    public Integer getCategory_id(){
        return category_id;
    }
    public void setCategory_id(Integer category_id){
        this.category_id = category_id;
    }
    public Integer getLikes(){
        return likes;
    }
    public void setLikes(){
        likes++;
    }


}