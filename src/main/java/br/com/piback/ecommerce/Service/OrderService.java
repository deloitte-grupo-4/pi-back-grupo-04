package br.com.piback.ecommerce.Service;

import br.com.piback.ecommerce.Domain.Enums.OrderStatus;
import br.com.piback.ecommerce.Domain.StatusResponse;
import br.com.piback.ecommerce.Domain.Order;
import br.com.piback.ecommerce.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders(){ return orderRepository.findAll(); }

    public StatusResponse insertOrder(Order order){
        orderRepository.save(order);
        return new StatusResponse("Pedido criado com sucesso", "sucesso");
    }

    public StatusResponse updateOrder(Order newOrder){
        orderRepository.save(newOrder);
        return new StatusResponse("Pedido atualizado com sucesso", "sucesso");
    }
    public StatusResponse deleteOrder(Long id){
        orderRepository.deleteById(id);
        return new StatusResponse("Pedido removido com sucesso", "sucesso");
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

}
