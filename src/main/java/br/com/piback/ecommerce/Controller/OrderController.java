package br.com.piback.ecommerce.Controller;

import br.com.piback.ecommerce.Domain.Order;
import br.com.piback.ecommerce.Domain.StatusResponse;
import br.com.piback.ecommerce.Service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Order Endpoint",tags = {
        "Order Endpoint"
})
@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ApiOperation(value = "Lista os Pedidos pels ID")
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id){
        Order order = orderService.getOrderById(id);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
    @ApiOperation(value = "Listar os Pedidos")

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.getOrders();
        return new ResponseEntity(orders, HttpStatus.OK);
    }

    @ApiOperation(value = "Cadastrar Pedidos")
    @PostMapping
    public StatusResponse insertOrder (@RequestBody Order order){
        StatusResponse statusResponse = orderService.insertOrder(order);
        return statusResponse;
    }
    @ApiOperation(value = "Deletar os Pedidos pela ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<StatusResponse> dropOrder(@PathVariable("id") Long id){
        StatusResponse statusResponse = orderService.deleteOrder(id);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Atualizar os Pedidos")
    @PutMapping
    public ResponseEntity<StatusResponse> updateOrder(@RequestBody Order order){
        StatusResponse statusResponse = orderService.updateOrder(order);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
}
