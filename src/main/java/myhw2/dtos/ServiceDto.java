package myhw2.dtos;

import lombok.Data;

@Data
public class ServiceDto {
    private Long id;
    private String name;
    private String description;
    private Long landmarkId;
}
