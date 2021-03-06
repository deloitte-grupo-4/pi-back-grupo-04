package br.com.piback.ecommerce.Domain;
import br.com.piback.ecommerce.Domain.Enums.OrderStatus;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 11)
    private Long id;

    @Column (name = "cep")
    @NotNull
    public String cep;

    @Column (name = "logradouro")
    @NotNull
    public String logradouro;

    @Column (name = "numero")
    @NotNull
    public String number;

    @Column (name = "cidade")
    @NotNull
    public String city;

    @Column (name = "estado")
    @NotNull
    public String state;

    @Column (name = "total")
    @NotNull
    public Double total;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateCreated = new java.sql.Date(System.currentTimeMillis());

    @Column(name = "order_status", nullable = false)
    private int orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public Order(){

    }

    public Order(String cep, String logradouro, String number, String city, String state, User user, Double total) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.number = number;
        this.city = city;
        this.state = state;
        this.dateCreated = new java.util.Date();
        this.user = user;
        this.total = total;
        this.orderStatus = OrderStatus.AGUARDANDO_PAGAMENTO.getCode();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
    }
}




