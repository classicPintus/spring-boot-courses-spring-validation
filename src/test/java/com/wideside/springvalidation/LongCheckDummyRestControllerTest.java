package com.wideside.springvalidation;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class LongCheckDummyRestControllerTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void manageTrueValueLowercase() throws Exception {
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/longCheck/1").contentType(MediaType.APPLICATION_JSON_UTF8));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void manageFalseValueLowercase() throws Exception {
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/longCheck/-20").contentType(MediaType.APPLICATION_JSON_UTF8));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void manageTrueValueUppercase() throws Exception {
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/longCheck/100").contentType(MediaType.APPLICATION_JSON_UTF8));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void manageFalseValueUppercase() throws Exception {
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/longCheck/101").contentType(MediaType.APPLICATION_JSON_UTF8));
		resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
