package com.api.product.controller;


import com.api.product.dto.ProductDTO;
import com.api.product.model.Product;
import com.api.product.service.ProductService;
import com.api.product.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private static final String PRODUCT_ADDED = "Product added successfully";
    private static final String PRODUCT_DELETED = "Product deleted successfully";

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public List<ProductDTO> getAllCashIn() {
        return ObjectMapperUtils.mapAll(productService.findAll(), ProductDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateCashIn(@RequestBody ProductDTO productDTO) {
        productService.saveOrUpdateProduct(ObjectMapperUtils.map(productDTO, Product.class));
        return new ResponseEntity(PRODUCT_ADDED, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{productUuid}")
    public ResponseEntity<?> deleteCashInByAccountType(@PathVariable String productUuid) {
        productService.deleteProductByUuid(productService.findByUuid(productUuid).getUuid());
        return new ResponseEntity(PRODUCT_DELETED, HttpStatus.OK);
    }
}
