import logo from './logo.svg';
import React from 'react';
import './App.css';

import List from 'components/List';
import listMovies from "movies.json";
import EmptyState from 'components/EmptyState';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

export default class App extends React.Component {
  state = {
    favItems: [],
    isToggleOn: true,
    isFavItems : true
  };
  
  getToggleName  = () => this.state.isToggleOn ? "fa fa-toggle-off" : "fa fa-toggle-on"
  render() {
    const { favItems } = this.state;
    const toggleName = this.getToggleName();
    
    return (
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong> application)
        </p>
        <div className="row">
          
        <div className="col-sm-6">
        
        <div id="btn-toggle text-center ml-3" onClick={this.handleClick} className={toggleName} style={{fontSize: 40, marginLeft: 600}}>
        {/* { this.state.isToggleOn ? 'ON' : 'OFF'} */}
        
        </div>
        </div>
        <div className="col-sm-2">
        <p className="text-center text-secondary text-sm" style={{marginRight: 80, marginTop: 8}}>Hide Favorites</p>
        </div>
        </div>

        <div className="row">
          <button hidden={this.state.isFavItems} className="btn btn-primary" onClick={this.handleDeleteFav} style={{marginLeft: 600}}>Delete All Favorites</button>
        </div>
        <div className="container pt-3">
        
          <div className="row">
            <div className="col-sm">
              <List
                title="List Movies"
                items={listMovies}
                onItemClick={this.handleItemPlus}
                />
            </div>
            <div className="col-sm" id="fav">
          
              <div id="hapus"> </div>
                <List
                title="My Favorites"
                items={favItems}
                onItemClick={this.handleItemMinus}
                />
                <EmptyState empty={this.state.favItems.length > 0} />
            </div>
          </div>
        </div>
      </div>
    );
  }
  handleClick =  () => {
    var x = document.getElementById("fav");
    if(this.state.isToggleOn){
      x.style.display = "none";
    }else{
      x.style.display = "block";
    }
    this.setState({ isToggleOn: !this.state.isToggleOn});
  }

  handleItemPlus = (item) => {
    const newItems = [ ... this.state.favItems];
    const newItem = { ... item};
    //find item index using id
    const targetInd = newItems.findIndex((it) => it.id === newItem.id);

    if (targetInd < 0 ) newItems.push(newItem);

    // trigger set state
    this.setState({ favItems: newItems, isFavItems:false});
    // if(this.state.favItems.length > 0)  { document.getElementById("hapus").innerHTML = "<button className='btn' this.handleDeleteFav = {this.state.favItems} >Delete All Fav</button>";    }
  }

  handleItemMinus= (item) => {
    const newItems = [ ... this.state.favItems];
    const newItem = { ... item};
    //find item index using id
    const targetInd = newItems.findIndex((it) => it.id === newItem.id);


    newItems.splice(targetInd, 1); //delete 1 item at index target 
    console.log(this.state.favItems.length)
    if(this.state.favItems.length > 1) {
      this.setState({ favItems: newItems, isFavItems:false});
    } else{
      this.setState({ favItems: newItems, isFavItems:true});
    }
    // if(this.state.favItems.length > 0)  { document.getElementById("hapus").innerHTML = "<button className='btn' this.handleDeleteFav = {this.state.favItems} >Delete All Fav</button>";    }
  }


  handleDeleteFav = (items) => {
      this.setState({ favItems: [], isFavItems:true});
  }
}

