package dev.devansh.productservice.services;

import dev.devansh.productservice.dtos.FakeStoreProductDto;
import dev.devansh.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String productRequestBaseUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(productRequestBaseUrl, product, GenericProductDto.class);
        return response.getBody();
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        GenericProductDto product = new GenericProductDto();
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestBaseUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> answer = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto : Arrays.stream(response.getBody()).toList()) {
            GenericProductDto product = new GenericProductDto();
            product.setImage(fakeStoreProductDto.getImage());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setCategory(fakeStoreProductDto.getCategory());

            answer.add(product);
        }

        return answer;
    }
}
