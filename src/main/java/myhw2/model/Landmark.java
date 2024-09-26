package myhw2.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Landmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate creationDate;
    private String description;

    @Enumerated(EnumType.STRING)
    private LandmarkType type;

    @ManyToOne
    @JoinColumn(name = "locality_id")
    private Locality locality;

    @OneToMany(mappedBy = "landmark")
    private List<Service> services;
}

