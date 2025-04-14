package com.opitzconsulting.springbootdemo.aufgaben.domain;


import com.opitzconsulting.springbootdemo.common.db.AbstractBaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
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
