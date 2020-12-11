import React, {Component} from "react"
import Hotel from "../../components/Hotel";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig"
import Button from "../../components/Button";
import Modal from "../../components/Modal";


class HotelList extends Component {
    constructor(props){
        super(props);
        this.state = {
            hotels: [],
            isLoading: false,
            isCreate: false,
            namaHotel: "",
            alamat: "",
            nomorTelepon: "",
            isEdit: false,
            keyword: "",
            hotelsDefault : [],
            currentPage: 1,
            todosPerPage: 5,
            // hotelPage : []
        };
        this.handleAddHotel = this.handleAddHotel.bind(this)
        this.handleCancel = this.handleCancel.bind(this)
        this.handleChangeField = this.handleChangeField.bind(this)
        this.handleAddHotel = this.handleAddHotel.bind(this)
        this.handleSubmitAddHotel = this.handleSubmitAddHotel.bind(this)
        this.handleSubmitEditHotel = this.handleSubmitEditHotel.bind(this)
        this.handleDeleteHotel = this.handleDeleteHotel.bind(this)
        this.handleEditHotel = this.handleEditHotel.bind(this)
        this.updateSearch = this.updateSearch.bind(this)
        this.handleClick = this.handleClick.bind(this)
        // this.pagination = this.pagination.bind(this)
        // this.handleClickLoading = this.handleClickLoading.bind(this)
    }
    componentDidMount(){
        // console.log("componentDidMount()")
        this.loadData();
        
    }
    async loadData() {
        try {
            const { data } = await APIConfig.get("/hotels");
            this.setState({ hotels: data,
            hotelsDefault: data });
            // this.pagination();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }
    handleClick(event) {
        this.setState({
          currentPage: Number(event.target.id)
        });
        // this.pagination();
      }
    // async loadKamar(idHotel) {
    //     try {
    //         const { data } = await APIConfig.get(`/hotel/${idHotel}`);
    //         return data
    //     } catch (error) {
    //         alert("Oops terjadi masalah pada server");
    //         console.log(error);
    //     }
    // }
    
    handleAddHotel(){
        this.setState({
            isCreate: true,
            namaHotel: "",
            alamat: "",
            nomorTelepon: "",
        })

    }
    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate: false });
        this.setState({isEdit : false});
    }
    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }
    async handleSubmitAddHotel(event) {
        event.preventDefault();
        try {
            const data = {
            namaHotel: this.state.namaHotel,
            alamat: this.state.alamat,
            nomorTelepon: this.state.nomorTelepon,
        };
        await APIConfig.post("/hotel", data);
        this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }
    handleEditHotel(hotel) {
        this.setState({
        isEdit: true,
        id: hotel.id,
        namaHotel: hotel.namaHotel,
        alamat: hotel.alamat,
        nomorTelepon: hotel.nomorTelepon,
        });
    }
    async handleSubmitEditHotel(event) {
        event.preventDefault();
        try {
        const data = {
        namaHotel: this.state.namaHotel,
        alamat: this.state.alamat,
        nomorTelepon: this.state.nomorTelepon,
        };
        await APIConfig.put(`/hotel/${this.state.id}`, data);
        this.loadData();
        } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        }
        this.handleCancel(event);
    }
    async handleDeleteHotel(id) {
        try {
        await APIConfig.delete(`/hotel/${id}`);
        this.loadData();
        } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        }
    }
    async updateSearch(e) {
        console.log(e.target.value)
        this.setState({keyword: e.target.value})
        const hotelFiltered = this.state.hotels.filter(hotel =>  hotel.namaHotel.toLowerCase().includes(e.target.value.toLowerCase()))
        this.setState({hotelsDefault: hotelFiltered})
        // this.pagination();
    }
    
    // pagination(){
    //     const indexOfLastTodo = this.state.currentPage * this.state.todosPerPage;
    //     const indexOfFirstTodo = indexOfLastTodo - this.state.todosPerPage;
    //     const currentTodos = this.state.hotelsDefault.slice(indexOfFirstTodo, indexOfLastTodo);
    //     const pageNumbers = [];
    //     for (let i = 1; i <= Math.ceil(this.state.hotels.length / this.state.todosPerPage); i++) {
    //       pageNumbers.push(i);
    //     }
    //     this.setState({
    //         hotelsDefault : currentTodos,
    //         hotelPage : pageNumbers
    //     })
    // }
    // shouldComponentUpdate(nextProps, nextState){
    //     console.log("shouldComponentUpdate()")
    // }
    // handleClickLoading(){
    //     const currentLoading = this.state.isLoading;
    //     this.setState({isLoading :!this.state.isLoading});
    //     console.log(this.state.isLoading);
    // }
    render(){
        const BarStyling = {width:"20rem",background:"#F2F1F9", border:"none", padding:"0.5rem"};
        const indexOfLastTodo = this.state.currentPage * this.state.todosPerPage;
        const indexOfFirstTodo = indexOfLastTodo - this.state.todosPerPage;
        const currentTodos = this.state.hotelsDefault.slice(indexOfFirstTodo, indexOfLastTodo);
        const pageNumbers = [];
        for (let i = 1; i <= Math.ceil(this.state.hotels.length / this.state.todosPerPage); i++) {
          pageNumbers.push(i);
        }
        
        // console.log("render()")
        return(
            <div className={classes.hotelList}>
                <h1 className={classes.title}>All Hotels</h1>
                <Button onClick={this.handleAddHotel} variant="primary">
                Add Hotel
                </Button>
                <input 
                style={BarStyling}
                key="random1"
                value={this.state.keyword}
                placeholder={"Cari Hotel"}
                // onChange={(e) => this.setState({keyword: e.target.value})}
                onChange={this.updateSearch}
                />
                <div>
                {currentTodos.map((hotel) => (
                    <Hotel
                    key={hotel.id}
                    id={hotel.id}
                    namaHotel={hotel.namaHotel}
                    alamat={hotel.alamat}
                    nomorTelepon={hotel.nomorTelepon}
                    handleEdit={() => this.handleEditHotel(hotel)}
                    handleDelete={() => this.handleDeleteHotel(hotel.id)}
                    listKamar={hotel.listkamar}
                    />
                ))}
                </div>
                <div className={classes.page}>
                <ul className={classes.pagenumbers}>
                {pageNumbers.map(number => {
                        return (
                        <li
                            key={number}
                            id={number}
                            onClick={this.handleClick}
                        >
                            {number}
                        </li>
                        );
                    })}
                </ul>
                </div>
                <Modal show={this.state.isCreate || this.state.isEdit} handleCloseModal={this.handleCancel}>
                <form>
                <h3 className={classes.modalTitle}>
                {this.state.isCreate
                ? "Add Hotel"
                : `Edit Hotel Nomor ${this.state.id}`}
                </h3>

                <input
                className={classes.textField}
                type="text"
                placeholder="Nama Hotel"
                name="namaHotel"
                value={this.state.namaHotel}
                onChange={this.handleChangeField}
                />
                <input
                className={classes.textField}
                type="text"
                placeholder="Alamat"
                name="alamat"
                value={this.state.alamat}
                onChange={this.handleChangeField}
                />
                <textarea
                className={classes.textField}
                placeholder="Nomor Telepon"
                name="nomorTelepon"
                rows="4"
                value={this.state.nomorTelepon}
                onChange={this.handleChangeField}
                />
                <Button
                onClick={
                this.state.isCreate
                ? this.handleSubmitAddHotel
                : this.handleSubmitEditHotel
                }
                variant="primary"
                >
                {this.state.isCreate ? "Create" : "Edit"}
                </Button>
                <Button onClick={this.handleCancel} variant="danger">
                Cancel
                </Button>
                </form>
                </Modal>
            </div>
        );
    }
}
export default HotelList