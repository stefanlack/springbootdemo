package com.opitzconsulting.springbootdemo.aufgaben;

import com.opitzconsulting.springbootdemo.EmbeddedDatabaseTest;
import com.opitzconsulting.springbootdemo.SpringbootdemoApplication;
import com.opitzconsulting.springbootdemo.aufgaben.domain.AufgabeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@EmbeddedDatabaseTest
@SpringBootTest(classes = SpringbootdemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AufgabenServiceIntegrationTest {

    @Autowired
    private AufgabenService aufgabenService;

    @Test
    void loadsExampleData() {
        List<AufgabeDto> actual = aufgabenService.getAll();

        assertThat(actual).hasSize(3);
    }
}