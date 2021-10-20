package br.com.piback.ecomerce.Service;

import br.com.piback.ecomerce.Domain.Product;
import br.com.piback.ecomerce.Domain.StatusResponse;
import br.com.piback.ecomerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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
}
