package com.example.iProduct.controller;

import com.example.iProduct.domain.City;
import com.example.iProduct.domain.Product;
import com.example.iProduct.service.CityService;
import com.example.iProduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {
    @Autowired
    CityService cityService;

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String greeting() {
        return "Hello world";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/product/{productId}")
    public Product getProduct(@PathVariable String productId) {
        for (Product product : productService.getProducts()) {
            if (product.getId() == Integer.parseInt(productId))
                return product;
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/products/add", consumes = {"multipart/form-data"})
    public List<Product> addProducts(@RequestParam Map<String, Object> body) {
        productService.addProduct(body);
        return productService.getProducts();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/products/edit", consumes = {"multipart/form-data"})
    public List<Product> editProducts(@RequestParam Map<String, Object> body) {
        productService.editProduct(body);
        return productService.getProducts();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/products/del")
    public List<Product> deleteProducts(@RequestBody Map<String, String> body) {
        for (Map.Entry<String, String> entry : body.entrySet()) {
            if (entry.getKey().equals("id"))
                return productService.deleteProduct(Long.parseLong(entry.getValue()));
        }
        return productService.getProducts();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/cities")
    public List<City> getCities() {
        return cityService.getCities();
    }

//    @GetMapping("/contacts")
//    public String getContactsPage() {
//            return "contacts";
//    }
//
//    Get images
//    @GetMapping(value = "/img/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
//    public @ResponseBody
//    byte[] getImage(@PathVariable String name) {
//        File serverFile = new File(uploadPath + "/" + name);
//        try {
//            return Files.readAllBytes(serverFile.toPath());
//        } catch (IOException e) {
//            return null;
//        }
//    }
}