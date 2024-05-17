package com.dscommerce.controllers;

import com.dscommerce.dto.ProductDTO;
import com.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Controlador e rota
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){

      return service.findById(id);
    }

    //Método
    @GetMapping
    public Page<ProductDTO> findALL(Pageable pageable){
        return service.findALL(pageable);
    }

}
