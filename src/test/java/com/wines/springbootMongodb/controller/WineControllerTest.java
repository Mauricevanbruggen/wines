package com.wines.springbootMongodb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wines.springbootMongodb.com.service.WineService;
import com.wines.springbootMongodb.model.Wine;
import com.wines.springbootMongodb.repository.WineRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = WineController.class, excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class WineControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private WineRepository wineRepository;

  @MockBean
  private WineService wineService;

  @MockBean
  private MongoTemplate mongoTemplate;

  private Wine wine1, wine2;
  private List<Wine> wineList;

  @Test
  @DisplayName("getWines should return list of wines")
  public void getWinesShouldReturnList() throws Exception {
    Wine wine1 = new Wine();
    wine1.setId("1");
    wine1.setName("wine1");

    Wine wine2 = new Wine();
    wine2.setId("2");
    wine2.setName("wine2");

    wineList = Arrays.asList(
        wine1,
        wine2
    );
    given(wineService.getAllWines()).willReturn(wineList);

    mockMvc.perform(get("/allwines/"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()").value(wineList.size()))
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
    .andDo(print());

    assertEquals(wine1.getId(), wineList.get(0).getId());
  }

  @Test
  @DisplayName("getWineByName should return a wine")
  public void getWineByNameShouldReturnWine() throws Exception {
    Wine wine = new Wine();
    wine.setPrice(10);
    wine.setName("wine");
    String winename = "wine";

    wineList = Arrays.asList(
            wine
    );

    given(wineService.getAllByWineName("wine")).willReturn(wineList);
    given(wineRepository.save(any(Wine.class))).willReturn(wine);
    mockMvc.perform(get("/allwines/winename").param("winename", winename))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(jsonPath("$.size()").value(wineList.size()))
            .andExpect(jsonPath("$[0].price").value(wine.getPrice()))
            .andExpect(jsonPath("$[0].name").value(wine.getName()));
    assertEquals(10, wineList.get(0).getPrice());
    assertEquals("wine", wineList.get(0).getName());
  }

  @Test // test does still fail
  @DisplayName("create wine should return a wine")
  public void addWine() throws Exception {
    Wine wine = new Wine();
    wine.setPrice(10);
    wine.setName("wine");

    wineList = Arrays.asList(
        wine
    );

    given(wineService.getAllWines()).willReturn(wineList);
    given(wineRepository.save(any(Wine.class))).willReturn(wine);
    mockMvc.perform(get("/allwines/"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value(wine.getName()))
            .andExpect(jsonPath("$[0].price").value(wine.getPrice()))
        .andDo(print());
  }
}

