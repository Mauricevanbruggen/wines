package com.wines.springbootMongodb.controller;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.wines.springbootMongodb.com.service.WineService;
import com.wines.springbootMongodb.repository.WineRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.wines.springbootMongodb.model.Wine;
import org.springframework.test.web.servlet.ResultMatcher;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = WineController.class, excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class WineControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private WineRepository wineRepository;

  @MockBean
  private WineService wineService;

  @MockBean
  private MongoTemplate mongoTemplate;

  private Wine wine1, wine2;
  private List<Wine> wineList;

//  @BeforeEach
//  public void before() {
//    wine1.setId("1");
//    wine1.setName("wine1");
//
//    wine2.setId("2");
//    wine2.setName("wine2");
//
//    wineList = Arrays.asList(
//        wine1,
//        wine2
//    );
//  }

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

    this.mockMvc.perform(get("/allwines/"))
        .andExpect(status().isOk())
        .andExpect( jsonPath("$.size()").value(wineList.size()));
  }


}
