package br.com.piback.ecommerce.Service;

import br.com.piback.ecommerce.Domain.Product;
import br.com.piback.ecommerce.Domain.StatusResponse;
import br.com.piback.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public StatusResponse insertProducts(Product product){
        productRepository.save(product);
        return new StatusResponse("Produto criado com sucesso", "sucesso");
    }

    public StatusResponse updateProducts(Product newProduct){
        productRepository.save(newProduct);
        return new StatusResponse("Produto atualizado com sucesso", "sucesso");
    }
    public StatusResponse deleteProducts(Long id){
        productRepository.deleteById(id);
        return new StatusResponse("Produto removido com sucesso", "sucesso");
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }
}
