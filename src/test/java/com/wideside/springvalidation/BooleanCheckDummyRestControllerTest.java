package com.wideside.springvalidation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class BooleanCheckDummyRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void manageTrueValueLowercase() throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/booleanCheck/true").contentType(MediaType.APPLICATION_JSON_UTF8));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void manageFalseValueLowercase() throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/booleanCheck/false").contentType(MediaType.APPLICATION_JSON_UTF8));
        resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void manageTrueValueUppercase() throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/booleanCheck/TRUE").contentType(MediaType.APPLICATION_JSON_UTF8));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void manageFalseValueUppercase() throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/booleanCheck/FALSE").contentType(MediaType.APPLICATION_JSON_UTF8));
        resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void manageNullValue() throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/booleanCheck/").contentType(MediaType.APPLICATION_JSON_UTF8));
        resultActions.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}
