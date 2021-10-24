package br.com.piback.ecomerce.Controller;

import br.com.piback.ecomerce.Domain.Product;
import br.com.piback.ecomerce.Domain.StatusResponse;
import br.com.piback.ecomerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StatusResponse> insertProduct(@RequestBody Product product){
        StatusResponse statusResponse = productService.insertProducts(product);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusResponse> dropProduct(@PathVariable("id") Long id){
        StatusResponse statusResponse = productService.deleteProducts(id);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StatusResponse> updateProduct(@RequestBody Product product){
        StatusResponse statusResponse = productService.updateProducts(product);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
}
