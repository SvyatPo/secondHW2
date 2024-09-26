package myhw2.service;

import myhw2.dtos.LandmarkDto;

import java.util.List;

public interface LandmarkService {
    LandmarkDto addLandmark(LandmarkDto landmarkDto);
    List<LandmarkDto> getAllLandmarks(String sortBy, String filterBy);
    List<LandmarkDto> getLandmarksByLocality(Long cityId);
    LandmarkDto updateLandmark(Long id, String description);
    void deleteLandmark(Long id);
}