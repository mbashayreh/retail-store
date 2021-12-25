package com.retail.store.service;

import com.retail.store.model.dto.DataList;
import com.retail.store.model.response.ResponseMessage;
import com.retail.store.repostiory.RepositoryInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

public class AbstractQueryManager<T, Dto> {

    private final RepositoryInterface<T> repository;
    private final ModelMapper modelMapper;


    @Autowired
    public AbstractQueryManager(RepositoryInterface<T> repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    public DataList<T> getAllData() {


        return new DataList<>();

    }

    public ResponseMessage addData(Dto dto) {


        try {
            T mapped = dtoToEntity(dto);
            repository.save(mapped);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "something went wrong");

        }


        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("created");
        return responseMessage;

    }

    public Dto getById(int id) {

        Optional<T> data = repository.findById(id);

        if (data.isPresent()) {

            try {
                return entityToDto(data.get());
            } catch (Exception e) {

                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "something went wrong");
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");

    }

    public ResponseMessage deleteById(int id) {


        Optional<T> data = repository.findById(id);
        if (data.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data Not Found");
        }


        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("deleted");

        return responseMessage;
    }

    public T dtoToEntity(Dto dto) throws InstantiationException, IllegalAccessException {
        T entity = (T) ((Class) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public Dto entityToDto(T entity) throws InstantiationException, IllegalAccessException {
        Dto dto = (Dto) ((Class) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[1]).newInstance();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
