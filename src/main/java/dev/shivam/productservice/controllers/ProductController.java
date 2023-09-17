package dev.shivam.productservice.controllers;

import dev.shivam.productservice.dtos.GenericProductDTO;
import dev.shivam.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    //constructor injection
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public GenericProductDTO getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public void getAllProducts() {
    }

    @PostMapping
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public void updateProductById() {

    }

    @DeleteMapping("/{id}")
    public void deleteProductById() {

    }

}
