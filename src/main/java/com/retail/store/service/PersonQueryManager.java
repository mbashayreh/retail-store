package com.retail.store.service;

import com.retail.store.model.dto.PersonDTO;
import com.retail.store.model.entity.Person;
import com.retail.store.repostiory.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonQueryManager extends AbstractQueryManager<Person, PersonDTO> {


    private final PersonRepository personRepository;

    @Autowired
    public PersonQueryManager(ModelMapper modelMapper, PersonRepository personRepository) {
        super(personRepository, modelMapper);
        this.personRepository = personRepository;

    }
}
