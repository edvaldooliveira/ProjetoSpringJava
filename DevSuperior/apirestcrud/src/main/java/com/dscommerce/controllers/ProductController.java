package com.dscommerce.controllers;

import com.dscommerce.dto.ProductDTO;
import com.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//Controlador e rota
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){

        ProductDTO dto = service.findById(id);
       return ResponseEntity.ok(dto);
    }

    //Método
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findALL(Pageable pageable){
       Page<ProductDTO> dto = service.findALL(pageable);
       return ResponseEntity.ok(dto);
    }

    //Vai receber a requisiçao que bem do formulario
    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //Atualizar dados
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto){

         dto = service.uppdate(id, dto);
        return ResponseEntity.ok(dto);
    }

}
