// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.IOException;
import java.util.ArrayList;



public final class Pemesanan {
    private static ArrayList<Pemesanan> pesananArr = new ArrayList<>();
    private static ArrayList<jadwal> jadwalList = admin.getJadwal();
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

    public static void displayJadwal()
    {
       
        for(int i = 0; i < jadwalList.size(); i++)
        {
            
            jadwal jdwl = jadwalList.get(i);
            String idJdwl = jdwl.getJadwalId();
            String idKpl = jdwl.getKapalId();
            String idRte = jdwl.getRuteId();
            String useKapal = jdwl.getKapalName();
            String useRute = jdwl.getRuteName();
            String waktuBerangkat = jdwl.getWaktuBerangkat();
    
            
            System.out.printf("%8s %3s %3s %n","No"         ,":", (i +1) );
            System.out.printf("%8s %3s %3s %n","Id"         ,":",  idJdwl);
            System.out.printf("%8s %3s %3s %n","Rute Id"    ,":",  idKpl);
            System.out.printf("%8s %3s %3s %n","Kapal Id"   ,":",  idRte);
            System.out.printf("%8s %3s %3s %n","Kapal"      ,":", useKapal);
            System.out.printf("%8s %3s %3s %n","Rute"       ,":", useRute);
            System.out.printf("%8s %3s %3s %n","Waktu"      ,":", waktuBerangkat);
            System.out.println("--------------------------------");
            System.out.println("\n");
        }
    }
    public static void setPemesanan()
    {
        try {
            if (jadwalList.size() == 0){
                System.out.println("tiket belum tersedia, coba lagi nanti..");
                return;
            }
            displayJadwal();
            System.out.print("pilih no :");
            int pilihNo = Integer.parseInt(System.console().readLine());
            
            if (pilihNo <= 0 || pilihNo > jadwalList.size()) {
                System.out.println("Nomor jadwal tidak valid!");
                return;
            }
            
            jadwal jdwl = jadwalList.get(pilihNo - 1);
            String kapalName = jdwl.getKapalName();
            String ruteName = jdwl.getRuteName();
            String waktu = jdwl.getWaktuBerangkat();
            
            System.out.print("nama pemesan : ");
            String namaPemesan = System.console().readLine();

            // System.out.println(kapalName + ruteName +waktu);
            Pemesanan pesanan = new Pemesanan(namaPemesan, kapalName, ruteName, waktu);
            pesananArr.add(pesanan);
            System.out.println("Berhasil dipesan");

        } catch (Exception e) {
            
            System.out.println("error: " + e);
            
        }

    }
    public static void getPemesanan()
    {
        if (pesananArr.size() == 0) {
            System.out.println("belum ada pesanan");
            return;
        }
       
            for (int i = 0; i < pesananArr.size(); i++) {
                Pemesanan pmsn = pesananArr.get(i);
                String nama = pmsn.getNamaPemesan();
                String kapal = pmsn.getNamaKapal();
                String rute = pmsn.getRuteKapal();
                String waktu = pmsn.getWaktuBerangkat();
                System.out.println("\n-----------------------------");
                System.out.println("\nNama Pemesan : " + nama);
                System.out.println("Kapal : " + kapal);
                System.out.println("rute : " + rute);
                System.out.println("Waktu berangkat : " + waktu);
                System.out.println("-----------------------------");

                // System.out.println(pesananArr.get(i));
            }
        

    }

}
