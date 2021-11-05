package br.com.piback.ecommerce.Controller;

import br.com.piback.ecommerce.Domain.ProductItem;
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
    public ResponseEntity<ProductItem> getProductItemById(@PathVariable("id") Long id){
        ProductItem productItem = productItemService.getProductItemById(id);
        return new ResponseEntity<ProductItem>(productItem, HttpStatus.OK);
    }

    @ApiOperation(value = "Lista os itens dos Produtos")
    @GetMapping
    public ResponseEntity<List<ProductItem>> getProducts() {
        List<ProductItem> productsItems = productItemService.getProductItems();
        return new ResponseEntity(productsItems, HttpStatus.OK);
    }
    @ApiOperation(value = "Inserir os itens dos Produtos")
    @PostMapping
    public ResponseEntity<StatusResponse> insertProductItem(@RequestBody ProductItem productItem){
        StatusResponse statusResponse = productItemService.insertProductsItems(productItem);
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
    public ResponseEntity<StatusResponse> updateProductItem(@RequestBody ProductItem productItem){
        StatusResponse statusResponse = productItemService.updateProductsItems(productItem);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
}
