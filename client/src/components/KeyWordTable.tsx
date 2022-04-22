import React from "react";
import {sortByKeyWordName} from "../util/sortOptions";
import {Article} from "../model/model";

interface KeyWordTableProps{
    articles: Article[];
}

const KeyWordTable = (props: KeyWordTableProps) => {
    const [dataMap, setDataMap]= React.useState(new  Map<String, Article[]>()) ;
    React.useEffect(()=> {
        setDataMap( sortByKeyWordName(props.articles))
    }, [props.articles])

    React.useEffect(()=> {
        console.log("Datamap changed");
        console.log(dataMap);
    }, [dataMap])
    const renderData = (keyword:String, length: number) => {
        return (
            <div style={{display:"flex", justifyContent:"space-between"}}>
                <div>{keyword}</div>
                <div>{length}</div>
            </div>
        )
    }



    return (
        <div className="basegrid">
            { Array.from(dataMap).map(([key, value]) => renderData(key, value.length)
            )}
        </div>
    )
}

export {KeyWordTable}