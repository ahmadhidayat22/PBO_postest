import java.util.ArrayList;

public final class Pemesanan {    
    private String idPesanan;
    private String namaPemesan;
    private String namaKapal;
    private String ruteKapal;
    private String waktuBerangkat;

    public Pemesanan(String namaPemesan, String namaKapal, String ruteKapal, String waktu)
    {
        
        this.namaPemesan = namaPemesan;
        this.namaKapal = namaKapal;
        this.ruteKapal = ruteKapal;
        this.waktuBerangkat = waktu;
    }

    public String getNamaPemesan()
    {
        return namaPemesan;
    }
    public String getNamaKapal()
    {
        return namaKapal;
    }
    public String getRuteKapal()
    {
        return ruteKapal;
    }
    public String getWaktuBerangkat()
    {
        return waktuBerangkat;
    }

}
