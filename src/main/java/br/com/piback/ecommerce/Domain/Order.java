package br.com.piback.ecommerce.Domain;
import br.com.piback.ecommerce.Domain.Enums.OrderStatus;
import br.com.piback.ecommerce.Domain.Enums.ProductSize;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateCreated = new java.sql.Date(System.currentTimeMillis());

    @Column(name = "order_status", nullable = false)
    private int orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column(name = "productSize")
    private Integer productSize;

//    @ManyToone(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//    @JoinTable(name = "products_orders",
//            joinColumns = { @JoinColumn(name = "orders_id")},
//            inverseJoinColumns = {@JoinColumn (name="products_id")})
//    List<Product> products;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {
    }

    // quantidade, tamanho, total da compra, ENUM Pagamento!!! <-

    public Order(Long id, Date dateCreated, OrderStatus orderStatus, User user, ProductSize productSize) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.user = user;
        setProductSize(productSize);
        setOrderStatus(orderStatus);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public List<Product> getProducts() {
//        return products;
//    }

    //public void setProducts(List<Product> products) {
      //  this.products = products;
    //}

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public ProductSize getProductSize() {
        return ProductSize.valueOf(productSize);
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize.getCode();
    }
}




