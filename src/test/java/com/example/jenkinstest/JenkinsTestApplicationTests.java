package com.example.jenkinstest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class JenkinsTestApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllProducts() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/product")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
    }

    @Test
    void getSingleProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/product/1")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
    }

    @Test
    void returnsNotFoundProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/product/4")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isNotFound())
                        .andReturn();
    }

    @Test
    void addNewProduct() throws Exception{
        String newProduct = """
                                {
                                    "name" : "candy",
                                    "code" : "1234-5678-9012-3333",
                                    "description" : "Something sweet"
                                }
                                """;
        mockMvc.perform(MockMvcRequestBuilders.post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newProduct)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
    }

}
