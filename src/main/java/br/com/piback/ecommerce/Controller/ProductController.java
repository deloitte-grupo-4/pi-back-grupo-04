package br.com.piback.ecommerce.Controller;

import br.com.piback.ecommerce.Domain.Product;
import br.com.piback.ecommerce.Domain.StatusResponse;
import br.com.piback.ecommerce.Service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Product Endpoint",tags = {
        "Product Endpoint"
})
@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductService productService;

    @ApiOperation(value = "Lista os Produtos pela ID")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @ApiOperation(value = "Lista os Produtos")
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }
    @ApiOperation(value = "Inserir Produtos")
    @PostMapping
    public ResponseEntity<StatusResponse> insertProduct(@RequestBody Product product){
        StatusResponse statusResponse = productService.insertProducts(product);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Deletar Produto pela ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<StatusResponse> dropProduct(@PathVariable("id") Long id){
        StatusResponse statusResponse = productService.deleteProducts(id);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
    @ApiOperation(value = "Atualizar Produto")
    @PutMapping
    public ResponseEntity<StatusResponse> updateProduct(@RequestBody Product product){
        StatusResponse statusResponse = productService.updateProducts(product);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
}
