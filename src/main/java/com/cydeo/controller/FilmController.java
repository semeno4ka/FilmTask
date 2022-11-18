package com.cydeo.controller;

import com.cydeo.dto.FilmDTO;
import com.cydeo.enums.Genre;
import com.cydeo.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/list")
    public String getFilmListPage(Model model){

        model.addAttribute("films",filmService.listAllFilms());
        return "/films/list";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("film", new FilmDTO());
        model.addAttribute("genres", Genre.values());
        return "/films/create";
    }

    @PostMapping("/create")
    public String createNewFilm(FilmDTO filmDTO, Model model){
        filmService.save(filmDTO);
        return "redirect:/films/list";
    }

    @GetMapping("/update/{id}")
    public String getUpdatePage(@PathVariable("id") Long id, Model model){
    model.addAttribute("film", filmService.getTheFilmById(id));
    model.addAttribute("genres", Genre.values());
    return "/films/update";
    }

    @PostMapping("/update")
    public String updateFilm(FilmDTO filmDTO){
        //just open list page
        filmService.update(filmDTO);
       return "redirect:/films/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteFilm(@PathVariable("id") Long id){
    filmService.deleteById(id);

        return "redirect:/films/list";
    }

}

