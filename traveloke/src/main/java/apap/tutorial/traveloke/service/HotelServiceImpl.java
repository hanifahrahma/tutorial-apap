package apap.tutorial.traveloke.service;


import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.repository.HotelDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelDb hotelDb;

    @Override
    public void addHotel(HotelModel hotel){hotelDb.save(hotel);}

    @Override
    public List<HotelModel> getHotelList() {
        return hotelDb.findAll();
    }

    @Override
    public HotelModel getHotelByIdHotel(Long idHotel) {
        return hotelDb.findById(idHotel).get();
    }

    @Override
    public HotelModel updateHotel(HotelModel hotel) {
        HotelModel targetHotel = hotelDb.findById(hotel.getId()).get();

        try{
            targetHotel.setNamaHotel(hotel.getNamaHotel());
            targetHotel.setAlamat(hotel.getAlamat());
            targetHotel.setNomorTelepon(hotel.getNomorTelepon());
            hotelDb.save(targetHotel);
            return targetHotel;
        } catch (NullPointerException nullException){
            return null;
        }
    }

    @Override
    public List<HotelModel> getHotelListASC() {
        return hotelDb.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public boolean deleteHotel(HotelModel hotel) {
        if(hotel.getListkamar().size() == 0){
            hotelDb.delete(hotel);
            return true;
        }
        return false;
    }
}
