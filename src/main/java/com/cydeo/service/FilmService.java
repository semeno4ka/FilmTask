package com.cydeo.service;

import com.cydeo.dto.FilmDTO;
import com.cydeo.entity.Film;

import java.util.List;

public interface FilmService {

    List<FilmDTO> listAllFilms();
    void save(FilmDTO filmDTO);
    FilmDTO getTheFilmById(Long id);
    void update(FilmDTO filmdto);
    void deleteById(Long id);
}

