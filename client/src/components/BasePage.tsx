import React from "react";
import {Article} from "../model/model";
import {getArticles} from "../service/article.service";
import {YearMonthInput} from "./YearMonthInput";
import {KeyWordTable} from "./KeyWordTable";

const BasePage = () => {
    const [articles, setArticles] = React.useState([] as Article[])
    const onDateEntered = (year:number, month:number) => {
        console.log(`${year} - ${month}`)
        getArticles(year,month)
            .then(data=> setArticles(data))
            .catch(e=> console.log(e))
    }

return (
    <div className="base">
        <YearMonthInput onDateEntered={onDateEntered}/>
        <KeyWordTable articles={articles}/>
    </div>
)
}

export {BasePage}