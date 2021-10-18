package fi.harkka.catfood;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import fi.harkka.catfood.domain.CatRepository;
import fi.harkka.catfood.domain.FoodRepository;
import fi.harkka.catfood.domain.KindRepository;

import fi.harkka.catfood.web.RESTContoroller;

@ExtendWith(SpringExtension.class)
@EnableWebMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTest {

	@Autowired
	public FoodRepository frepository;
	@Autowired
	public CatRepository crepository;
	@Autowired
	public KindRepository krepository;
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	//uses springboots mockserver instead of a real one
	private MockMvc mockMvc;
	
	private RESTContoroller controller;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	//Test that the RESTapi-status is ok
	@Test
	public void statusOk() throws Exception {
		mockMvc.perform(get("/cats")).andExpect(status().isOk());
	}
	
	@Test
	public void apistatusOk() throws Exception {
		mockMvc.perform(get("/api/cats")).andExpect(status().isOk());
	}
	
	//Test that the received data is Json
	@Test
	public void responseTypeApplicationJson() throws Exception {
		mockMvc.perform(get("/cats"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void responseTypeApplicationJsonById() throws Exception {
		mockMvc.perform(get("/cat/1"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
