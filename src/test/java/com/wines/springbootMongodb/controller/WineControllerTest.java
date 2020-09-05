package com.wines.springbootMongodb.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wines.springbootMongodb.com.service.WineService;
import com.wines.springbootMongodb.repository.WineRepository;
import java.util.ArrayList;
import java.util.List;
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
import com.wines.springbootMongodb.model.Wine;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = WineController.class, excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class WineControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private WineRepository wineRepository;

  @MockBean
  private MongoTemplate mongoTemplate;

  private Wine wine;
  private List<Wine> wineList;

  @Test
  @DisplayName("getWines should return list of wines")
  public void getWinesShouldReturnList() throws Exception {
    
  }


}
