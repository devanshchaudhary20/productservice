package dev.devansh.productservice.services;

import dev.devansh.productservice.dtos.GenericProductDto;
import dev.devansh.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }
}
