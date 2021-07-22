package kg.megacom.AddProject.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tv_chanels")
public class TvChanel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tv_chanel_id")
    private Long id;

    private String name;

    private String logo;

    private boolean is_active;

}
