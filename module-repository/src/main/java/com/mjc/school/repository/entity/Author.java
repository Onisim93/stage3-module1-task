package com.mjc.school.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class Author extends AbstractBaseEntity{

    private String name;

    public Author (String name) {
        this.name = name;
    }
}
