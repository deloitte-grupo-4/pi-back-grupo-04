package br.com.piback.ecommerce.Repository;

import br.com.piback.ecommerce.Domain.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

}
