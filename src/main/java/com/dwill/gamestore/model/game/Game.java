package com.dwill.gamestore.model.game;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "game")
@Data
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String genre;
    private Integer year;
    private Integer rating;
    private Float price;
    private String image;

    public Game() {
    }

    public Game(Long id, String name, String genre, Integer year, Integer rating, Float price, String image) {
        Id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.price = price;
        this.image = image;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Game{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}
