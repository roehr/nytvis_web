package de.rehpic.nytvis.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.rehpic.nytvis.archive.model.InlineResponse200;
import de.rehpic.nytvis.config.NytConfig;
import de.rehpic.nytvis.mapper.DataMapper;
import de.rehpic.nytvis.model.DBArticle;
import de.rehpic.nytvis.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.stream.Collectors;

@Service
public class NytDataService {
    @Autowired
    private NytConfig nytConfig;

    @Autowired
    private ArticleRepository articleRepository;

    private DataMapper mapper = new DataMapper();
    private ObjectMapper objectMapper = new ObjectMapper()
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private String url="https://api.nytimes.com/svc/archive/v1/";

    public Flux<DBArticle> getArticlesForMonth(int year, int month){
        YearMonth ym = YearMonth.of(year,month);
        LocalDateTime start = ym.atDay(1).atStartOfDay();
        LocalDateTime end   = ym.atEndOfMonth().atTime(23,59,59);
        return articleRepository.findByPublishDateBetween(start,end)
                .switchIfEmpty(fetchArticlesFromAPI(year, month));
    }

    private Flux<DBArticle> fetchArticlesFromAPI(int year, int month){
        try {
            return articleRepository.saveAll(
                    objectMapper.readValue(new URL(url+ year +"/"+ month+".json?api-key="+nytConfig.getToken()), InlineResponse200.class)
                            .getResponse()
                            .getDocs()
                            .stream()
                            .map(article -> mapper.mapToDBArticle(article))
                            .collect(Collectors.toList())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
