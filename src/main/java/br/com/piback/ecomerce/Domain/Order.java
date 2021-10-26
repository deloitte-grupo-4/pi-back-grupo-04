package br.com.piback.ecomerce.Domain;

//import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
//import java.time.LocalDate;

@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new java.sql.Date(System.currentTimeMillis());


    @ManyToOne
    @JsonIgnoreProperties("orders")
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    public Order() {
    }

    public Order(Long id, Date dateCreated, User user) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.user = user;
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
}




