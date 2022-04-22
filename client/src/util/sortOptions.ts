import {Article, Keyword} from "../model/model";

export const sortByKeyWordName = (articles: Article[]) : Map<String, Article[]> => {
    const keywordMap = new Map();
    articles.forEach(article => {
        article.keywords.forEach(keyword => {
            const data = keywordMap.get(keyword.name)
            if(data){
               keywordMap.get(keyword.name).push(article);
            }
            else {
                keywordMap.set(keyword.name,[article]);
            }
        })
    })
    return keywordMap;
}

export const sortByKeyWordValue = (articles: Article[]) : Map<String, Article[]> => {
    const keywordMap = new Map();
    articles.forEach(article => {
        article.keywords.forEach(keyword => {
            const data = keywordMap.get(keyword.value)
            if(data){
                keywordMap.get(keyword.value).push(article);
            }
            else {
                keywordMap.set(keyword.value,[article]);
            }
        })
    })
    return keywordMap;
}