package de.rehpic.nytvis.mapper;

import de.rehpic.nytvis.archive.model.Article;
import de.rehpic.nytvis.archive.model.Byline;
import de.rehpic.nytvis.model.DBArticle;
import de.rehpic.nytvis.model.Keyword;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DataMapper {
    public DataMapper(){}

    public List<DBArticle> mapArticlesToDB(List<Article> articles) {
        return articles.stream().map(article -> mapToDBArticle(article)).collect(Collectors.toList());
    }

    public DBArticle mapToDBArticle(Article article) {
        return new DBArticle(
                article.getHeadline().getMain(),
                article.getHeadline().getPrintHeadline(),
                article.getWordCount(),
                writeByLine(article.getByline()),
                article.getAbstract(),
                article.getLeadParagraph(),
                article.getSnippet(),
                article.getWebUrl(),
                mapKeyWords(article.getKeywords()),
                article.getNewsDesk(),
                LocalDateTime.parse(article.getPubDate().substring(0,19))
        );
    }
    private  String writeByLine (Byline byline) {
        String persons = "";
       byline.getPerson().stream().map(person -> persons+person.getLastname());
        return byline.getOriginal()+" "+byline.getOrganization() + " " + persons;
    }
    private  List<Keyword> mapKeyWords (List<de.rehpic.nytvis.archive.model.Keyword> keywords) {
        return keywords.stream().map(keyword -> new Keyword(keyword.getName(), keyword.getValue())).collect(Collectors.toList());
    }

}
