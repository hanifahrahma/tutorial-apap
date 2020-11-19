package apap.tutorial.traveloke.controller;


import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

//    @ModelAttribute("tempKamar")
//    public List<KamarModel> tempKamarMethod(Model model){
//        List<KamarModel> tempKamar = new ArrayList<>();
//        return tempKamar;
//    };

    List<KamarModel> tempKamar;
    @GetMapping("/kamar/add/{idHotel}" )
    private String addKamarFormPage(
            @PathVariable Long idHotel,
//            @ModelAttribute("tempKamar") List<KamarModel> tempKamar,
            Model model
    ) {
        tempKamar = new ArrayList<>();
        KamarModel kamar = new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        kamar.setHotel(hotel);
        tempKamar.add(kamar);
        hotel.setListkamar(tempKamar);
        model.addAttribute("hotel", hotel);
        model.addAttribute("jumlahKamar", hotel.getListkamar().size());
        return "form-add-kamar";
    }
    @PostMapping(path ="/kamar/add", params = "save")
    private String addKamarSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        for(KamarModel kamar : hotel.getListkamar()) {
            if(kamar.getHotel() == null) {
                kamar.setHotel(hotel);
            }
            kamarService.addKamar(kamar);
        }
        model.addAttribute("jumlahKamar", hotel.getListkamar().size());
        return "add-kamar";
    }

    @PostMapping(path="/kamar/add", params={"addItem"})
    public String addItem( @ModelAttribute HotelModel hotelModel, Model model) {
        if(hotelModel.getListkamar() == null || hotelModel.getListkamar().size() == 0){
            tempKamar = new ArrayList<>();
            hotelModel.setListkamar(tempKamar);
        }
        KamarModel kamar = new KamarModel();
        kamar.setHotel(hotelModel);

        hotelModel.getListkamar().add(kamar);
        model.addAttribute("hotel", hotelModel);
        return "form-add-kamar";
    }
    @PostMapping(value = "/kamar/add", params = {"deleteItem"})
    private String deleteRowMultiKamarSubmit(@ModelAttribute HotelModel hotelModel,
                                             final HttpServletRequest request,
                                             Model model) {
        int index = Integer.valueOf(request.getParameter("deleteItem"));
        hotelModel.getListkamar().remove(index);
        model.addAttribute("hotel", hotelModel);
        return "form-add-kamar";
    }

///    @GetMapping("/kamar/add/{idHotel}")
//    private String addKama/rFormPage(
//            @PathVariable Long idHotel,
//            Model model
//    ) {
//
//
//        KamarModel kamar = new KamarModel();
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//        kamar.setHotel(hotel);
//        model.addAttribute("kamar", kamar);
//
//        return "form-add-kamar";
//    }

//    @PostMapping("/kamar/add")
//    private String addKamarSubmit(
//            @ModelAttribute KamarModel kamar,
//            Model model
//    ){
//        kamarService.addKamar(kamar);
//        model.addAttribute("kamar", kamar);
//        return "add-kamar";
//    }

    @GetMapping("/kamar/change/{noKamar}")
    public String changeKamarFormPage(
            @PathVariable Long noKamar,
            Model model
    ){
        KamarModel kamar = kamarService.getKamarBynoKamar(noKamar);
        model.addAttribute("kamar", kamar);
        return "form-update-kamar";
    }

    @PostMapping("/kamar/change")
    public String changeKamarFormSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
//        System.out.println(kamar.getNoKamar());
        KamarModel updateKamar = kamarService.updateKamar(kamar);
        model.addAttribute("kamar", updateKamar);
        return "update-kamar";
    }

//    @GetMapping("/kamar/delete/{noKamar}")
//    public String deleteKamarView(
//            @PathVariable Long noKamar,
//            Model model
//    ){
//        KamarModel kamar = kamarService.getKamarBynoKamar(noKamar);
//        kamarService.deleteKamar(kamar);
//        return "delete-kamar";
//    }

    @PostMapping(path = "/kamar/delete")
    public String deleteKamarFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        model.addAttribute("kamarCount", hotel.getListkamar().size());
        for (KamarModel kamar : hotel.getListkamar()){
            kamarService.deleteKamar(kamar);
        }
        return "delete-kamar";
    }
}
