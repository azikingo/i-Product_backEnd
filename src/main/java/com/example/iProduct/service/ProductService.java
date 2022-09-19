package com.example.iProduct.service;

import com.example.iProduct.domain.City;
import com.example.iProduct.domain.CityPrice;
import com.example.iProduct.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    CityService cityService;

    public List<Product> products = new ArrayList<>();
    public boolean isInitialized = false;
    public Long lastId = 8L;

    public void initializeProducts() {
        products.add(new Product(1L, "Bottle", "Glass dish to drink", "active", 2500));
        products.add(new Product(2L, "Watch", "Device to see time", "active"));
        products.add(new Product(3L, "Boiler", "Device to heat", "archive", 23250));
        products.add(new Product(4L, "Laptop", "Electronic device to work/play and etc.", "active", 232990));
        products.add(new Product(5L, "Phone", "Electronic device to call and etc.", "active", 232990));
        products.add(new Product(6L, "Monitor", "Electronic device to display...", "active", 232990));
        products.add(new Product(7L, "Cable", "Cable to connect device with WiFi.", "active", 232990));
        products.add(new Product(8L, "Shirt", "Dress for summer season.", "active", 232990));
        isInitialized = true;
    }

    public List<Product> getProducts() {
        if (!isInitialized)
            initializeProducts();

        return products;
    }

    public List<Product> addProduct(Map<String, Object> body) {
        lastId += 1;
        return addNewProduct(lastId, body);
    }

    public List<Product> editProduct(Map<String, Object> body) {
        System.out.println(body.get("id"));
        Long id = Long.parseLong((String) body.get("id"));

        for (Product product : products) {
            if (product.getId().longValue() == id.longValue()) {
                products.remove(product);
                break;
            }
        }
        return addNewProduct(id, body);
    }

    private List<Product> addNewProduct(Long id, Map<String, Object> body) {
        Product newProduct = new Product(id,
                (String) body.get("name"),
                (String) body.get("description"),
                (String) body.get("status"));

        if (body.get("price").equals("")) {
            List<City> cities = cityService.getCities();
            List<CityPrice> prices = new ArrayList<>();

            for (City city : cities) {
                prices.add(new CityPrice(city.getId(), city.getName(), Integer.parseInt((String) body.get("city" + city.getId()))));
            }
            newProduct.setPrices(prices);
        } else {
            newProduct.setPrice(Integer.parseInt((String) body.get("price")));
        }
        products.add(newProduct);

        return products;
    }

    public List<Product> deleteProduct(Long id) {
        for (Product product : products) {
            if (product.id.longValue() == id.longValue()) {
                products.remove(product);
                break;
            }
        }

        return products;
    }
}