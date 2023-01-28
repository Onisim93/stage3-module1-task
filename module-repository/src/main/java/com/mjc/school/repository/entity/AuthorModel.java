package com.mjc.school.repository.entity;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuthorModel extends AbstractBaseEntity{

    private String name;

    public AuthorModel(Long id, String name) {
        super(id);
        this.name = name;
    }

}
