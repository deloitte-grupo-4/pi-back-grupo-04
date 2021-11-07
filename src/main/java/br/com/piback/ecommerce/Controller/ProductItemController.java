package br.com.piback.ecommerce.Controller;

import br.com.piback.ecommerce.Domain.ProductOrder;
import br.com.piback.ecommerce.Domain.StatusResponse;
import br.com.piback.ecommerce.Service.ProductItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Product Item Endpoint",tags = {
        "Product Item Endpoint"
})
@RestController
@RequestMapping("/product-item")
@CrossOrigin("*")
public class ProductItemController {

    @Autowired
    ProductItemService productItemService;

    @ApiOperation(value = "Lista os Items dos Produtos pela ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProductOrder> getProductItemById(@PathVariable("id") Long id){
        ProductOrder productOrder = productItemService.getProductItemById(id);
        return new ResponseEntity<ProductOrder>(productOrder, HttpStatus.OK);
    }

    @ApiOperation(value = "Lista os itens dos Produtos")
    @GetMapping
    public ResponseEntity<List<ProductOrder>> getProducts() {
        List<ProductOrder> productsItems = productItemService.getProductItems();
        return new ResponseEntity(productsItems, HttpStatus.OK);
    }
    @ApiOperation(value = "Inserir os itens dos Produtos")
    @PostMapping
    public ResponseEntity<StatusResponse> insertProductItem(@RequestBody ProductOrder productOrder){
        StatusResponse statusResponse = productItemService.insertProductsItems(productOrder);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Deletar itens dos Produto pela ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<StatusResponse> dropProductItem(@PathVariable("id") Long id){
        StatusResponse statusResponse = productItemService.deleteProductItems(id);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
    @ApiOperation(value = "Atualizar itens dos Produtos")
    @PutMapping
    public ResponseEntity<StatusResponse> updateProductItem(@RequestBody ProductOrder productOrder){
        StatusResponse statusResponse = productItemService.updateProductsItems(productOrder);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
}
