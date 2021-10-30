package br.com.piback.ecommerce.Domain;

import br.com.piback.ecommerce.Domain.Enums.ProductSize;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
@JsonIgnoreProperties("orders")
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private double price;

    @Column(name = "product_size")
    private Integer productSize;

    //implementar imagens no back

    @ManyToMany(mappedBy = "products")
    List<Order> orders;

    public Product() { }

    public Product(Long id, String name, String category, ProductSize productSize,double price, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.orders = orders;
        setProductSize(productSize);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public ProductSize getProductSize() {
        return ProductSize.valueOf(productSize);
    }
    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize.getCode();
    }
}
