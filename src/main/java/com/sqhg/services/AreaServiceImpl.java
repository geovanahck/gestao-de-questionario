package com.sqhg.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sqhg.entities.Area;
import com.sqhg.repositories.AreaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AreaServiceImpl implements AreaService {

    private AreaRepository areaRepository;

    @Override
    public List<Area> findAllAreas() {
        return areaRepository.findAll();
    }
}
