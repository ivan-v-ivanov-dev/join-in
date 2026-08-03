package com.joinin.group.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "identity", nullable = false, unique = true, length = 500)
    private String identity;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}
