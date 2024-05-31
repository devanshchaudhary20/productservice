package dev.devansh.productservice.services;

import dev.devansh.productservice.dtos.GenericProductDto;
import java.util.List;

import dev.devansh.productservice.exceptions.NotFoundException;
import dev.devansh.productservice.models.Product;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);
    GenericProductDto getProductById(Long id) throws NotFoundException;
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProduct(Long id);
    GenericProductDto updateProduct(Long id, GenericProductDto product);
}
