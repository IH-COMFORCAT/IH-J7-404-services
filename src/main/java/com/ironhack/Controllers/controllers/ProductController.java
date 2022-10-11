package com.ironhack.Controllers.controllers;

import com.ironhack.Controllers.controllers.interfaces.*;
import com.ironhack.Controllers.entity.*;
import com.ironhack.Controllers.repositories.*;
import com.ironhack.Controllers.services.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.format.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.math.*;
import java.time.*;
import java.util.*;

@RestController
public class ProductController implements ProductControllerInterface {


    @Autowired
    ProductServiceInterface productService;

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts(@DateTimeFormat(pattern = "YYYY/dd/mm")
                                        LocalDate localDate, @RequestParam(required = false) Category category,
                                        @RequestParam Optional<Genre> genre) {
        return productService.getAllProducts(localDate, category, genre);

    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PatchMapping("/product/{id}")
    public Product updateProductPrice(@PathVariable Long id, @RequestBody String price) {
        return productService.updateProductPrice(id, new BigDecimal(price));
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);


    }

}
