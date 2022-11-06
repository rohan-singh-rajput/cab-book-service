package com.example.cab.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.cab.model.CabDriver;
import com.example.cab.model.Coordinate;
import com.example.cab.repository.CabDriverRepository;
import com.example.cab.service.CabBookServiceImpl;
import com.example.cab.service.CabDriverServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CabDriverController.class)
class CabDriverControllerTests {

	private List<CabDriver> driverList = new ArrayList<>();
	private CabDriver cabDriver;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private CabDriverServiceImpl cabDriverService;
	@MockBean
	private CabBookServiceImpl cabBookService;

	@MockBean
	private CabDriverRepository cabDriverRepository;

	@BeforeEach
	void setUp() {
		cabDriver = new CabDriver("test 1", "M", 23, "Swift, KA-01-12345", new Coordinate(12, 13), true);
		CabDriver cabDriver = new CabDriver("Rohan", "M", 23, "Swift, KA-01-12345", new Coordinate(12, 13), true);
		driverList.add(cabDriver);
	}

	@Test
	// @Disabled
	void getCabsTest() throws Exception {

		Mockito.when(cabDriverService.getAllCabDrivers()).thenReturn(driverList);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/cabs").contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		Assertions.assertThat(result).isNotNull();
		String userJson = result.getResponse().getContentAsString();
		Assertions.assertThat(userJson).isEqualToIgnoringCase(mapper.writeValueAsString(driverList));
	}

	@Test
	// @Disabled
	void createCabTest() throws Exception {

		Mockito.when(cabDriverService.createCabDriver(Mockito.any(CabDriver.class))).thenReturn(cabDriver);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/cab").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(cabDriver).getBytes(StandardCharsets.UTF_8))
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		Assertions.assertThat(result).isNotNull();
		String userJson = result.getResponse().getContentAsString();
		Assertions.assertThat(userJson).isNotEmpty();
		Assertions.assertThat(userJson).isEqualToIgnoringCase(mapper.writeValueAsString(cabDriver));
	}
	
	

}
