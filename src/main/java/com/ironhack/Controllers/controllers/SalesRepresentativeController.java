package com.ironhack.Controllers.controllers;

import com.ironhack.Controllers.controllers.DTOs.*;
import com.ironhack.Controllers.entity.*;
import com.ironhack.Controllers.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

import java.util.*;

@RestController
public class SalesRepresentativeController {

    @Autowired
    SalesRepRepository salesRepRepository;

    @Autowired
    ProductRepository productRepository;


    @GetMapping("/representatives")
    public List<SalesRepDTO> getAll() {

        List<SalesRepDTO> salesRepDTOS = new ArrayList<>();

        for (SalesRepresentative salesRep : salesRepRepository.findAll()) {
            salesRepDTOS.add(new SalesRepDTO(salesRep.getId(), salesRep.getName(), salesRep.getSurname()));

        }

        /*

        salesRepRepository.findAll().forEach((salesRepresentative -> {
            salesRepDTOS.add(new SalesRepDTO(salesRepresentative.getId(), salesRepresentative.getName(), salesRepresentative.getSurname()));
        }));
         */

        return salesRepDTOS;
    }


    @PostMapping("/assign-product/")
    public Product assignNewProduct(@RequestBody RepProductDTO repProductDTO) {

        Product product = productRepository.findById(repProductDTO.getProductId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        SalesRepresentative salesRep = salesRepRepository.findById(repProductDTO.getRepresentativeId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        product.setSalesRepresentative(salesRep);

        return productRepository.save(product);

        /*
        {
        salesRepresentativeId : 2,
        productId: 1
        }
         */

        // Producto
        // El nuevo salesRepresentative
    }

}
