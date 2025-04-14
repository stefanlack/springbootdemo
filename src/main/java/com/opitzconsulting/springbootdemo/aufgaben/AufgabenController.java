package com.opitzconsulting.springbootdemo.aufgaben;


import com.opitzconsulting.springbootdemo.aufgaben.domain.AufgabeDto;
import com.opitzconsulting.springbootdemo.aufgaben.domain.AufgabenStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aufgaben")
@RequiredArgsConstructor
public class AufgabenController {

    private final AufgabenService aufgabenService;


    @Operation(summary = "Liefert alle Aufgaben zurück")
    @GetMapping
    public List<AufgabeDto> getAll() {
        return aufgabenService.getAll();
    }

    @Operation(summary = "Erzeugt eine neue Aufgabe mit dem übergebenen Titel. Der Status der Aufgabe ist offen. Die erstellte Aufgabe wird als Ergebnis zurückgegeben.")
    @PostMapping(path = "/add")
    public ResponseEntity<AufgabeDto> addAufgabe(@RequestBody String titel) {
        return ResponseEntity.ok().body(aufgabenService.addAufgabe(titel));
    }

    @Operation(summary = "Ändert den Status der Aufgabe mit der übergebenen ID auf den übergebenen Status.")
    @PutMapping(path = "/{id}/status")
    public void changeStatus(@PathVariable Long id, @RequestBody AufgabenStatus status) {
        aufgabenService.changeStatus(id, status);
    }
}
