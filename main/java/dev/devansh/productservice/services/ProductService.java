package dev.devansh.productservice.services;

import dev.devansh.productservice.dtos.GenericProductDto;
import java.util.List;

import dev.devansh.productservice.models.Product;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);
    GenericProductDto getProductById(Long id);
    List<GenericProductDto> getAllProducts();
}
