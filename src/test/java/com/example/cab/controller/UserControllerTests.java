package com.example.cab.controller;


import java.nio.charset.StandardCharsets;
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

import com.example.cab.model.User;
import com.example.cab.repository.UserRepository;
import com.example.cab.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper mapper;
	
	@MockBean
	private UserServiceImpl userService;
	
	@MockBean
	private UserRepository userRepository;
	
	private List<User> users;
	private User user;
	
    @BeforeEach
    void setUp(){
    	 users = List.of(new User("Test 1", "M", 21),
        		new User("Test 2", "F", 22));  
    	 
    	 user = new User("test 1","M", 23);
    }

    @Test
    //@Disabled
    void getUsersTest() throws Exception {

        Mockito.when(userService.getUsers()).thenReturn(users);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertThat(result).isNotNull();
        String userJson = result.getResponse().getContentAsString();
        Assertions.assertThat(userJson).isEqualToIgnoringCase(mapper.writeValueAsString(users));
    }

    @Test
    //@Disabled
    void createUserTest() throws Exception {

        Mockito.when(userService.addUser(Mockito.any(User.class))).thenReturn(user);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user).getBytes(StandardCharsets.UTF_8))
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertThat(result).isNotNull();
        String userJson = result.getResponse().getContentAsString();
        Assertions.assertThat(userJson).isNotEmpty();
        Assertions.assertThat(userJson).isEqualToIgnoringCase(mapper.writeValueAsString(user));
    }
}

