package br.com.piback.ecomerce.Service;

import br.com.piback.ecomerce.Domain.Product;
import br.com.piback.ecomerce.Repository.ProductRepository;
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

}
