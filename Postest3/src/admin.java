// package myPackage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;
import java.io.IOException;

public class admin extends user{
    private String role = "admin";
    private static InputStreamReader sr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(sr);
    private static ArrayList <kapal> kapalArr = new ArrayList<>();
    private static ArrayList <rute> ruteArr = new ArrayList<>();
    public static ArrayList <jadwal> jadwalArr;

    public admin(String username, String password, String role)
    {
        super(username, password);
        this.role = role;
        admin.jadwalArr = new ArrayList<>();
    }

    public String getRole()
    {
        return role;
    }
    // private static void cls() 
    // {     
    //     System.out.print("\033[H\033[2J");  
    //     System.out.flush();  
    
    // }

    public static ArrayList <jadwal> getJadwal()
    {
        return jadwalArr;
    }

    private static String randomUID() {
        final String uuid = UUID.randomUUID().toString().split("-")[1].toUpperCase();
        return uuid;
        
    }

    private static void showKapal()
    {
        
        System.out.println("\nData Kapal :");
        if (kapalArr.size() == 0 ) {
            System.out.println("Tidak ada data");
            return;

        }else
        {
          
            System.out.println("------------------------------------------");
            System.out.printf(" %3s  %-5s  %5s  %5s %n", "No", "Id", "Nama Kapal", "kursi");
            System.out.println("------------------------------------------");

            for (int i = 0; i < kapalArr.size(); i++)
            {
                kapal kpl = kapalArr.get(i);
                String kpl_id = kpl.getKapalId();
                String  kpl_nama = kpl.getNamaKapal();
                int kpl_kursi = kpl.getKapasitasKursi();
       
                System.out.printf(" %-3s  %-3s  %-9s  %5d %n", (i+1), kpl_id, kpl_nama, kpl_kursi);

            }
            System.out.println("------------------------------------------\n");

            
        

        }
        
    }

    private static void showRute()
    {
        System.out.println("\n Data Rute :");
        if (ruteArr.size() == 0 ) {
            System.out.println("Tidak ada data");
            return;

        }else
        {
            System.out.println("------------------------------------------");
            System.out.printf("%3s  %-6s  %-6s  %5s %3s %n", "No", "Id", "Rute Asal", "Rute Tujuan", "Durasi");
            System.out.println("------------------------------------------");
            for (int i = 0; i < ruteArr.size(); i++)
            {
                rute rt = ruteArr.get(i);
                String rt_id = rt.getRuteId();
                String  rt_asal = rt.getAsal();
                String  rt_tujuan = rt.getTujuan();
                int rt_durasi = rt.getDurasiPerjalanan();
                System.out.printf("%3d  %-1s  %-10s %-10s %3d %n", (i+1), rt_id, rt_asal, rt_tujuan, rt_durasi);

                
            }
            System.out.println("------------------------------------------");

            
        }
    }
    
    public static void showJadwal()
    {
        if (jadwalArr.size() == 0){
            System.out.println("tidak ada data");
            return;
        };
        System.out.println("============ jadwal ============");

        for(int i=0; i<jadwalArr.size(); i++)
        {
            
            jadwal jdwl = jadwalArr.get(i);
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

    private static void addKapal() throws IOException
    {
        cls();
        try {

            String id_kapal = "KP" + randomUID();
            System.out.print("Nama kapal : ");
            String nama_kapal = br.readLine();
            System.out.print("Kapasitas Kursi : ");
            int kursi = Integer.parseInt(br.readLine());
            int kursi_resv = kursi;

    
            kapal kpl = new kapal(id_kapal,nama_kapal,kursi, kursi_resv);
            kapalArr.add(kpl);

        } catch (Exception e) {
            System.out.println("Kesalahan Input!, silahkan coba lagi");

        }
      
    }

    private static void addRute() throws IOException
    {
        try {
            String id_rute = "RE"+ randomUID();
            System.out.print("Rute Asal : ");
            String asal_rute = br.readLine();
    
            System.out.print("Rute Tujuan : ");
            String tujuan_rute = br.readLine();
    
            System.out.print("Durasi Rute (menit) : ");
            int time_rute = Integer.parseInt(br.readLine());
    
            rute rt = new rute(id_rute, asal_rute.toUpperCase(), tujuan_rute.toUpperCase(), time_rute);
            ruteArr.add(rt);
        } catch (Exception e) {
            System.out.println("Kesalahan Input!, silahkan coba lagi");
        }

    }

    private static void addJadwal()
    {
        cls();
        try {
            if ( kapalArr.size() == 0 || ruteArr.size()  == 0) {
                System.out.println("masukkan data kapal dan rute terlebih dahulu!!");
                return;
            }
            System.out.println(kapalArr.size()+ " " + ruteArr.size() );
            showKapal();           
            showRute();
          
            System.out.println("==========================\n");

            String jdwlId = "JDW" + randomUID();

            System.out.print("Nomor kapal :");
            int indx_kapal = Integer.parseInt(br.readLine());
            System.out.print("Nomor rute : ");
            int indx_rute = Integer.parseInt(br.readLine());
            String kapal_name = "";
            String rute_name = "";
            String kapal_id = "";
            String rute_id = "";
            boolean is_kapal = true;
            boolean is_rute = true;
            for(int i = 0; i < kapalArr.size(); i++)
            {
                if ((indx_kapal - 1) == i) {
                    kapal kpl2 = kapalArr.get(i);
                    kapal_name = kpl2.getNamaKapal();
                    kapal_id = kpl2.getKapalId();
                    is_kapal= true;
                    break;

                }else{
                    is_kapal= false;
                }
            }
            for(int j = 0; j < ruteArr.size(); j++)
            {
                if ((indx_rute - 1) == j) {
                    rute rte = ruteArr.get(j);
                    rute_name = rte.getAsal() + " - " + rte.getTujuan() ;
                    rute_id = rte.getRuteId();
                    is_rute = true;
                    break;
                }else{
                    is_rute = false;
                }
            }
            if (is_rute && is_kapal){ 
                System.out.print("Tanggal Berangkat : ");
                String berangkat = br.readLine();
                // public jadwal(String jadwalId, String kapalId, String ruteId, String waktuBerangkat, String kapalName, String ruteName)
    
                jadwal jdl = new jadwal(jdwlId, kapal_id , rute_id , berangkat, kapal_name, rute_name);
                jadwalArr.add(jdl); 
            }else{
                System.out.println("kesalahan nomor kapal atau rute, silahkan coba lagi...");
                return;               
            }

        } catch (Exception e) {
            System.out.println("error "  + e);
        }

    }

    private static void updateKapal() throws IOException
    {
        cls();
        showKapal();
        if (kapalArr.size() == 0 ) {
            return;
            
        }else{
            System.out.print("Ubah nomor : ");
            int index = Integer.parseInt(br.readLine());

            for(int i = 0; i < kapalArr.size(); i++)
            {
                if ((index - 1)  == i ) {
                    kapal newKpl = kapalArr.get(i);

                    System.out.println("------------------");
                    System.out.print("Nama Kapal Baru : ");
                    String nama_kapal_new = br.readLine();
                    newKpl.setNamaKapal(nama_kapal_new);
                    System.out.print("Kapasitas Kursi Baru :");
                    int kursi_new = Integer.parseInt(br.readLine());
                    newKpl.setKapasitasKursi(kursi_new);
                    System.out.println("Berhasil di Update");
                }
            }
            
        }
    }

    private static void updateRute() throws IOException
    {
        cls();
        showRute();
        if (ruteArr.size() == 0 ) {
            return;
            
        }else
        {
            System.out.print("Ubah nomor : ");
            int index = Integer.parseInt(br.readLine());

            for(int i = 0; i < ruteArr.size(); i++)
            {
                if ((index - 1) == i) {
                    rute newRte = ruteArr.get(i);

                    System.out.println("------------------");
                    
                    System.out.print("Rute Asal Baru : ");
                    String asal_rute_new = br.readLine();
                    newRte.setAsal(asal_rute_new.toUpperCase());
                    
                    System.out.print("Rute Tujuan Baru :");
                    String tujuan_rute_new = br.readLine();
                    newRte.setTujuan(tujuan_rute_new.toUpperCase());

                    System.out.print("Durasi Rute baru :");
                    int time_rute_new = Integer.parseInt(br.readLine());
                    newRte.setDurasiPerjalanan(time_rute_new);

                    System.out.println("Berhasil di Update");
                }
            }
        }
        

    }

    private static void updateJadwal() throws IOException
    {
        cls();
        showJadwal();
        System.out.print("Ubah nomor : ");
        int indx_jdwl = Integer.parseInt(br.readLine());

        for(int i = 0 ; i< jadwalArr.size() ; i++)
        {
            if ((indx_jdwl - 1) == i) {
                

                jadwal newJdwl = jadwalArr.get(i);
                System.out.println("------------------");
                showKapal();
                showRute();
                System.out.print("Pilih Kapal baru : ");
                int indx_kapal_new = Integer.parseInt(br.readLine());
                
                System.out.print("Pilih Rute baru : ");
                int indx_rute_new = Integer.parseInt(br.readLine());
                boolean isContaint = true;
                boolean isContaint2 = true;
                
                for(int j = 0; j < kapalArr.size(); j++) // pilih kapal berdasarkan nomor 
                {
                    if ((indx_kapal_new - 1) == j) {
                        kapal kpl2 = kapalArr.get(j);
                        String kapal_name_new = kpl2.getNamaKapal();
                        newJdwl.setNamaKapal(kapal_name_new);
                        isContaint = true;
                        break;
                        
                    }else{
                        isContaint = false;
                    }
                }

                for(int x = 0; x < ruteArr.size(); x++) // pilih rute berdasarkan nomor 
                {
                    if ((indx_rute_new - 1) == x) {
                        rute newRte = ruteArr.get(x);
                        String kapal_rute_new = newRte.getAsal() + " - " + newRte.getTujuan() ;
                        newJdwl.setNamaRute(kapal_rute_new);
                        isContaint2 = true;
                        break;

                     
                    }else{
                        isContaint2 = false;
                    }
                }

                // err handling ketika pilih kapal/rute tidak sesuai dgn list !
                if (isContaint && isContaint2) {
                    System.out.print("Tanggal berangkat :");
                    String berangkat_new = br.readLine();
                    newJdwl.setWaktuBerangkat(berangkat_new);
                    System.out.println("Berhasil di update....");

                    
                }else{                    
                    System.out.println("kesalahan nomor kapal atau rute, silahkan coba lagi...");
                    
                    return;
                }

            }
        }

    }

    private static void deleteKapal() throws IOException
    {

        cls();
        showKapal();
        try {
            System.out.print("Hapus nomor : ");
            int del = Integer.parseInt(br.readLine());
            System.out.println("data nomor " + del + " akan dihapus");
            
            for(int i = 0; i < jadwalArr.size(); i++)
            {
                kapal kpl = kapalArr.get(del-1);
                jadwal jdwl = jadwalArr.get(i);
                String kpl_name = kpl.getKapalId();
                String kapalId = jdwl.getKapalId();

                if (kpl_name == kapalId) {
                    System.out.println("data kapal telah ditambahkan ke jadwal, silahkan hapus jadwal terlebih dahulu");
                    return;
                }
            }


            kapalArr.remove(del-1);
            System.out.println("Berhasil dihapus....");  
            System.out.println("tekan enter untuk melanjutkan...");
            br.readLine();
            
        } catch (Exception e) {
            System.out.println("Oops!");
        }
       
    }

    private static void deleteRute() throws IOException
    {
        cls();
        showRute();
        try {
            System.out.println("Hapus nomor : ");
            int del = Integer.parseInt(br.readLine());
            System.out.println("data nomor " + del + " akan dihapus");
            
            for(int i = 0; i < jadwalArr.size(); i++)
            {
                rute rte = ruteArr.get(del-1);
                jadwal jdwl = jadwalArr.get(i);
                String rte_name = rte.getRuteId();

                String jdwl_rte = jdwl.getRuteId();
                
                if (rte_name == jdwl_rte) {
                    System.out.println("data rute telah ditambahkan ke jadwal, silahkan hapus jadwal terlebih dahulu");
                    return;
                }
            }

            ruteArr.remove(del-1);
            System.out.println("Berhasil dihapus....");   
            System.out.println("tekan enter untuk melanjutkan...");
            br.readLine(); 
        } catch (Exception e) {
            System.out.println("oops!");
        }
        
    }

    private static void deleteJadwal() throws IOException
    {
        cls();
        showJadwal();
        try {
            System.out.println("Hapus nomor : ");
            int del = Integer.parseInt(br.readLine());
            System.out.println("data nomor " + (del-1) + " akan dihapus");
            
            jadwalArr.remove(del-1);
            System.out.println("Berhasil dihapus....");
            System.out.println("tekan enter untuk melanjutkan...");
            br.readLine();
        } catch (Exception e) {
            System.out.println("Opps!");
        }
        
    }
    

    public void menuAdmin() throws IOException
    {
          try {    
            loop: while ( true ) {
            System.out.println("====================");
            System.out.println("1. Lihat Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("0. Keluar");
            System.out.println("====================");
            System.out.print("Menu : ");
            int menu = Integer.parseInt(br.readLine());

            switch (menu) {
                case 1:
                    System.out.println("> 1. Lihat data kapal");
                    System.out.println("> 2. Lihat data rute");
                    System.out.println("> 3. Lihat data jadwal");
                    System.out.println("> 0. Kembali");
                    System.out.print("> Pilih : ");
                    int pilih = Integer.parseInt(br.readLine());

                    if (pilih == 1) { 
                        showKapal();
                    }
                    else if( pilih == 2){ 
                        showRute();
                    }
                    else if( pilih == 3 ){
                        showJadwal();
                    }
                    else if( pilih == 0){ break; }
                    else{ System.out.println("input error!"); }
                    
                    
                    break;
                
                case 2:
                    System.out.println("> 1. Tambah data kapal");
                    System.out.println("> 2. Tambah data rute");
                    System.out.println("> 3. Tambah data jadwal");
                    System.out.println("> 0. Kembali");
                    System.out.print("> Pilih : ");
                    int pilih2 = Integer.parseInt(br.readLine());

                    if (pilih2 == 1) { 
                        addKapal();
                    }
                    else if (pilih2 == 2) {
                        addRute();
                    }
                    else if (pilih2 == 3) {
                        addJadwal();
                    }
                    else if( pilih2 == 0 ){ 
                        break; 
                    }
                    else{
                        System.out.println("input error!"); 
                    }
  
                  
                    break;    
                    
                case 3:
                    System.out.println("> 1. Ubah data kapal");
                    System.out.println("> 2. Ubah data rute");
                    System.out.println("> 3. Ubah data jadwal");
                    System.out.println("> 0. Kembali");
                    System.out.print("> Pilih : ");
                    int pilih3 = Integer.parseInt(br.readLine());
                    
                    if (pilih3 == 1) {
                        updateKapal();
                    }
                    else if(pilih3 == 2){
                        updateRute();
                    }
                    else if(pilih3 == 3){
                        updateJadwal();
                    
                    }else if(pilih3 == 0){
                        break;
                    }  
                    else{
                        System.out.println("input error!");
                    }
                    



                    break;
                case 4:
                    System.out.println("> 1. Hapus data kapal");
                    System.out.println("> 2. Hapus data rute");
                    System.out.println("> 3. Hapus data jadwal");
                    System.out.println("> 0. Kembali");
                    System.out.print("> Pilih : ");
                    int pilih4 = Integer.parseInt(br.readLine());

                    if (pilih4 == 1) {
                        deleteKapal();

                    }
                    else if(pilih4 == 2){
                        deleteRute();
                    }
                    else if (pilih4 == 3) {
                        deleteJadwal();
                    }
                    else if(pilih4 == 0){
                        break;
                    }  
                    else{
                        System.out.println("input error!");
                    }



                    break;
                case 0:
                    cls();
                    break loop; 
                default:
                    cls();
                    System.out.println("pilihan salah!");
                    break;
            }
    
        }

        } catch (IOException e) {
            System.out.println("error: " + e);
            
        }
    }

}
