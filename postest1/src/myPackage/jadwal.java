package myPackage;

public class jadwal {
    String jadwalId;
    String kapalId;
    String ruteId;
    String waktuBerangkat;

    public jadwal(String jadwalId, String kapalId, String ruteId, String waktuBerangkat)
    {
        this.jadwalId = jadwalId;
        this.kapalId = kapalId;
        this.ruteId = ruteId;
        this.waktuBerangkat = waktuBerangkat;

    }

    public String getJadwalId()
    {
        return jadwalId;
    }
    public String getKapalId()
    {
        return kapalId;
    }
    public String getRuteId()
    {
        return ruteId;
    }
    public String getWaktuBerangkat()
    {
        return waktuBerangkat;
    }


    public void setJadwalId(String args)
    {
        jadwalId = args;
    }
    public void setWaktuBerangkat(String args)
    {
        waktuBerangkat = args;
    }
    public void setNamaKapal(String args)
    {
        kapalId = args;
    }
    public void setRute(String args)
    {
        ruteId = args;
    }
}
