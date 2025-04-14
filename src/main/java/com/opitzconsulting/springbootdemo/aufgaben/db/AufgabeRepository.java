package com.opitzconsulting.springbootdemo.aufgaben.db;

import com.opitzconsulting.springbootdemo.aufgaben.domain.Aufgabe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AufgabeRepository extends JpaRepository<Aufgabe, Long> {


}
