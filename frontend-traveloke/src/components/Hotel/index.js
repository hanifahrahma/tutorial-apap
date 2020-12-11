import React, {useState} from "react";
import Button from "../Button";
// import Kamar from "../Kamar";
import classes from "./styles.module.css";
// import APIConfig from "../../api/APIConfig"

const Hotel = (props) => {
    
const { id, namaHotel, alamat, nomorTelepon,  handleEdit, handleDelete, listKamar} = props;
// console.log(listKamar)
const length = listKamar.length;
const listKosong = <p style={{fontWeight:"bold"}}>Hotel tidak memiliki kamar</p>

return (
<div className={classes.hotel}>
 <h3>{`ID Hotel ${id}`}</h3>
 <p>{`Nama Hotel: ${namaHotel}`}</p>
 <p>{`Alamat: ${alamat}`}</p>
 <p>{`Nomor telepon: ${nomorTelepon}`}</p>
 <p>List Kamar:</p>
 <div style={{marginBottom:10}}>
 {length > 0 ? listKamar.map((kamar) => (
    //  <Kamar nama={kamar.namaKamar} kapasitas={kamar.kapasitasKamar}></Kamar>  
    <li ><span style={{fontWeight: "bold"}}>{kamar.namaKamar}</span> : {kamar.kapasitasKamar}</li>
     
)): listKosong}
   </div>
 <Button onClick={handleEdit} variant="success">
Edit
</Button>
<Button onClick={handleDelete} variant="danger">
Delete
</Button>
 </div>
);
};
export default Hotel;