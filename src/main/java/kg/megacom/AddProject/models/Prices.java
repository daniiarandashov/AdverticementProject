package kg.megacom.AddProject.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "prices")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Long id;

    private double price;

    private Date start_date;

    private Date end_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tv_chanel_id")
    private TvChanel tvChanel;

}
