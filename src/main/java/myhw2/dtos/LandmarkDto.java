package myhw2.dtos;

import lombok.Data;
import java.time.LocalDate;

@Data
public class LandmarkDto {
    private Long id;
    private String name;
    private LocalDate creationDate;
    private String description;
    private String type;
    private Long localityId;
}
