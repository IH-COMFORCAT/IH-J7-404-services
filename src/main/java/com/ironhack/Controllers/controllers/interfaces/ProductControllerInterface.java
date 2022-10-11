package com.ironhack.Controllers.controllers.interfaces;

import com.ironhack.Controllers.entity.*;
import org.springframework.format.annotation.*;

import java.math.*;
import java.time.*;
import java.util.*;

public interface ProductControllerInterface {

    Product addProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts(LocalDate localDate,  Category category, Optional<Genre> genre);

    Product updateProduct(Long id, Product product);

    Product updateProductPrice(Long id, String price);

}
