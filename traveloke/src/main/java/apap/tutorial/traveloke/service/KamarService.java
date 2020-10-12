package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;
import java.util.Optional;

public interface KamarService {
    void addKamar(KamarModel kamar);

    List<KamarModel> findAllKamarByIdHotel(Long idHotel);

    KamarModel getKamarBynoKamar(Long noKamar);
    KamarModel updateKamar(KamarModel kamar);
    void deleteKamar(KamarModel kamar);
    KamarModel getKamarBynamaKamar(String namaKamar);
}
