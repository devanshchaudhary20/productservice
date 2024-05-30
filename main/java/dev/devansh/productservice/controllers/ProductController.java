package dev.devansh.productservice.controllers;

import dev.devansh.productservice.dtos.GenericProductDto;
import dev.devansh.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public void getAllProducts() {

    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public void deleteProductId() {

    }

    @PostMapping
    public String createProduct() {
        return "Created new product: " + UUID.randomUUID();
    }

    @PutMapping("{id}")
    public void updateProductById() {

    }
}
