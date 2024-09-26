package myhw2.dtos;
import lombok.Data;

    @Data
    public class LocalityDto {
        private Long id;
        private String name;
        private Integer population;
        private Boolean hasMetro;
    }


