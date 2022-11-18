package com.cydeo.dto;

import com.cydeo.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDTO {

    private Long id;
    private String name;
    private int year;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastWatchDate;
    private Genre genre;
}
