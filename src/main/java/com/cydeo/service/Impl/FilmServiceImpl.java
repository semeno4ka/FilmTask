package com.cydeo.service.Impl;

import com.cydeo.dto.FilmDTO;
import com.cydeo.entity.Film;
import com.cydeo.mapper.FilmMapper;
import com.cydeo.repository.FilmRepository;
import com.cydeo.service.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;

    public FilmServiceImpl(FilmRepository filmRepository, FilmMapper filmMapper) {
        this.filmRepository = filmRepository;
        this.filmMapper = filmMapper;
    }

    @Override
    public void save(FilmDTO filmDTO) {
        filmRepository.save(filmMapper.convertToEntity(filmDTO));
    }

    @Override
    public List<FilmDTO> listAllFilms() {
        List<Film> listOfFilms=filmRepository.findAll();
        return listOfFilms.stream().map(filmMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public FilmDTO getTheFilmById(Long id) {
        Film film=filmRepository.findById(id).orElseThrow();
        return filmMapper.convertToDTO(film);
    }

    @Override
    public void update(FilmDTO filmdto) {
       Film updatedFilm= filmMapper.convertToEntity(filmdto);
       updatedFilm.setId(filmRepository.findById(filmdto.getId()).orElseThrow().getId());//can be filDTO.getId()
       filmRepository.save(updatedFilm);
    }

    @Override
    public void deleteById(Long id) {
        Film film=filmRepository.findById(id).orElseThrow();
        film.setDeleted(true);
        filmRepository.save(film);
    }
}
