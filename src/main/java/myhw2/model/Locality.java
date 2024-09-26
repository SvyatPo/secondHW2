package myhw2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer population;
    private Boolean hasMetro;

    @OneToMany(mappedBy = "locality")
    private List<Landmark> landmarks;
}