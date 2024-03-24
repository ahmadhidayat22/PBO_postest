package myPackage;

public class jadwal {
   private String jadwalId;
   private String kapalId;
   private String ruteId;
   private String kapalName;
   private String ruteName;
   private String waktuBerangkat;

    public jadwal(String jadwalId, String kapalId, String ruteId, String waktuBerangkat, String kapalName, String ruteName)
    {
        this.jadwalId = jadwalId;
        this.kapalId = kapalId;
        this.ruteId = ruteId;
        this.kapalName = kapalName;
        this.ruteName = ruteName;
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
    public String getKapalName()
    {
        return kapalName;
    }
    public String getRuteName()
    {
        return ruteName;
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
        kapalName = args;
    }
    public void setNamaRute(String args)
    {
        ruteName= args;
    }
    public void setIdkapal(String args)
    {
        kapalId = args;
    }
    public void setIdRute(String args)
    {
        ruteId = args;
    }


}
