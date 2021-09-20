/* (C)2021 */
package at.schafi.schafisock.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Product name is required")
    @Basic(optional = false)
    private String name;

    private String description;

    private Double price;

    private String pictureUrl;

    public Product(
            Long id,
            @NotNull(message = "Product name is required.") String name,
            String description,
            Double price,
            String pictureUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }
}
