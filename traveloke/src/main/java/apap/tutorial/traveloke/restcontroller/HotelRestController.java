package apap.tutorial.traveloke.restcontroller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.rest.HotelDetail;
import apap.tutorial.traveloke.service.APIRestService;
import apap.tutorial.traveloke.service.HotelRestService;
import apap.tutorial.traveloke.service.KamarRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class HotelRestController {
    @Autowired
    private HotelRestService hotelRestService;

    @Autowired
    private APIRestService apiRestService;

//    @Autowired
//    private KamarRestService kamarRestService;

    @PostMapping(value="/hotel")
    private HotelModel createHotel(@Valid @RequestBody HotelModel hotel, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );

        }
        else{
            return hotelRestService.createHotel(hotel);
        }
    }

    @GetMapping(value = "/hotel/{idHotel}")
    private HotelModel retrieveHotel(@PathVariable("idHotel") Long idHotel){
        try{
            return hotelRestService.getHotelByIdHotel(idHotel);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Hotel "+String.valueOf(idHotel)+" Not Found"
            );
        }
    }

    @DeleteMapping(value = "/hotel/{idHotel}")
    private ResponseEntity<String> deleteHotel(@PathVariable("idHotel") Long idHotel){
        try{
            hotelRestService.deleteHotel(idHotel);
            return ResponseEntity.ok("Hotel with ID "+String.valueOf(idHotel)+" deleted!");
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Hotel with ID "+ String.valueOf(idHotel)+" Not Found!"
            );
        }catch(UnsupportedOperationException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Hotell still has kamar, please delete kamar first!"
            );
        }
    }

    @PutMapping(value = "/hotel/{idHotel}")
    private HotelModel updateHotel(
            @PathVariable(value = "idHotel") Long idHotel,
            @RequestBody HotelModel hotel
    ){
        try {
            return hotelRestService.changeHotel(idHotel, hotel);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Hotel with ID "+String.valueOf(idHotel)+ " Not Found!"
            );
        }
    }

    @GetMapping(value = "/hotels")
    private List<HotelModel> retrieveListHotel(){
        return hotelRestService.retrieveListHotel();
    }

//    @GetMapping(value="hotel/view/{idHotel}")
//    private List<KamarModel> retrieveListKamar(@PathVariable("idHotel") Long idHotel){
//        return kamarRestService.getKamarByIdHotel(idHotel);
//    }

    @GetMapping(value = "/hotel/{idHotel}/status")
    private Mono<String> getStatus(@PathVariable Long idHotel){
        return hotelRestService.getStatus(idHotel);
    }

    @GetMapping(value="/full")
    private Mono<HotelDetail> postStatus() {
        System.out.println("masuk control");
        return hotelRestService.postStatus();
    }
    @GetMapping(value="/hotel/find")
    private Mono<String> find(@RequestParam String cityName){
        return apiRestService.find(cityName);
    }

}
