package com.example.iProduct.domain;

import java.util.List;
import java.util.Map;

public class Product {
    public Long id;
    public String name;
    public String description;
    public String status;
    public Integer price;

    public List<String> photosPath;
    public List<CityPrice> prices;

    public Product() {}

    public Product(Long id, String name, String description, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Product(Long id, String name, String description, String status, Integer price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.price = price;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<String> getPhotosPath() {
        return photosPath;
    }

    public void setPhotosPath(List<String> photosPath) {
        this.photosPath = photosPath;
    }

    public List<CityPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<CityPrice> prices) {
        this.prices = prices;
    }
}
