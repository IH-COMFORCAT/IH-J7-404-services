package com.ironhack.Controllers.repositories;

import com.ironhack.Controllers.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);
    List<Product> findByGenre(Genre genre);
    List<Product> findByCategoryAndGenre(Category category, Genre genre);


}
