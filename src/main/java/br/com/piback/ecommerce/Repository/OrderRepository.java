package br.com.piback.ecommerce.Repository;

import br.com.piback.ecommerce.Domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
