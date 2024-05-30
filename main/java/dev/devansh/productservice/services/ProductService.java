package dev.devansh.productservice.services;

import dev.devansh.productservice.dtos.GenericProductDto;
import dev.devansh.productservice.models.Product;

public interface ProductService {

    GenericProductDto getProductById(Long id);
}
