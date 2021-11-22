package com.example.BackendJab.models;

import com.example.BackendJab.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Status status;
    private Integer stock_amount;
    private Long sku;
    private String image_url;
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL) //many books, to one category
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name="category_id")
    private Category category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getStock_amount() {
        return stock_amount;
    }

    public void setStock_amount(Integer stock_amount) {
        this.stock_amount = stock_amount;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
