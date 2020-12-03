import React from "react";

function EmptyClass(props) {
    return (
        <>
    <h3 className="text-center">Belum ada Item yang dipilih</h3>
    <p className="text-center">Klik salah satu item di List Movies</p>
    </>);
  }
  
export default function EmptyState({ empty }){
    const emptyState = empty;
    if (!emptyState) {
        return <EmptyClass />;
    }
    else {
        return(<h1></h1>)
    }
   
    // checkEmpty = (items) => {
    //     const favItems = [ ... items];
    //     if (favItems.length > 0){
            
    //     }
    // }
}