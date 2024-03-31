// package myPackage;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
// import java.util.ArrayList;

public class costumer extends user{
    private String role = "costumer";
    private static InputStreamReader sr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(sr);
    // private static ArrayList<costumer> costumerArr = new ArrayList<>();
    // private static ArrayList<String> costumerOrder = new ArrayList<>();

    public costumer(String username, String password,String name, String role)
    {   
        super(username, password, name);
        this.role = role;

    }
    public String getRole()
    {
        return role;
    }

    // public void setCSOrder()
    // {

    // }

    @Override
    protected void profil()
    {
        cls();
        super.profil();
        System.out.println("Role : " + this.role);
        
    }
    protected void profil(boolean show)
    {
        if (show)profil();
        else super.profil();

    }

    @Override
    public void menu() throws IOException
    {
        try {
            cls();
            
            // Pemesanan pmsn = new Pemesanan();
            System.out.println("-- selamat datang di pemesanan tiket kapal --");

            while (true) {
                
                // String name = App.getUser();
                // System.out.println(name);
                // admin.showJadwal();
                System.out.println("1. pesan tiket");
                System.out.println("2. Lihat Pesanan");
                System.out.println("3. Profil");
                System.out.println("0. Keluar");
                System.out.print("Pilih : ");
                int pilih = Integer.parseInt(br.readLine());

                switch (pilih) {
                    case 1 ->{
                        Pemesanan.setPemesanan();
                        System.out.println("\n\ntekan enter untuk lanjut..");
                        br.readLine();
                    }
                    case 2 ->{
                        Pemesanan.getPemesanan();
                        System.out.println("\n\ntekan enter untuk lanjut..");
                        br.readLine();

                    }
                    case 3 -> {
                        profil(false);
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
