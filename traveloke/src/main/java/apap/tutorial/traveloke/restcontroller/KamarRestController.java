package apap.tutorial.traveloke.restcontroller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.KamarRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class KamarRestController {
    @Autowired
    private KamarRestService kamarRestService;

    @PostMapping(value="/kamar")
    private ResponseEntity<String> createKamar(@Valid @RequestBody KamarModel kamarModel, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        }
        else{
            KamarModel kamarModel1 = kamarRestService.createKamar(kamarModel);
            return ResponseEntity.ok("Add kamar success");
        }
    }

    @PutMapping(value = "/kamar/{kamarId}")
    private ResponseEntity<String> updateKamar(
            @PathVariable(value = "kamarId") Long kamarId,
            @RequestBody KamarModel kamarModel
    ){
        try {
            KamarModel kamarModel1 = kamarRestService.changeKamar(kamarId, kamarModel);
            return ResponseEntity.ok("Update kamar success");
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Kamar with ID "+String.valueOf(kamarId)+ " Not Found!"
            );
        }
    }

    @GetMapping(value = "/kamar/{kamarId}")
    private KamarModel retrieveHotel(@PathVariable("kamarId") Long kamarId){
        try{
            return kamarRestService.getKamarByIdKamar(kamarId);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Kamar "+String.valueOf(kamarId)+" Not Found"
            );
        }
    }

    @GetMapping(value = "/kamar-all")
    private List<KamarModel> retrieveListHotel(){
        return kamarRestService.retrieveListKamar();
    }

    @DeleteMapping(value = "/kamar/{kamarId}")
    private ResponseEntity<String> deleteKamar(
            @PathVariable(value = "kamarId") Long kamarId
    ){
        try {
            kamarRestService.deleteKamar(kamarId);
            return ResponseEntity.ok("Kamar has been deleted");
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Kamar with ID "+String.valueOf(kamarId)+ " Not Found!"
            );
        }
    }

}
