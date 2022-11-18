package com.cydeo.entity;

import com.cydeo.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name="films")
@Where(clause = "is_deleted=false")
public class Film extends BaseEntity{

    private String name;
    private int year;
    private LocalDate lastWatchDate;
    @Enumerated
    @Column(name="genre_id")
    private Genre genre;

}
