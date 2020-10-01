package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelInMemoryService implements HotelService{
    private List<HotelModel> listHotel;

    public HotelInMemoryService() {
        listHotel = new ArrayList<>();
    }

    @Override
    public void addHotel(HotelModel hotel){
        listHotel.add(hotel);
    }

    @Override
    public List<HotelModel> getHotelList(){
        return listHotel;
    }

    @Override
    public HotelModel getHotelByIdHotel(String idHotel){
        HotelModel temp = null;
        for(int i=0; i<listHotel.size(); i++){
            if(listHotel.get(i).getIdHotel() == idHotel){
                temp = listHotel.get(i);
            }
        }
        return temp;
    }
}

