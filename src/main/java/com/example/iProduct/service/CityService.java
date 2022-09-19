package com.example.iProduct.service;

import com.example.iProduct.domain.City;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {
    List<City> cities = new ArrayList<>();
    public List<City> getCities() {
        if (cities.size() < 5) {
            cities.add(new City(1L, "NurSultan"));
            cities.add(new City(2L, "Almaty"));
            cities.add(new City(3L, "Qyzylorda"));
            cities.add(new City(4L, "Aqtobe"));
            cities.add(new City(5L, "Turkestan"));
        }

        return cities;
    }
}