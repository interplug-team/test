package com.example.jpamybatis.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for {@link com.example.jpamybatis.entity.UserEntityEntity}
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "TB_USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    public UserEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
