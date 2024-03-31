// package myPackage;

public class kapal {
    private String kapalId;
    private String namaKapal;
    private int kapasitasKursi;
    private int kapasitasReservasi;

    public kapal(String kapalId, String namaKapal, int kapasitasKursi, int kapasitasReservasi)
    {
        this.kapalId = kapalId;
        this.namaKapal = namaKapal;
        this.kapasitasKursi = kapasitasKursi;
        this.kapasitasReservasi = kapasitasReservasi;
    }

    public String getKapalId()
    {
        return kapalId;
    }

    public String getNamaKapal()
    {
        return namaKapal;
    }

    public int getKapasitasKursi()
    {
        return kapasitasKursi;
    }
    public int getKapasitasReservasi()
    {
        return kapasitasReservasi;
    }

    
    public void setKapalId(String args)
    {   
        kapalId = args;
    }
    public void setNamaKapal(String args)
    {   
        namaKapal = args;
    }

    public void setKapasitasKursi(int args)
    {
        kapasitasKursi = args;
    }
    public void setKapasitasReservasi(int args)
    {
        kapasitasReservasi = args;
    }

    

}
