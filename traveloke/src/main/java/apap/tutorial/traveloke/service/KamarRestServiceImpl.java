package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.HotelDb;
import apap.tutorial.traveloke.repository.KamarDb;
import apap.tutorial.traveloke.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KamarRestServiceImpl implements KamarRestService{
    private final WebClient webClient;

    @Autowired
    private KamarDb kamarDb;

    public KamarRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.hotelUrl).build();
    }

    @Override
    public KamarModel createKamar(KamarModel kamarModel) {
        return kamarDb.save(kamarModel);
    }

    @Override
    public List<KamarModel> retrieveListKamar() {
        return kamarDb.findAll();
    }

    @Override
    public KamarModel getKamarByIdKamar(Long idKamar) {
        return kamarDb.findBynoKamar(idKamar).get();
    }

    @Override
    public KamarModel changeKamar(Long idKamar, KamarModel kamarModel) {
        KamarModel targetKamar = kamarDb.findBynoKamar(idKamar).get();
        targetKamar.setNamaKamar(kamarModel.getNamaKamar());
        targetKamar.setTipe(kamarModel.getTipe());
        targetKamar.setKapasitasKamar(kamarModel.getKapasitasKamar());
        kamarDb.save(targetKamar);
        return targetKamar;

    }

    @Override
    public void deleteKamar(Long idKamar) {
        KamarModel kamar = kamarDb.findBynoKamar(idKamar).get();
        kamarDb.delete(kamar);
    }
}
