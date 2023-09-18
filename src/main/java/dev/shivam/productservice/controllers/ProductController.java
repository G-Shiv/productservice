package dev.shivam.productservice.controllers;

import dev.shivam.productservice.dtos.GenericProductDTO;
import dev.shivam.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<GenericProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public GenericProductDTO updateProductById(@RequestBody GenericProductDTO product, @PathVariable("id") Long id) {
        return productService.updateProductById(product, id);
    }

    @DeleteMapping("/{id}")
    public GenericProductDTO deleteProductById(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }

}
