package com.retail.store.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.data.repository.NoRepositoryBean
public interface RepositoryInterface<T> extends JpaRepository<T, Integer> {

    List<T> findAll();
}
