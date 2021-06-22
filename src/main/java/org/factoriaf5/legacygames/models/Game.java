package org.factoriaf5.legacygames.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "games")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private int year;

    @NotNull
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String photo;


    @Override
    public String toString() {
       return "Game{" +
       "id=" + id +
       ", title='" + title + '\'' +
       ", price='" + price + '\'' +
       ", category='" + category + '\'' +
       ", photo='" + photo + '\'' +
       '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhotoImagePath() {
        if (photo == null || id == null) return null;
        return "/game-photo/" + id + "/" + photo;
    }

}
