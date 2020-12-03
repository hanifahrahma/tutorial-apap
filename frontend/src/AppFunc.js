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
 const [isToggle, setToggle] = useState(true);
 const [btnFav, setBtnFav] = useState(true);
 const [classBtn, setClassBtn] = useState("fa fa-toggle-off");
 
 
 function handleItemPlus(item) {
    // immutability
    const newItems = [...favItems];
    const newItem = { ...item };
    // Find index of item with id
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);
    // trigger to set a new state
    setFavItems(newItems);
    setBtnFav(false);
 }
 function handleItemMinus(item) {
    // immutability
    const newItems = [...favItems];
    const newItem = { ...item };
    // Find index of item with id
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    newItems.splice(targetInd, 1); // delete 1 item at index targetInd
    // trigger to set a new state
    
    if(favItems.length > 1){
        setFavItems(newItems);   
    }else{
        setFavItems(newItems);  
        setBtnFav(true);
    }
 }
 function handleClickToggle() {
    var x = document.getElementById("fav2");
    if(isToggle){
      x.style.display = "none";
      setClassBtn("fa fa-toggle-on")
    }else{
      x.style.display = "block";
      setClassBtn("fa fa-toggle-off")
    }
    setToggle(!isToggle);
    // console.log(isToggle)
  }

  function handleClearFav() {
    setFavItems([]);
    setBtnFav(true);
}
 return (
    <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
        (This is a <strong>function-based</strong> application)
        </p>
        <div className="row">
        <div className="col-sm-6">
        <div id="btn-toggle text-center ml-3" onClick={handleClickToggle} className={classBtn} style={{fontSize: 40, marginLeft: 600}}>
        </div>
        </div>
        <div className="col-sm-2">
        <p className="text-center text-secondary text-sm" style={{marginRight: 80, marginTop: 8}}>Hide Favorites</p>
        </div>
        </div>
        <div className="row">
          <button hidden={btnFav} className="btn btn-primary" onClick={handleClearFav} style={{marginLeft: 600}}>Delete All Favorites</button>
        </div>
        <div className="container pt-3">
            <div className="row">
                <div className="col-sm">
                <List
                title="List Movies"
                items={listMovies}
                onItemClick={handleItemPlus}
                />
                </div>
                <div className="col-sm" id="fav2">
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