package at.schafi.schafisock.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderProducts")
@Getter
@Setter
public class Order {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonFormat(pattern = "dd/mm/yyyy") private LocalDate dateCreated;

    private String status;

    @OneToMany
    @Valid
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Transient
    public Double getTotalOrderPrice() {
        return getOrderProducts().stream().mapToDouble(OrderProduct::getTotalPrice).sum();
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }
}
