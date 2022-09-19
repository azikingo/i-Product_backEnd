package com.example.iProduct.domain;

public class CityPrice {
    public Long id;
    public String name;
    public Integer price;

    public CityPrice() {
    }

    public CityPrice(Long cityId, String cityName, Integer cityPrice) {
        this.id = cityId;
        this.name = cityName;
        this.price = cityPrice;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}