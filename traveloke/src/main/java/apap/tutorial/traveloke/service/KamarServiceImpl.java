package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.KamarDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KamarServiceImpl implements KamarService{

    @Autowired
    KamarDb kamarDb;

    @Override
    public void addKamar(KamarModel kamar) {
        kamarDb.save(kamar);
    }

    @Override
    public List<KamarModel> findAllKamarByIdHotel(Long idHotel) {
        return kamarDb.findByHotelId(idHotel);
    }

    @Override
    public KamarModel getKamarBynoKamar(Long noKamar) {
        return kamarDb.findBynoKamar(noKamar).get();
    }

    @Override
    public KamarModel updateKamar(KamarModel kamar) {
        KamarModel targetKamar = kamarDb.findBynoKamar(kamar.getNoKamar()).get();
        try{
            targetKamar.setNamaKamar(kamar.getNamaKamar());
            targetKamar.setTipe(kamar.getTipe());
            targetKamar.setKapasitasKamar(kamar.getKapasitasKamar());
//            targetKamar.setHotel(kamar.getHotel());
            kamarDb.save(targetKamar);
            return targetKamar;
        } catch (NullPointerException nullException){
            return null;
        }
    }

    @Override
    public void deleteKamar(KamarModel kamar) {
        kamarDb.delete(kamar);
    }
}
