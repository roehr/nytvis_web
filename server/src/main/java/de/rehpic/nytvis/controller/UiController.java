package de.rehpic.nytvis.controller;

import de.rehpic.nytvis.model.DBArticle;
import de.rehpic.nytvis.service.NytDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class UiController {

    @Autowired
    private NytDataService nytDataService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping( "/data/{year}/{month}")
    public Flux<DBArticle> getData(@PathVariable int year, @PathVariable int month){
     return nytDataService.getArticlesForMonth(year,month);
    }
}
