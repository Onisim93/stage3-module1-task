package com.mjc.school.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorModel extends AbstractBaseEntity{

    private String name;

    public AuthorModel(Long id, String name) {
        super(id);
        this.name = name;
    }

}
