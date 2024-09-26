package myhw2.controller;

import myhw2.dtos.LandmarkDto;
import myhw2.service.LandmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/landmarks")
public class LandmarkController {

    @Autowired
    private LandmarkService landmarkService;

    @PostMapping
    public LandmarkDto addLandmark(@RequestBody LandmarkDto landmarkDto) {
        return landmarkService.addLandmark(landmarkDto);
    }

    @GetMapping
    public List<LandmarkDto> getAllLandmarks(@RequestParam(required = false) String sortBy,
                                             @RequestParam(required = false) String filterBy) {
        return landmarkService.getAllLandmarks(sortBy, filterBy);
    }

    @GetMapping("/locality/{localityId}")
    public List<LandmarkDto> getLandmarksByCity(@PathVariable Long localityId) {
        return landmarkService.getLandmarksByLocality(localityId);
    }

    @PutMapping("/{id}")
    public LandmarkDto updateLandmark(@PathVariable Long id, @RequestParam String description) {
        return landmarkService.updateLandmark(id, description);
    }

    @DeleteMapping("/{id}")
    public void deleteLandmark(@PathVariable Long id) {
        landmarkService.deleteLandmark(id);
    }
}