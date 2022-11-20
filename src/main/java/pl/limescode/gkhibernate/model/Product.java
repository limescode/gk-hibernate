package pl.limescode.gkhibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public void print() {
        System.out.println(
                "Product{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", price=" + price +
                        '}'
        );
    }
}
