package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @GetMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel", new HotelModel());
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        hotelService.addHotel(hotel);
        model.addAttribute("id", hotel.getId());
        return "add-hotel";
    }

    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        try{
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        model.addAttribute("hotel", hotel);
        return "form-update-hotel";
        }
        catch (NoSuchElementException noSuchElementException) {
        return "error-hotel";
        }
    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel", hotelUpdated);
        return "update-hotel";
    }

    @GetMapping("/hotel/view")
    public String viewDetailHotel(
            @RequestParam(value = "idHotel") Long idHotel,
            Model model
    ){

        try{
            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
            List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
            boolean temp = (listKamar.size() != 0);
            model.addAttribute("hotel", hotel);
            model.addAttribute("listKamar", listKamar);
            model.addAttribute("temp", temp);
            return "view-hotel";
        }
        catch (NoSuchElementException noSuchElementException) {
            return "error-hotel";
        }
    }

    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model) {
        List<HotelModel> listHotel = hotelService.getHotelListASC();
        model.addAttribute("listHotel", listHotel);
        return "viewall-hotel";
    }

    @GetMapping("/hotel/delete/{id}")
    public String deleteHotelView(
            @PathVariable Long id,
            Model model
    ){
        try {
            HotelModel hotel = hotelService.getHotelByIdHotel(id);
            boolean boll = hotelService.deleteHotel(hotel);
            model.addAttribute("boll", boll);
            return "delete-hotel";
        }
        catch (NoSuchElementException noSuchElementException) {
            return "error-hotel";
        }
    }
//    @RequestMapping("/hotel/add")
//    public String addHotel(
//        @RequestParam(value = "idHotel", required = true) String idHotel,
//        @RequestParam(value = "namaHotel", required = true) String namaHotel,
//        @RequestParam(value = "alamat", required = true) String alamat,
//        @RequestParam(value = "noTelepon", required = true) String noTelepon,
//        Model model){
//
//        //membuat objek hotel
//        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);
//
//        //memanggil service hotel
//        hotelService.addHotel(hotel);
//
//        // Add variabel id  hotel ke 'id hotel' untuk dirender pada thymeleaf
//        model.addAttribute("idHotel", idHotel);
//
//        //return view template yang digunakan
//        return "add-hotel";
//
//    }
//
//    @RequestMapping("/hotel/viewall")
//    public String listHotel(Model model){
//
//        // Mendapatkan semua HotelModel
//        List<HotelModel> listHotel = hotelService.getHotelList();
//
//        // Add variabel semua hotelmodel ke 'listhotel' untuk dirender ke thymyleaf
//        model.addAttribute("listHotel", listHotel);
//
//        //return template yang digunakan
//        return "viewall-hotel";
//    }
//
//    @RequestMapping("/hotel/view")
//    public String detailHotel(
//            @RequestParam(value= "idHotel") String idHotel,
//            Model model
//    ){
//            // Mendapatkan HotelModel sesuai idhotel
//            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//            if (hotel == null) {
//                return "error-hotel";
//            }
//            // Add Variabel HotelModel ke 'hotel' untuk dirender di thymyleaf
//            model.addAttribute("hotel", hotel);
//            return "view-hotel";
//
//    }
//
//    @RequestMapping(value = "/hotel/view/id-hotel/{idHotel}")
//    public String detailHotel2(
//            @PathVariable(value = "idHotel") String idHotel,
//            Model model
//    ){
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//        if(hotel == null){
//            return "error-hotel";
//        }
//            model.addAttribute("hotel", hotel);
//            return "view-hotel";
//    }
//
//    @RequestMapping(value = "/hotel/update/id-hotel/{idHotel}/no-telepon/{noTelepon}")
//    public String updatenoTelpView(
//            @PathVariable(value = "idHotel") String idHotel,
//            @PathVariable(value = "noTelepon") String noTelepon,
//            Model model
//    ){
//        HotelModel hotel = hotelService.updatenoTelp(idHotel, noTelepon);
//        if(hotel == null){
//            return "error-hotel";
//        }
//        return "updatenoTelp";
//
//    }
//
//    @RequestMapping(value = "/hotel/delete/id-hotel/{idHotel}")
//    public String deleteHotel(
//            @PathVariable(value = "idHotel") String idHotel,
//            Model model
//    ){
//        boolean temp = hotelService.deleteHotel(idHotel);
//        if(temp == true) {
//            return "delete-hotel";
//        }
//        return "error-hotel";
//    }
//

}
