package com.tt.demo03.pojo;


import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = -3546241618658107566L;
    private Integer id;
    private String title;
    private String image;
    private String author;
    private Double price;
    private String name;
public Book(){
    super();
}
public Book(Integer id,String title,String image,String author,Double price){
    super();
    this.id=id;
    this.title=title;
    this.image=image;
    this.price=price;
    this.author=author;

}

    public Book(Integer id, String title, String image, String author, Double price, String name) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.author = author;
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
