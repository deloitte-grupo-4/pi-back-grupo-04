package br.com.piback.ecommerce.Service;

import br.com.piback.ecommerce.Domain.ProductItem;
import br.com.piback.ecommerce.Domain.StatusResponse;
import br.com.piback.ecommerce.Repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductItemService {

    @Autowired
    private ProductItemRepository productItemRepository;

    public List<ProductItem> getProductItems(){
        return productItemRepository.findAll();
    }

    public StatusResponse insertProductsItems(ProductItem productItem){
        productItemRepository.save(productItem);
        return new StatusResponse("Item do Produto criado com sucesso", "sucesso");
    }

    public StatusResponse updateProductsItems(ProductItem newProductItem){
        productItemRepository.save(newProductItem);
        return new StatusResponse("Item do Produto atualizado com sucesso", "sucesso");
    }
    public StatusResponse deleteProductItems(Long id){
        productItemRepository.deleteById(id);
        return new StatusResponse("Item do Produto removido com sucesso", "sucesso");
    }

    public ProductItem getProductItemById(Long id) {
        return productItemRepository.findById(id).get();
    }
}
