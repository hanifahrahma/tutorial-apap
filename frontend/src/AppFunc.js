import React, { useState } from "react";
import List from "./components/List";
import listMovies from "movies.json";
import "./App.css";
import EmptyState from "components/EmptyState";
/**
* Building React component using functional programming paradigm
*/
function App() {
// Btw, this is hooks. useState function returns an array
// contains the state and a function to set the state -> [state, setState].
// What you see below is array destruction.
// Let say you have an array const arr = ["aaa", "bbb"], to access the item
// we can use index arr[0] OR destruct it like below
// const [varName, index1] = arr, variable varName is guaranteed to get the value of index 0 OR "aaa"
// here is the illustration for this situation
// below is the return value of useState
// [favItems, setFavItems] = [state, setState]
 const [favItems, setFavItems] = useState(() => []);
//  const [isToggle, setToggle] = useState(true);
 
 function handleItemPlus(item) {
    // immutability
    const newItems = [...favItems];
    const newItem = { ...item };
    // Find index of item with id
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);
    // trigger to set a new state
    setFavItems(newItems);
 }
 function handleItemMinus(item) {
    // immutability
    const newItems = [...favItems];
    const newItem = { ...item };
    // Find index of item with id
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    newItems.splice(targetInd, 1); // delete 1 item at index targetInd
    // trigger to set a new state
    setFavItems(newItems);
 }
// const toggleName = () => {
//     isToggleOn ? "fa fa-toggle-off" : "fa fa-toggle-on" };

// function handleClick() {
//         var x = document.getElementById("fav");
//         // var y = document.getElementById("btn-toggle");
//         const isTog = isToggle;
//         if(isToggle){
//           x.style.display = "none";
//         }else{
//           x.style.display = "block";
//         }
//         setToggle({ isToggle: !isTog});
//       }
//  const toggleName = this.getToggleName();
 return (
    <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
        (This is a <strong>function-based</strong> application)
        </p>
        
        <div className="container pt-3">
            <div className="row">
                <div className="col-sm">
                <List
                title="List Movies"
                items={listMovies}
                onItemClick={handleItemPlus}
                />
                </div>
                <div className="col-sm">
                <List
                title="My Favorites"
                items={favItems}
                onItemClick={handleItemMinus}
                />
                <EmptyState empty={favItems.length > 0} />
                </div>
            </div>
        </div>
    </div>
 );
}
export default App;