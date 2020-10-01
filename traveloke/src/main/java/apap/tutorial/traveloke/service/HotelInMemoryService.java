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
            if(idHotel.equals(listHotel.get(i).getIdHotel())){
                temp = listHotel.get(i);
            }
        }
        return temp;
    }

    @Override
    public boolean deleteHotel(String idHotel) {
        for(int i=0; i<listHotel.size(); i++){
            if(idHotel.equals(listHotel.get(i).getIdHotel())){
                listHotel.remove(i);
                return true;
            }
        }
        return false;

    }

    @Override
    public HotelModel updatenoTelp(String idHotel, String noTelepon){
        for(int i=0; i<listHotel.size(); i++){
            if(idHotel.equals(listHotel.get(i).getIdHotel())){
                listHotel.get(i).setNoTelepon(noTelepon);
                return listHotel.get(i);
            }
        }
        return null;
    }
}

