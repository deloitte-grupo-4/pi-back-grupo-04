package br.com.piback.ecommerce.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_item")
public class ProductItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 11)
    private Long id;

    @Column(name = "quantity", nullable = false, length = 11)
    private Integer qtdade;

    @Column(name = "size")
    private String size;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_order", referencedColumnName = "id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtdade() {
        return qtdade;
    }

    public void setQtdade(Integer qtdade) {
        this.qtdade = qtdade;
    }

    public String size() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
