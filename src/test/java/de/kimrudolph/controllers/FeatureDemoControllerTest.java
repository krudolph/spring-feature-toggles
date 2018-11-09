package de.kimrudolph.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FeatureDemoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void car() throws Exception {

        mvc.perform(get("/car")).andExpect(status().isOk())
           .andExpect(view().name("index"));
    }

    @Test
    public void spaceship() throws Exception {

        mvc.perform(get("/spaceship")).andExpect(status().is4xxClientError());
    }

    @Test
    public void planet() throws Exception {

        mvc.perform(get("/planet")).andExpect(status().is4xxClientError());
    }
}