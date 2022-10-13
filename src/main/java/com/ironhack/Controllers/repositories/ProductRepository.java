package com.ironhack.Controllers.repositories;

import com.ironhack.Controllers.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);
    List<Product> findByGenre(Genre genre);
    List<Product> findByCategoryAndGenre(Category category, Genre genre);

    Optional<Product> findByName(String name);

    Optional<Product> findByNameAndPriceAndStockAndCategoryAndGenre(String name, BigDecimal price, Long stock, Category category, Genre genre);


}
