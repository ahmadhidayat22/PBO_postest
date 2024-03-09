import myPackage.*;
import java.util.ArrayList;
import java.util.UUID;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
// import java.util.UUID;

// class_rute, class_kapal, class_jadwal

public class App {
    public static ArrayList <kapal> kapalArr = new ArrayList<>();
    public static ArrayList <rute> ruteArr = new ArrayList<>();
    public static ArrayList <jadwal> jadwalArr = new ArrayList<>();

    public static InputStreamReader sr = new InputStreamReader(System.in);
    public static BufferedReader br = new BufferedReader(sr);

    public static String randomUID() {
        final String uuid = UUID.randomUUID().toString().split("-")[1].toUpperCase();
        return uuid;
        // System.out.println("UUID generated - " + uuid);
        // System.out.println("UUID Version - " + uuid.version());
    }

    public static void cls() 
    {     
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    
    }
    static void showKapal()
    {
        
        System.out.println("\n=========== Data Kapal =========== ");
        if (kapalArr.size() == 0 ) {
            System.out.println("Tidak ada data");
            return;

        }else
        {

            for (int i = 0; i < kapalArr.size(); i++)
            {
                kapal kpl = kapalArr.get(i);
                String kpl_id = kpl.getKapalId();
                String  kpl_nama = kpl.getNamaKapal();
                int kpl_kursi = kpl.getKapasitasKursi();
                
                System.out.println("No : " + (i + 1) );
                System.out.println("Id : " +  kpl_id);
                System.out.println("Nama Kapal : " + kpl_nama);
                System.out.println("Kapasitas Kursi : " + kpl_kursi + "\n");

            }
            
            System.out.println("===================\n");

        }
        
    }

    static void showRute()
    {
        System.out.println("\n=========== Data Rute =========== ");
        if (ruteArr.size() == 0 ) {
            System.out.println("Tidak ada data");
            return;

        }else
        {

            for (int i = 0; i < ruteArr.size(); i++)
            {
                rute rt = ruteArr.get(i);
                String rt_id = rt.getRuteId();
                String  rt_asal = rt.getAsal();
                String  rt_tujuan = rt.getTujuan();
                int rt_durasi = rt.getDurasiPerjalanan();

                System.out.println("No : " + (i + 1) );
                System.out.println("Id : " +  rt_id);
                System.out.println("Rute asal : " + rt_asal);
                System.out.println("Rute tujuan  : " + rt_tujuan);
                System.out.println("Durasi Perjalanan : " + rt_durasi + " menit \n");
                
            }
            System.out.println("=========================\n");
        }
    }
    
    static void showJadwal()
    {
        System.out.println("============ jadwal ============");

        for(int i=0; i<jadwalArr.size(); i++)
        {
            jadwal jdwl = jadwalArr.get(i);
            String idJdwl = jdwl.getJadwalId();
            String useKapal = jdwl.getKapalId();
            String useRute = jdwl.getRuteId();
            String waktuBerangkat = jdwl.getWaktuBerangkat();
            
            System.out.println("No : " + (i + 1) );
            System.out.println("Id : " +  idJdwl);
            System.out.println("Nama Kapal : " + useKapal);
            System.out.println("Rute : " + useRute);
            System.out.println("Waktu : " + waktuBerangkat);
            System.out.println("===================\n");
        }

    }

    static void addKapal() throws IOException
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

    static void addRute() throws IOException
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

    static void addJadwal()
    {
        cls();
        try {
            
            showKapal();
            // for (int x = 0; x < kapalArr.size(); x++)
            // {   
            //     kapal kpl = kapalArr.get(x);
                
            //     String kplNama = kpl.getNamaKapal();
            //     int kplKursi = kpl.getKapasitasKursi();
            //     System.out.println("No : " + (x + 1) + ", Nama Kapal : " + kplNama + ", Kursi : " + kplKursi);


            // }
           
            showRute();
            // for(int y = 0; y < ruteArr.size(); y++)
            // {
            //     rute rte = ruteArr.get(y);
                
            //     String asal = rte.getAsal();
            //     String tujuan = rte.getTujuan();
            //     int timeTravl = rte.getDurasiPerjalanan();
            //     System.out.println("No : " + (y + 1) + ", Rute Asal : " + asal + ", Rute tujuan : " + tujuan + ", durasi : " + timeTravl);


            // }
            System.out.println("==========================\n");

            String  jdwlId = "JDW" + randomUID();

            System.out.print("Pilih kapal :");
            int indx_kapal = Integer.parseInt(br.readLine());
            System.out.print("Pilih rute : ");
            int indx_rute = Integer.parseInt(br.readLine());
            String kapal_name = "";
            String kapal_rute = "";
            
            for(int i = 0; i < kapalArr.size(); i++)
            {
                if ((indx_kapal - 1) == i) {
                    kapal kpl2 = kapalArr.get(i);
                    kapal_name = kpl2.getNamaKapal();
                     
                }
            }
            for(int j = 0; j < ruteArr.size(); j++)
            {
                if ((indx_rute - 1) == j) {
                    rute rte = ruteArr.get(j);
                    kapal_rute = rte.getAsal() + " - " + rte.getTujuan() ;
                }
            }
            System.out.print("Tanggal Berangkat : ");
            String berangkat = br.readLine();

            jadwal jdl = new jadwal(jdwlId, kapal_name, kapal_rute, berangkat);
            jadwalArr.add(jdl);

        } catch (Exception e) {
            System.out.println("error "  + e);
        }

    }

    static void updateKapal() throws IOException
    {
        cls();
        showKapal();
        if (kapalArr.size() == 0 ) {
            return;
            
        }else{
            System.out.println("Ubah nomor : ");
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

    static void updateRute() throws IOException
    {
        cls();
        showRute();
        if (ruteArr.size() == 0 ) {
            return;
            
        }else
        {
            System.out.println("Ubah nomor : ");
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

                    System.out.println("Durasi Rute baru");
                    int time_rute_new = Integer.parseInt(br.readLine());
                    newRte.setDurasiPerjalanan(time_rute_new);

                    System.out.println("Berhasil di Update");
                }
            }
        }
        

    }

    static void updateJadwal() throws IOException
    {
        cls();
        showJadwal();
        System.out.println("Ubah nomor : ");
        int indx_jdwl = Integer.parseInt(br.readLine());

        for(int i = 0 ; i< jadwalArr.size() ; i++)
        {
            if ((indx_jdwl - 1) == i) {
                // err handling ketika pilih kapal/rute tidak sesuai dgn list !

                jadwal newJdwl = jadwalArr.get(i);
                System.out.println("------------------");
                showKapal();
                showRute();
                System.out.print("Pilih Kapal baru : ");
                int indx_kapal_new = Integer.parseInt(br.readLine());
                
                System.out.print("Pilih Rute baru : ");
                int indx_rute_new = Integer.parseInt(br.readLine());
                
                for(int j = 0; j < kapalArr.size(); j++) // pilih kapal berdasarkan nomor 
                {
                    if ((indx_kapal_new - 1) == j) {
                        kapal kpl2 = kapalArr.get(j);
                        String kapal_name_new = kpl2.getNamaKapal();
                        newJdwl.setNamaKapal(kapal_name_new);
                    }
                }
                for(int x = 0; x < ruteArr.size(); x++) // pilih rute berdasarkan nomor 
                {
                    if ((indx_rute_new - 1) == x) {
                        rute newRte = ruteArr.get(x);
                        String kapal_rute_new = newRte.getAsal() + " - " + newRte.getTujuan() ;
                        newJdwl.setRute(kapal_rute_new);
                    }   
                }

                System.out.print("Tanggal berangkat :");
                String berangkat_new = br.readLine();
                newJdwl.setWaktuBerangkat(berangkat_new);
                System.out.println("Berhasil di update....");


            }
        }

    }

    static void deleteKapal() throws IOException
    {
        // buat err handl ketika kapal yg dipakek sama jadwal dihapus, tampilkan warning

        cls();
        showKapal();
        try {
            System.out.print("Hapus nomor : ");
            int del = Integer.parseInt(br.readLine());
            kapalArr.remove(del-1);
            System.out.println("Berhasil dihapus....");  
        } catch (Exception e) {
            System.out.println("Oops!");
        }
       
    }

    static void deleteRute() throws IOException
    {
        // buat err handl ketika rute yg dipakek sama jadwal dihapus, tampilkan warning
        cls();
        showRute();
        try {
            System.out.println("Hapus nomor : ");
            int del = Integer.parseInt(br.readLine());
            ruteArr.remove(del-1);
            System.out.println("Berhasil dihapus....");    
        } catch (Exception e) {
            System.out.println("oops!");
        }
        
    }

    static void deleteJadwal() throws IOException
    {
        cls();
        showJadwal();
        try {
            System.out.println("Hapus nomor : ");
            int del = Integer.parseInt(br.readLine());
            jadwalArr.remove(del-1);
            System.out.println("Berhasil dihapus....");
        } catch (Exception e) {
            System.out.println("Opps!");
        }
        
    }
    

    public static void main(String[] args) throws IOException {
        

        // loop -> label buat looper/while supaya bisa di panggil lagi dan di stop pada case 5

        loop: while ( true ) {
            System.out.println("====================");
            System.out.println("1. Lihat Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
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
                    System.out.println("> 2. Tambah data jadwal");
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
                case 5:
                    System.out.println("Coding is fun, bye.. :)");

                    break loop; 
                default:
                    break;
            }
        }

    }
}
