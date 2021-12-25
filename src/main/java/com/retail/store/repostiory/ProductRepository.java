package com.retail.store.repostiory;

import com.retail.store.model.entity.Product;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ProductRepository extends RepositoryInterface<Product> {
}
