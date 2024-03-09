package myPackage;

public class rute {
    String ruteId;
    String asal;
    String tujuan;
    int durasiPerjalanan;

    public rute(String ruteId, String asal, String tujuan ,int durasiPerjalanan )
    {
        this.ruteId = ruteId;
        this.asal = asal;
        this.tujuan = tujuan;
        this.durasiPerjalanan = durasiPerjalanan;
    }

    public String getRuteId()
    {
        return ruteId;
    }
    public String getAsal()
    {
        return asal;
    }
    public String getTujuan()
    {
        return tujuan;
    }
    public int getDurasiPerjalanan()
    {
        return durasiPerjalanan;
    }

    public void setRuteId(String args)
    {
        ruteId = args;
    }

    public void setAsal(String args)
    {
        asal = args;
    }

    public void setTujuan(String args)
    {
        tujuan = args;
    }

    public void setDurasiPerjalanan(int args)
    {
        durasiPerjalanan = args;
    }

}
