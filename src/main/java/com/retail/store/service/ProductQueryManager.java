package com.retail.store.service;

import com.retail.store.model.dto.ProductDTO;
import com.retail.store.model.entity.Product;
import com.retail.store.repostiory.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductQueryManager extends AbstractQueryManager<Product, ProductDTO> {


    private final ProductRepository productRepository;

    @Autowired
    public ProductQueryManager(ModelMapper modelMapper, ProductRepository productRepository) {
        super(productRepository, modelMapper);
        this.productRepository = productRepository;

    }
}
