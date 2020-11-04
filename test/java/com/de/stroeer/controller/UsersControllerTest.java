package com.de.stroeer.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.de.stroeer.model.Users;
import com.de.stroeer.service.UserService;





@RunWith(SpringRunner.class)
@WebMvcTest(value = UsersController.class)
public class UsersControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;
    
    @Test
    public void getAllUsersTest() throws Exception{
    	List<Users> listUsers=new ArrayList<>();
    	
    	Users user1=new Users();
    	user1.setFirstName("ak");
    	user1.setLastName("ln");
    	user1.setIban(123l);
    	
    	listUsers.add(user1);
    	
    	Mockito.when(
    			service.getAllUsers()).thenReturn(listUsers);
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/users/").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        int response = result.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), response);
    }
    
    @Test
    public void createOrUpdateEmployeeTest() throws Exception{
    	List<Users> listUsers=new ArrayList<>();
    	Users user=new Users();
    	user.setFirstName("ak");
    	user.setLastName("ln");
    	user.setIban(123l);
    	listUsers.add(user);
    	
    	Mockito.when(
    			service.createOrUpdateUsers(Mockito.any(Users.class))).thenReturn(user);
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/users/iban").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        int response = result.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), response);
    }
}
