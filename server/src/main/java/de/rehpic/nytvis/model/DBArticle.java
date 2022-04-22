package de.rehpic.nytvis.model;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Document(value="articles")
public class DBArticle {
    @Id
    private String id;
    private String mainHeadline;
    private String printHeadline;
    private int wordCount;
    private String byLine;
    private String artAbstract;
    private String leadParagraph;
    private String snippet;
    private String webUrl;
    private List<Keyword> keywords;
    private String newsDesk;

    private String source;

    private LocalDateTime publishDate;

    public DBArticle( String mainHeadline, String printHeadline, int wordCount, String byLine, String artAbstract, String leadParagraph, String snippet, String webUrl, List<Keyword> keywords, String newsDesk, LocalDateTime publishDate) {
        this.id = UUID.randomUUID().toString();
        this.mainHeadline = mainHeadline;
        this.printHeadline = printHeadline;
        this.wordCount = wordCount;
        this.byLine = byLine;
        this.artAbstract = artAbstract;
        this.leadParagraph = leadParagraph;
        this.snippet = snippet;
        this.webUrl = webUrl;
        this.keywords = keywords;
        this.newsDesk = newsDesk;
        this.publishDate = publishDate;
        this.source="NYT Archive API";
    }

    public String getMainHeadline() {
        return mainHeadline;
    }

    public String getPrintHeadline() {
        return printHeadline;
    }

    public int getWordCount() {
        return wordCount;
    }

    public String getByLine() {
        return byLine;
    }

    public String getArtAbstract() {
        return artAbstract;
    }

    public String getLeadParagraph() {
        return leadParagraph;
    }

    public String getSnippet() {
        return snippet;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public String getNewsDesk() {
        return newsDesk;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }
}
