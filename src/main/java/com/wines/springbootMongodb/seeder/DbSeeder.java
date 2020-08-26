package com.wines.springbootMongodb.seeder;

import com.wines.springbootMongodb.model.Review;
import com.wines.springbootMongodb.model.Wine;
import com.wines.springbootMongodb.model.Winemaker;
import com.wines.springbootMongodb.repository.WineRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {

  private WineRepository wineRepository;

  public  DbSeeder(WineRepository wineRepository) {
    this.wineRepository = wineRepository;
  }

  @Override
  public void run(String... strings) throws Exception {

    Wine polRoger = new Wine(
        "Pol Roger", 2012, 45,
        new Winemaker(
            "Bob", "French", 60),
        Arrays.asList(
            new Review("Alice", 8, true),
            new Review("Henk", 6, false),
            new Review("Dennis", 7, true)
        ));

    Wine sancerre = new Wine(
        "Domaine Thomas", 2015, 17,
        new Winemaker("Chris", "German", 34),
        Arrays.asList(
            new Review("Dave", 9, true),
            new Review("Carl", 8, false),
            new Review("Noa", 7, true),
            new Review("Tina", 8, true),
            new Review("Henk", 6, false),
            new Review("Dennis", 7, true)
        ));

    Wine gavi = new Wine(
        "Gavi di Gavi", 2017, 17,
        new Winemaker(
            "Joanne", "Italian", 26),
        Arrays.asList(
            new Review("Dennis", 7, true)
        ));

    Wine ontanon = new Wine(
        "Ontanon Rioja", 2018, 12,
        new Winemaker(
            "Christina", "Spanish", 31),
        Arrays.asList(
            new Review("Dimitri", 8, true)
        ));

    this.wineRepository.deleteAll();

    List<Wine> wines = Arrays.asList(polRoger, sancerre, gavi, ontanon);
     this.wineRepository.saveAll(wines);
  }


}
