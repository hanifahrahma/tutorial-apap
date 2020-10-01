package apap.tutorial.traveloke.model;

public class HotelModel {
    private  String idHotel;
    private String namaHotel;
    private String alamat;
    private String noTelepon;

    public HotelModel(String idHotel, String namaHotel, String alamat, String noTelepon) {
        this.idHotel = idHotel;
    }

    public String getIdHotel() {
        return idHotel;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public void setIdHotel(String idHotel) {
        this.idHotel = idHotel;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
}
