package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.rest.HotelDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface KamarRestService {
    KamarModel createKamar(KamarModel kamarModel);
    List<KamarModel> retrieveListKamar();
    KamarModel getKamarByIdKamar(Long idKamar);
    KamarModel changeKamar(Long idKamar, KamarModel kamarModel);
    void deleteKamar(Long idKamar);

}
