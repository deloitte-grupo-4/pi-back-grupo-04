package br.com.piback.ecommerce.Domain;

import java.util.List;

public class OrderForm {
    public List<ShoppingCart> shoppingCart;
    public DeliveryAddress deliveryAddress;
    public Long user;
    public int total;
    public String paymentMethod;
}
