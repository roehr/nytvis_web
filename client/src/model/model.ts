export interface Article {
    mainHeadline: string;
    printHeadline: string;
    wordCount: number;
    byLine: string;
    artAbstract: string;
    leadParagraph: string;
    snippet: string;
    webUrl: string;
    keywords: Keyword[];
    newsDesk: string;
    source: string;
    publishDate: Date;
}

export interface Keyword{
    name: keywordname,
    value: string
}

export enum keywordname {
    subject="subject",
    glocations="glocations",
    organizations="organizations",
    persons="persons",
    creative_works="creative_works"
}