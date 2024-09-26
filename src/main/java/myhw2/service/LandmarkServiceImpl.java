package myhw2.service;

import myhw2.dtos.LandmarkDto;
import myhw2.model.Landmark;
import myhw2.repository.LandmarkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LandmarkServiceImpl implements LandmarkService {

    @Autowired
    private LandmarkRepository landmarkRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LandmarkDto addLandmark(LandmarkDto landmarkDto) {
        Landmark landmark = modelMapper.map(landmarkDto, Landmark.class);
        Landmark savedLandmark = landmarkRepository.save(landmark);
        return modelMapper.map(savedLandmark, LandmarkDto.class);
    }

    @Override
    public List<LandmarkDto> getAllLandmarks(String sortBy, String filterBy) {
        List<Landmark> landmarks = landmarkRepository.findAll();

        // Здесь можно добавить логику сортировки и фильтрации
        return landmarks.stream()
                .map(landmark -> modelMapper.map(landmark, LandmarkDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LandmarkDto> getLandmarksByLocality(Long localityId) {
        List<Landmark> landmarks = landmarkRepository.findByLocalityId(localityId);
        return landmarks.stream()
                .map(landmark -> modelMapper.map(landmark, LandmarkDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public LandmarkDto updateLandmark(Long id, String description) {
        Landmark landmark = landmarkRepository.findById(id).orElseThrow(() -> new RuntimeException("Landmark not found"));
        landmark.setDescription(description);
        Landmark updatedLandmark = landmarkRepository.save(landmark);
        return modelMapper.map(updatedLandmark, LandmarkDto.class);
    }

    @Override
    public void deleteLandmark(Long id) {
        landmarkRepository.deleteById(id);
    }
}
