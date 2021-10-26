package br.com.piback.ecomerce.Service;

import br.com.piback.ecomerce.Domain.StatusResponse;
import br.com.piback.ecomerce.Domain.Order;
import br.com.piback.ecomerce.Repository.OrderRepository;
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
        return new StatusResponse("Pedido cadastrado com sucesso", "sucesso");
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
