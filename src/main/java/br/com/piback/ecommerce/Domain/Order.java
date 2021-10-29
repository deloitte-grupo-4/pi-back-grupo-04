package br.com.piback.ecommerce.Domain;
import br.com.piback.ecommerce.Domain.Enums.OrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
//@JsonIgnoreProperties("user")
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new java.sql.Date(System.currentTimeMillis());

    @Column(name = "orderStatus", nullable = false)
    private int orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public Order() {
    }

    public Order(Long id, Date dateCreated, OrderStatus orderStatus, User user) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.user = user;
        setOrderStatus(orderStatus);
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.MERGE)
    @JoinTable(name = "products_orders",
                joinColumns = { @JoinColumn(name = "orders_id")},
                inverseJoinColumns = {@JoinColumn (name="products_id")})
    List<Product> products;


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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
    }
}




