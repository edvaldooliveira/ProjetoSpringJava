package com.dscommerce.controllers;

import com.dscommerce.dto.ProductDTO;
import com.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    //Vai receber a requisiçao que bem do formulario
    @PostMapping
    public  ProductDTO insert(@RequestBody ProductDTO dto){
        return service.insert(dto);

    }

}
