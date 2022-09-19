package com.example.iProduct.service;

import com.example.iProduct.domain.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    public List<City> getCities() {
        List<City> countries = new ArrayList<>();

        countries.add(new City(1L, "NurSultan"));
        countries.add(new City(2L, "Almaty"));
        countries.add(new City(3L, "Qyzylorda"));
        countries.add(new City(4L, "Aqtobe"));
        countries.add(new City(5L, "Turkestan"));

        return countries;
    }
}