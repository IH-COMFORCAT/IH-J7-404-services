package com.ironhack.Controllers.controllers;

import com.ironhack.Controllers.controllers.interfaces.*;
import com.ironhack.Controllers.entity.*;
import com.ironhack.Controllers.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.math.*;
import java.util.*;

@RestController
public class ProductController implements ProductControllerInterface {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);

    }


    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }


    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts(@RequestParam(required = false) Category category,
                                        @RequestParam Optional<Genre> genre) {

        if (category != null && genre.isPresent()) {
            return productRepository.findByCategoryAndGenre(category, genre.get());

        }

        if (category != null) {
            return productRepository.findByCategory(category);
        }

        if (genre.isPresent()) {
            return productRepository.findByGenre(genre.get());
        }

        return productRepository.findAll();
    }

}
