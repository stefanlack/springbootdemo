package com.opitzconsulting.springbootdemo.aufgaben.db;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Aufgabe extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aufgabe_seq")
    @SequenceGenerator(name = "aufgabe_seq", sequenceName = "aufgabe_sequence", allocationSize = 1)
    public Long id;

    @Column
    @EqualsAndHashCode.Include
    private String titel;

    @Enumerated(EnumType.STRING)
    private AufgabenStatus status;
}
