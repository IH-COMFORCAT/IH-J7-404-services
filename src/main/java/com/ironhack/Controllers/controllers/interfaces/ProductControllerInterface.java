package com.ironhack.Controllers.controllers.interfaces;

import com.ironhack.Controllers.entity.*;

import java.util.*;

public interface ProductControllerInterface {

    Product addProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts(Category category, Optional<Genre> genre);

}
