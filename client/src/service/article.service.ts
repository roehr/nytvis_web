import {Article} from "../model/model";

export const getArticles = async (year:number, month:number) => {
    const response = await fetch(`http://localhost:8080/data/${year}/${month}`)
    return await response.json() as Article[]
}