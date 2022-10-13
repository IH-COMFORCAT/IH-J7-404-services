package com.ironhack.Controllers.services;

import com.ironhack.Controllers.entity.*;
import com.ironhack.Controllers.repositories.*;
import com.ironhack.Controllers.services.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

import java.math.*;
import java.time.*;
import java.util.*;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    ProductRepository productRepository;


    public Product addProduct(Product product) {

        if (productRepository.findById(product.getId()).isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

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

        //
        // Product product1 = productRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!productRepository.findById(id).isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This product doesn't exist");
        product.setId(id);
        return productRepository.save(product);


        /*

        if (productRepository.findById(id).isPresent()) {
            product.setId(id);
            return productRepository.save(product);

        }
        return null;

         */
    }

    @Override
    public Product updateProductPrice(Long id, BigDecimal price) {

            Product product1 = productRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
            product1.setPrice(price);
            return productRepository.save(product1);

    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A product with the given id does not exist"));


        /*
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A product the the given id does not exist");


         */
    }


}
