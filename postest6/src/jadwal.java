// package myPackage;

public final class jadwal {
    private  String jadwalId;
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

    public final String getJadwalId()
    {
        return jadwalId;
    }
    public final String getKapalId()
    {
        return kapalId;
    }
    public final String getRuteId()
    {
        return ruteId;
    }
    public final String getWaktuBerangkat()
    {
        return waktuBerangkat;
    }
    public final String getKapalName()
    {
        return kapalName;
    }
    public final String getRuteName()
    {
        return ruteName;
    }


    public final void setJadwalId(String args)
    {
        jadwalId = args;
    }
    public final void setWaktuBerangkat(String args)
    {
        waktuBerangkat = args;
    }
    public final void setNamaKapal(String args)
    {
        kapalName = args;
    }
    public final void setNamaRute(String args)
    {
        ruteName= args;
    }
    public final void setIdkapal(String args)
    {
        kapalId = args;
    }
    public final void setIdRute(String args)
    {
        ruteId = args;
    }


}
