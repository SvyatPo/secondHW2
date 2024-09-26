package myhw2.service;

import myhw2.dtos.LocalityDto;
import myhw2.model.Locality;
import myhw2.repository.LocalityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalityServiceImpl implements LocalityService {

    private final LocalityRepository localityRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LocalityServiceImpl(LocalityRepository localityRepository, ModelMapper modelMapper) {
        this.localityRepository = localityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LocalityDto addLocality(LocalityDto localityDto) {
        Locality locality = modelMapper.map(localityDto, Locality.class);
        Locality savedLocality = localityRepository.save(locality);
        return modelMapper.map(savedLocality, LocalityDto.class);
    }

    @Override
    public LocalityDto updateLocality(Long id, LocalityDto localityDto) {
        Locality existingLocality = localityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Locality not found"));
        existingLocality.setName(localityDto.getName());
        existingLocality.setPopulation(localityDto.getPopulation());
        existingLocality.setHasMetro(localityDto.getHasMetro());
        Locality updatedLocality = localityRepository.save(existingLocality);
        return modelMapper.map(updatedLocality, LocalityDto.class);
    }

    @Override
    public List<LocalityDto> getAllLocalities() {
        return localityRepository.findAll().stream()
                .map(locality -> modelMapper.map(locality, LocalityDto.class))
                .collect(Collectors.toList());
    }
}