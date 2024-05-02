
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;

public class costumer extends user implements iPesanTiket{
    private final static String role = "costumer";
    private static InputStreamReader sr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(sr);
    private static ArrayList<jadwal> jadwalList = admin.getJadwal();
    private static ArrayList<Pemesanan> pesananArr = new ArrayList<>();

    public costumer(String username, String password,String name )
    {   
        super(username, password, name, role);

    }
    public String getRole()
    {
        return role;
    }

    @Override
    protected void profil()
    {
        cls();
        super.profil();
        System.out.println("Role : " + role);
        
    }
    protected void profil(boolean show)
    {
        if (show)profil();
        else super.profil();

    }


    private static String randomUID() {
        final String uuid = UUID.randomUUID().toString().split("-")[1].toUpperCase();
        return uuid;
        
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
            // System.out.printf("%8s %3s %3s %n","Id"         ,":",  idJdwl);
            // System.out.printf("%8s %3s %3s %n","Rute Id"    ,":",  idKpl);
            // System.out.printf("%8s %3s %3s %n","Kapal Id"   ,":",  idRte);
            System.out.printf("%8s %3s %3s %n","Kapal"      ,":", useKapal);
            System.out.printf("%8s %3s %3s %n","Rute"       ,":", useRute);
            System.out.printf("%8s %3s %3s %n","Waktu"      ,":", waktuBerangkat);
            System.out.println("--------------------------------");
            System.out.println("\n");
        }
    }

    @Override
    public void pesanTiket(){
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
        
                 
                    Pemesanan pesanan = new Pemesanan(namaPemesan, kapalName, ruteName, waktu);
                    pesananArr.add(pesanan);
                    System.out.println("Berhasil dipesan");
        
                } catch (Exception e) {
                    
                    System.out.println("error: " + e);
                    
                }
    }
    @Override
    public void lihatTiket()
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
                        System.out.println("\nNomor pesanan : " + (i + 1));
                        System.out.println("Nama Pemesan : " + nama);
                        System.out.println("Kapal : " + kapal);
                        System.out.println("rute : " + rute);
                        System.out.println("Waktu berangkat : " + waktu);
                        System.out.println("-----------------------------");
        
                       
                    }
    }

    @Override
    public void batalPesan()
    {
        lihatTiket();
        try {
            System.out.println("pilih tiket nomor : ");
            int choice = Integer.parseInt(System.console().readLine());

            System.out.println("pesanan nomor " + (choice) + " akan dibatalkan");
            
            pesananArr.remove(choice - 1);
            System.out.println("pesanan berhasil dibatalkan");
            System.out.println("\n\ntekan enter untuk lanjut..");
            System.console().readLine();


        } catch (Exception e) {
         
            System.out.println("oopss....");
            System.out.println("\ntekan enter untuk lanjut..");
            System.console().readLine();
            
        }
    }

    @Override
    public void menu() throws IOException
    {
        try {
            cls();
            System.out.println("-- selamat datang di pemesanan tiket kapal --");

            while (true) {
           
                System.out.println("1. pesan tiket");
                System.out.println("2. Lihat Pesanan");
                System.out.println("3. Batalkan pesanan");
                System.out.println("4. Profil");
                System.out.println("0. Keluar");
                System.out.print("Pilih : ");
                int pilih = Integer.parseInt(br.readLine());

                switch (pilih) {
                    case 1 ->{
                        pesanTiket();
                        System.out.println("\n\ntekan enter untuk lanjut..");
                        br.readLine();
                    }
                    case 2 ->{
                      
                        lihatTiket();
                        System.out.println("\n\ntekan enter untuk lanjut..");
                        br.readLine();

                    }
                    case 3 -> {
                        System.out.println("batalkan pesanan");
                        batalPesan();
                    }

                    case 4 ->{
                        profil(true);
                        System.out.println("\n\ntekan enter untuk lanjut..");
                        br.readLine();
                    }
                    case 0 ->{
                        return;
                    }
                    default -> {
                        System.out.println("oops!");
                        br.readLine();
                    }

                }
                cls();

            }
            
            
        } catch (Exception e) {
         
            System.out.println("error : " + e);
        }

    }


}
