package com.opitzconsulting.springbootdemo.aufgaben;

import com.opitzconsulting.springbootdemo.aufgaben.db.AufgabeRepository;
import com.opitzconsulting.springbootdemo.aufgaben.domain.Aufgabe;
import com.opitzconsulting.springbootdemo.aufgaben.domain.AufgabeDto;
import com.opitzconsulting.springbootdemo.aufgaben.domain.AufgabenStatus;
import com.opitzconsulting.springbootdemo.common.error.exceptions.DemoEntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AufgabenService {

    private final AufgabeRepository aufgabeRepository;

    public List<AufgabeDto> getAll() {
        return aufgabeRepository.findAll()
                .stream().map(AufgabeDto::fromAufgabe)
                .toList();
    }

    public AufgabeDto addAufgabe(String titel) {
        Aufgabe aufgabe = Aufgabe.builder().withTitel(titel)
                .withStatus(AufgabenStatus.NEU)
                .build();
        aufgabe = aufgabeRepository.save(aufgabe);
        return AufgabeDto.fromAufgabe(aufgabe);
    }

    public void changeStatus(Long id, AufgabenStatus status) {
        Aufgabe aufgabe = aufgabeRepository.findById(id)
                .orElseThrow(() -> new DemoEntityNotFoundException("Aufgabe", id));
        aufgabe.setStatus(status);
        aufgabeRepository.save(aufgabe);

    }
}
