package br.com.piback.ecommerce.Controller;

import br.com.piback.ecommerce.Repository.OrderRepository;
import br.com.piback.ecommerce.Repository.ProductOrderRepository;
import br.com.piback.ecommerce.Repository.ProductRepository;
import br.com.piback.ecommerce.Repository.UserRepository;
import br.com.piback.ecommerce.Service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import br.com.piback.ecommerce.Domain.*;

import java.util.List;
import java.util.Optional;

@Api(value = "Order Endpoint",tags = {
        "Order Endpoint"
})
@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Autowired
    ProductRepository productRepository;

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
    @Transactional
    public StatusResponse insertOrder (@RequestBody OrderForm form){
        // Get User associated with the id given
        Optional<User> user = userRepository.findById(form.user);

        // Calculate total
        Double total = 0.;

        for(ShoppingCart cartProduct: form.shoppingCart){
            total += cartProduct.price * cartProduct.quantity;
        }

        // Create new order in orders table
        Order order = new Order(
                form.deliveryAddress.cep,
                form.deliveryAddress.logradouro,
                form.deliveryAddress.numero,
                form.deliveryAddress.cidade,
                form.deliveryAddress.estado,
                user.get(),
                total
                );
        order = orderRepository.save(order);

        for(ShoppingCart cartProduct: form.shoppingCart){
            // For each product find it in database and link
            // it to the order through linking table.
            Optional<Product> product = productRepository.findById(cartProduct.productId);
            // TODO: Need to check we actually have the product...
            productOrderRepository.save(new ProductOrder(product.get(),
                    order,
                    cartProduct.quantity,
                    cartProduct.size));
        }

        return new StatusResponse();
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
