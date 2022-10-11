package com.ironhack.Controllers.services.interfaces;

import com.ironhack.Controllers.entity.*;

import java.math.*;
import java.time.*;
import java.util.*;

public interface ProductServiceInterface {
    Product addProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts(LocalDate localDate, Category category, Optional<Genre> genre);

    Product updateProduct(Long id, Product product);

    Product updateProductPrice(Long id, BigDecimal price);
}
