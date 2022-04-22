package de.rehpic.nytvis.repository;

import de.rehpic.nytvis.model.DBArticle;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Repository
public interface ArticleRepository extends ReactiveMongoRepository<DBArticle, String> {
    public Flux<DBArticle> findByPublishDateBetween(LocalDateTime from, LocalDateTime to);
}
