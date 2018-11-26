package com.wideside.springvalidation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BooleanCheckWithBodyDummyRestControllerTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper objectMapper;
	private BooleanBody booleanBody;

	@Before
	public void setUp() throws Exception {
		booleanBody = new BooleanBody();
	}

	@Test
	public void manageTrueValue() throws Exception {
		booleanBody.setBooleanValue(Boolean.TRUE);
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/booleanCheckWithBody")
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.content(objectMapper.writeValueAsString(booleanBody)));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void manageFalseValue() throws Exception {
		booleanBody.setBooleanValue(Boolean.FALSE);
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/booleanCheckWithBody")
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.content(objectMapper.writeValueAsString(booleanBody)));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void manageNullValue() throws Exception {
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/booleanCheckWithBody")
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.content(objectMapper.writeValueAsString(booleanBody)));
		resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void manageEmptyBody() throws Exception {
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/booleanCheckWithBody")
			.contentType(MediaType.APPLICATION_JSON_UTF8));
		resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

}
