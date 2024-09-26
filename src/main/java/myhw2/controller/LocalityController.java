package myhw2.controller;
import myhw2.dtos.LocalityDto;
import myhw2.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/localities")
    public class LocalityController {

        @Autowired
        private LocalityService localityService;
        //private LocalityDto localityDto;


        @PostMapping
        public LocalityDto addLocality(@RequestBody LocalityDto localityDto) {
        return localityService.addLocality(localityDto);
        }

        @GetMapping
        public List<LocalityDto> getAllCities() {
            return localityService.getAllLocalities();
        }

        @PutMapping("/{id}")
        public LocalityDto updateCity(@PathVariable Long id, @RequestBody LocalityDto localityDto) {
            return localityService.updateLocality(id, localityDto);
        }
    }

