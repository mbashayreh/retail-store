package com.retail.store.controller.rest;


import com.retail.store.model.dto.DataList;
import com.retail.store.model.dto.ErrorResponseDTO;
import com.retail.store.model.dto.OrderDTO;
import com.retail.store.model.entity.Product;
import com.retail.store.model.response.ResponseMessage;
import com.retail.store.service.OrderQueryManager;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {


    private final OrderQueryManager orderQueryManager;

    @Autowired
    public OrderController(OrderQueryManager orderQueryManager) {
        this.orderQueryManager = orderQueryManager;
    }

    /**
     * add product
     *
     * @return <b>ResponseEntity&lt<span>Object</span>&gt</b>
     */
    @ApiOperation(value = "add product  ", notes = "add product")
    @ApiResponses({
            @ApiResponse(code = 201, response = Product.class, message = "OK"),
            @ApiResponse(code = 404, response = ErrorResponseDTO.class, message = "No Data Found"),
            @ApiResponse(code = 400, response = ErrorResponseDTO.class, message = "Bad Request"),
            @ApiResponse(code = 500, response = ErrorResponseDTO.class, message = "Internal Server Error")

    })

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<ResponseMessage> addProduct(@RequestBody OrderDTO orderDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body(orderQueryManager.addData(orderDTO));

    }

    /**
     * get product
     *
     * @return <b>ResponseEntity&lt<span>Object</span>&gt</b>
     */
    @ApiOperation(value = "get product  ", notes = "get product")
    @ApiResponses({
            @ApiResponse(code = 201, response = Product.class, message = "OK"),
            @ApiResponse(code = 404, response = ErrorResponseDTO.class, message = "No Data Found"),
            @ApiResponse(code = 400, response = ErrorResponseDTO.class, message = "Bad Request"),
            @ApiResponse(code = 500, response = ErrorResponseDTO.class, message = "Internal Server Error")

    })

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<OrderDTO> getProduct(@PathVariable int id) {

        return ResponseEntity.status(HttpStatus.CREATED).body(orderQueryManager.getById(id));

    }

    /**
     * get all product
     *
     * @return <b>ResponseEntity&lt<span>Object</span>&gt</b>
     */
    @ApiOperation(value = "get all product  ", notes = "get all product")
    @ApiResponses({
            @ApiResponse(code = 201, response = DataList.class, message = "OK"),
            @ApiResponse(code = 404, response = ErrorResponseDTO.class, message = "No Data Found"),
            @ApiResponse(code = 400, response = ErrorResponseDTO.class, message = "Bad Request"),
            @ApiResponse(code = 500, response = ErrorResponseDTO.class, message = "Internal Server Error")

    })

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<DataList> getAllProduct() {

        return ResponseEntity.status(HttpStatus.CREATED).body(orderQueryManager.getAllData());

    }

    /**
     * Delete Product by id
     *
     * @return <b>ResponseEntity&lt<span>Object</span>&gt</b>
     */
    @ApiOperation(value = "Delete Product By ID  ", notes = "Delete Product By ID ")
    @ApiResponses({
            @ApiResponse(code = 201, response = DataList.class, message = "OK"),
            @ApiResponse(code = 404, response = ErrorResponseDTO.class, message = "No Data Found"),
            @ApiResponse(code = 400, response = ErrorResponseDTO.class, message = "Bad Request"),
            @ApiResponse(code = 500, response = ErrorResponseDTO.class, message = "Internal Server Error")

    })

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ResponseMessage> deleteProduct(int id) {

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(orderQueryManager.deleteById(id));

    }

}
