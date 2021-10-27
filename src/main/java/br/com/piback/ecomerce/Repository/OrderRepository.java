package br.com.piback.ecomerce.Repository;

import br.com.piback.ecomerce.Domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
