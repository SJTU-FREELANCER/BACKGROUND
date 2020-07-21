package com.example.demo.Controller;

import com.example.demo.DemoApplicationTests;
import com.example.demo.controller.UserController;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class UserControllerTest extends DemoApplicationTests {
//    protected MockMvc mvc;
//    @Autowired
//    WebApplicationContext webApplicationContext;
//
//    protected void setUp() {
//        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//    protected String mapToJson(Object obj) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(obj);
//    }
//    protected <T> T mapFromJson(String json, Class<T> clazz)
//            throws JsonParseException, JsonMappingException, IOException {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(json, clazz);
//    }

    @Test
    public void contextLoads(){}

    private MockMvc mockMvc;//模拟网络请求

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;

    private ObjectMapper om = new ObjectMapper();
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void getUserbyId() throws Exception{
//      MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/getUserbyId?userid=4")
//              .accept(MediaType.APPLICATION_JSON))
//              .andExpect(status().isOk())
//              .andExpect(jsonPath("$.User_Name").value("Lina Gimlet"))
//              .andReturn();

        MvcResult result1 = mockMvc.perform(get("/change_state?userid=20")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
             .andReturn();

        MvcResult result2 = mockMvc.perform(get("/alter_user_info?userid=2&username=Aurora Carding&password=9031ufxb&phone=92114684077&email=4495771966@598.com&role=0")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        MvcResult result = mockMvc.perform(get("/getUserbyId?userid=4").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        User user = om.readValue(resultContent, new TypeReference<User>() {});
        assertEquals(userService.getUserbyId(4), user);
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/getUserbyId").param("userid", "4"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("$.User_Name").value("Lina Gimlet")).andReturn();

        //        User u = new User(1500, "testname","testpassword", "testemail")


//        mockMvc.perform( MockMvcRequestBuilders
//                .get("/getUserbyId/{userid}", 4)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.User_Name")
//                        .value("Lina Gimlet"));

//        mockMvc.perform( MockMvcRequestBuilders
//                .get("/getUserbyId?userid", 4)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.User_Name").value("Lina Gimlet"));
    }
}
