package br.com.piback.ecomerce.Controller;

import br.com.piback.ecomerce.Domain.Order;
import br.com.piback.ecomerce.Domain.StatusResponse;
import br.com.piback.ecomerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id){
        Order order = orderService.getOrderById(id);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.getOrders();
        return new ResponseEntity(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StatusResponse> insertOrder(@RequestBody Order order){
        StatusResponse statusResponse = orderService.insertOrder(order);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusResponse> dropOrder(@PathVariable("id") Long id){
        StatusResponse statusResponse = orderService.deleteOrder(id);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StatusResponse> updateOrder(@RequestBody Order order){
        StatusResponse statusResponse = orderService.updateOrder(order);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
}
