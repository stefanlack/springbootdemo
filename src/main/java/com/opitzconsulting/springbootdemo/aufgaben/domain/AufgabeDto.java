package com.opitzconsulting.springbootdemo.aufgaben.domain;

import com.opitzconsulting.springbootdemo.common.FormattersUtil;
import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "with")
@Getter
public class AufgabeDto {

    private Long id;
    private String titel;
    private AufgabenStatus status;
    private String erstelltAm;
    private String aktualisiertAm;

    public static AufgabeDto fromAufgabe(Aufgabe aufgabe) {
        return builder()
                .withId(aufgabe.getId())
                .withTitel(aufgabe.getTitel())
                .withErstelltAm(FormattersUtil.format(aufgabe.getCreatedAt()))
                .withAktualisiertAm(FormattersUtil.format(aufgabe.getUpdatedAt()))
                .withStatus(aufgabe.getStatus())
                .build();
    }
}
