package kg.megacom.AddProject.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "discounts")
public class Discounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Long id;

    private int discount;


    private Date start_date;

    private Date end_date;

    private int min_days;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tv_chanel_id")
    private TvChanel tvChanel;

}
