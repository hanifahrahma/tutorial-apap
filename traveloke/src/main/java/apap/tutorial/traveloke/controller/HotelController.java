package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @RequestMapping("/hotel/add")
    public String addHotel(
        @RequestParam(value = "idHotel", required = true) String idHotel,
        @RequestParam(value = "namaHotel", required = true) String namaHotel,
        @RequestParam(value = "alamat", required = true) String alamat,
        @RequestParam(value = "noTelepon", required = true) String noTelepon,
        Model model){

        //membuat objek hotel
        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);

        //memanggil service hotel
        hotelService.addHotel(hotel);

        // Add variabel id  hotel ke 'id hotel' untuk dirender pada thymeleaf
        model.addAttribute("idHotel", idHotel);

        //return view template yang digunakan
        return "add-hotel";

    }

    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model){

        // Mendapatkan semua HotelModel
        List<HotelModel> listHotel = hotelService.getHotelList();

        // Add variabel semua hotelmodel ke 'listhotel' untuk dirender ke thymyleaf
        model.addAttribute("listHotel", listHotel);

        //return template yang digunakan
        return "viewall-hotel";
    }

    @RequestMapping("/hotel/view")
    public String detailHotel(
            @RequestParam(value= "idHotel") String idHotel,
            Model model
    ){
            // Mendapatkan HotelModel sesuai idhotel
            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
            if (hotel == null) {
                return "error-hotel";
            }
            // Add Variabel HotelModel ke 'hotel' untuk dirender di thymyleaf
            model.addAttribute("hotel", hotel);
            return "view-hotel";

    }

    @RequestMapping(value = "/hotel/view/id-hotel/{idHotel}")
    public String detailHotel2(
            @PathVariable(value = "idHotel") String idHotel,
            Model model
    ){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if(hotel == null){
            return "error-hotel";
        }
            model.addAttribute("hotel", hotel);
            return "view-hotel";
    }

    @RequestMapping(value = "/hotel/update/id-hotel/{idHotel}/no-telepon/{noTelepon}")
    public String updatenoTelpView(
            @PathVariable(value = "idHotel") String idHotel,
            @PathVariable(value = "noTelepon") String noTelepon,
            Model model
    ){
        HotelModel hotel = hotelService.updatenoTelp(idHotel, noTelepon);
        if(hotel == null){
            return "error-hotel";
        }
        return "updatenoTelp";

    }

    @RequestMapping(value = "/hotel/delete/id-hotel/{idHotel}")
    public String deleteHotel(
            @PathVariable(value = "idHotel") String idHotel,
            Model model
    ){
        boolean temp = hotelService.deleteHotel(idHotel);
        if(temp == true) {
            return "delete-hotel";
        }
        return "error-hotel";
    }


}
