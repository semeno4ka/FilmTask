package com.cydeo.mapper;

import com.cydeo.dto.FilmDTO;
import com.cydeo.entity.Film;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

    private final ModelMapper modelMapper;

    public FilmMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public FilmDTO convertToDTO(Film entity){
        return modelMapper.map(entity, FilmDTO.class);
    }
    public Film convertToEntity(FilmDTO dto){
        return modelMapper.map(dto, Film.class);
    }

}
