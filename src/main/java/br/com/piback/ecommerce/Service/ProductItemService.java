package br.com.piback.ecommerce.Service;

import br.com.piback.ecommerce.Domain.ProductOrder;
import br.com.piback.ecommerce.Domain.StatusResponse;
import br.com.piback.ecommerce.Repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductItemService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    public List<ProductOrder> getProductItems(){
        return productOrderRepository.findAll();
    }

    public StatusResponse insertProductsItems(ProductOrder productOrder){
        productOrderRepository.save(productOrder);
        return new StatusResponse("Item do Produto criado com sucesso", "sucesso");
    }

    public StatusResponse updateProductsItems(ProductOrder newProductOrder){
        productOrderRepository.save(newProductOrder);
        return new StatusResponse("Item do Produto atualizado com sucesso", "sucesso");
    }
    public StatusResponse deleteProductItems(Long id){
        productOrderRepository.deleteById(id);
        return new StatusResponse("Item do Produto removido com sucesso", "sucesso");
    }

    public ProductOrder getProductItemById(Long id) {
        return productOrderRepository.findById(id).get();
    }
}
