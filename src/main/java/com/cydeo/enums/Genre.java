package com.cydeo.enums;

public enum Genre {
    ACTION(1),
    COMEDY(2),
    ROMANCE(3),
    WESTERN(4),
    DRAMA(5),
    SCIENCE_FICTION(6),
    HORROR(7),
    MUSICAL(8);

    private final int id;
    Genre(int id){this.id=id;}

    public int getId() {
        return id;
    }


}
