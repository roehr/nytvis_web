import React from "react";

interface YearMonthInputProps{
    onDateEntered: (year:number, month:number) => void
}

const YearMonthInput = (props:YearMonthInputProps) => {
    const  onMonthChanged =(event: React.ChangeEvent<HTMLInputElement>) => {
        const date= event.target.value.split('-');
        props.onDateEntered(Number.parseInt(date[0]),Number.parseInt(date[1]))
    }


    return <>
        <input type={"month"} onChange={onMonthChanged}/>
    </>
}

export {YearMonthInput}