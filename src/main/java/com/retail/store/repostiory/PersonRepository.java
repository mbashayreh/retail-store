package com.retail.store.repostiory;

import com.retail.store.model.entity.Person;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface PersonRepository extends RepositoryInterface<Person> {
}
