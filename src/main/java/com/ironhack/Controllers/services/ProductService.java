package com.ironhack.Controllers.services;

import com.ironhack.Controllers.entity.*;
import com.ironhack.Controllers.repositories.*;
import com.ironhack.Controllers.services.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.math.*;
import java.time.*;
import java.util.*;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    ProductRepository productRepository;


    public Product addProduct(Product product) {
        return productRepository.save(product);
    }


    public List<Product> getAllProducts(LocalDate localDate, Category category, Optional<Genre> genre) {
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

    @Override
    public Product updateProduct(Long id, Product product) {

        if (productRepository.findById(id).isPresent()) {
            product.setId(id);
           return productRepository.save(product);

        }
        return null;
    }

    @Override
    public Product updateProductPrice(Long id, BigDecimal price) {

        if (productRepository.existsById(id)) {
            Product product1 = productRepository.findById(id).get();
            product1.setPrice(price);
            return productRepository.save(product1);
        }

        return null;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }


}
