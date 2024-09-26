package myhw2.service;

import myhw2.dtos.LocalityDto;

import java.util.List;

public interface LocalityService {
    LocalityDto addLocality(LocalityDto localityDto);
    LocalityDto updateLocality(Long id, LocalityDto localityDto);
    List<LocalityDto> getAllLocalities();
}