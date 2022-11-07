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
import com.example.cab.model.RideDetails;
import com.example.cab.repository.CabDriverRepository;
import com.example.cab.service.CabBookServiceImpl;
import com.example.cab.service.CabDriverServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CabDriverController.class)
class CabDriverControllerTests {

	private List<CabDriver> driverList = new ArrayList<>();
	private List<RideDetails> rideList = new ArrayList<>();
	private CabDriver cabDriver;
	private RideDetails rideDetails;

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
		CabDriver cabDriver1 = new CabDriver("Driver1", "M", 22,"Swift, KA-01-12345",new Coordinate(10,1), true);
		CabDriver cabDriver2 = new CabDriver("Driver2", "M", 29,"Swift, KA-01-12345",new Coordinate(11,10), true);
		CabDriver cabDriver3 = new CabDriver("Driver3", "M", 29,"Swift, KA-01-12345",new Coordinate(5,3), true);
		CabDriver cabDriver = new CabDriver("Driver4", "M", 23, "Swift, KA-01-12345", new Coordinate(12, 13), true);
		driverList.add(cabDriver);
		driverList.add(cabDriver1);
		driverList.add(cabDriver2);
		driverList.add(cabDriver3);
		
		//ride details for find and choose rides
		rideDetails = new RideDetails("Abhishek",new Coordinate(0, 0), new Coordinate(20, 1));
		rideList.add(rideDetails);
		RideDetails rideDetails2 = new RideDetails("Rahul",new Coordinate(10, 0), new Coordinate(15, 3));
		rideList.add(rideDetails2);
		RideDetails rideDetails3 = new RideDetails("Nandini",new Coordinate(15, 6), new Coordinate(5, 3));
		rideList.add(rideDetails3);
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
		String cabJson = result.getResponse().getContentAsString();
		Assertions.assertThat(cabJson).isNotEmpty();
		Assertions.assertThat(cabJson).isEqualToIgnoringCase(mapper.writeValueAsString(cabDriver));
	}
	
	@Test
	void findRidesTest() throws Exception{
		Mockito.when(cabBookService.findRides(rideDetails)).thenReturn(driverList);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/find_rides").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(cabDriver).getBytes(StandardCharsets.UTF_8))
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		Assertions.assertThat(result).isNotNull();
		String userJson = result.getResponse().getContentAsString();
		Assertions.assertThat(userJson).isNotEmpty();	
	}
	
	

}
