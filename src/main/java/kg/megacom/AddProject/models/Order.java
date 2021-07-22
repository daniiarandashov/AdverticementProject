package kg.megacom.AddProject.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    @Column(length = 500)
    private String text;

    private int amount;
    @Column(name = "status")
    private boolean paymentStatus;

    private String code;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clients_id")
    private Clients clients;


}
