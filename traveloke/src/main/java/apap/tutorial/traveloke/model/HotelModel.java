package apap.tutorial.traveloke.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="hotel")
public class HotelModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    @Size(max=30)
    @Column(name="namaHotel", nullable = false)
    private String namaHotel;

    @NotNull
    @Size(max=30)
    @Column(name="alamat", nullable = false)
    private String alamat;

    @NotNull
    @Column(name="noTelepon", nullable = false)
    private Integer noTelepon;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KamarModel> listkamar;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getNomorTelepon() {
        return noTelepon;
    }

    public void setNomorTelepon(Integer noTelepon) {
        this.noTelepon = noTelepon;
    }

    public List<KamarModel> getListkamar() {
        return listkamar;
    }

    public void setListkamar(List<KamarModel> listkamar) {
        this.listkamar = listkamar;
    }
}
