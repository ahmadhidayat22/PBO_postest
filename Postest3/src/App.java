
import java.util.ArrayList;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

// class_rute, class_kapal, class_jadwal

public class App {
    private static InputStreamReader sr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(sr);
    private static ArrayList<costumer> costumerArr = new ArrayList<>();
    private static String name= "pe";
    public static void greeting(String name)
    {

        for(int i = 0; i < costumerArr.size(); i++){
            costumer cs = costumerArr.get(i);
            String csName = cs.getUsername();

            if (name.equals(csName)) {
             System.out.println("Hallo, " + csName);
                
            }
            // String csName = cs.getUsername();
            // String csPass = cs.getPassword();
            // System.out.println(csName + csPass);

        } 
        
    }
    public static String getUser()
    {
        
        return name;

    }

    protected static void cls() 
    {     
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    
    }

    
    public static void main(String[] args) throws IOException {
        admin thisAdmin = new admin("q", "q", "Admin");
        // costumer myCostumer = new costumer("w", "w", "Costumer");
        try {

            while (true) {
                // cls();
                
                System.out.println("Pemesanan tiket kapal");
                System.out.println("1. Admin");
                System.out.println("2. User");
                System.out.println("0. Exit");
                System.out.print("Pilih :");
                int menu = Integer.parseInt(br.readLine());
                switch (menu) {
                    case 1:
                        System.out.print("Username :");
                        String Username = br.readLine();
                        System.out.print("Password :");
                        String Password = br.readLine();
    
                        if (Username.equalsIgnoreCase(thisAdmin.getUsername()) && Password.equalsIgnoreCase(thisAdmin.getPassword())) {
                            thisAdmin.menuAdmin();
                        }
                        else{
                            System.out.println("username/password salah");
                            br.readLine();
                        }
                        break;
                
                    case 2 :
                        System.out.println("1. Masuk");
                        System.out.println("2. Buat akun");
                        System.out.println("0. kembali");
                        System.out.print("Pilih :");
                        int pilih = Integer.parseInt(br.readLine());
                        switch (pilih) {
                            case 1 ->{
                                if (costumerArr.size() == 0) {
                                    System.out.println("belum ada data akun");

                                    br.readLine();
                                }else{
                                    System.out.print("Username :");
                                    String UsernameCs = br.readLine();
                                    System.out.print("Password :");
                                    String PasswordCs = br.readLine();
                                    boolean match = false ;
                                    for(int i = 0 ; i< costumerArr.size(); i++)
                                    {
                                        costumer csArr = costumerArr.get(i);
                                        String findUsername = csArr.getUsername();
                                        String findPassword = csArr.getPassword();
                                        if (UsernameCs.equals(findUsername) && PasswordCs.equals(findPassword)) {
                                             // goto user menu
                                            // System.out.println("berhasil login");
                                            // greeting(UsernameCs);
                                            csArr.menuUser();
                                            match = true;
                                            break;
                                        }
                                        else{
                                            match = false;

                                        }
                                    }
                                    if (!match) {
                                        System.out.println("username/password salah");
                                        br.readLine();

                                    }

                                    
                                }
                            }
                            case 2 ->{
                                while (true) {
                                    
                                    System.out.println("Buat Akun ");
                                    System.out.print("new username :");
                                    String newUsername = br.readLine();
                                    System.out.print("new password :");
                                    String newPassword = br.readLine();
                                    System.out.print("confirm new password :");
                                    String newConfirmPassword = br.readLine();
                        
                                    if (newPassword.equals(newConfirmPassword)) {
                                        System.out.println("akun berhasil dibuat...");

                                        costumer cs = new costumer(newUsername, newPassword, newConfirmPassword);
                                        costumerArr.add(cs);
                                        br.readLine();
                                        break;
    
                                        
    
                                    }else{
                                        System.out.println("Password dan konfirmasi password tidak sama!");
                                        br.readLine();
                                        
                                    }
                                
                                }
                            }
                            case 0 -> {
                                break;
                            }
                            default -> {
                                System.out.println("Upps!");
                                br.readLine();
                            }
                        }
                        
                        break;
                    case 0 :
                            System.out.println("Thankyou");
                            System.exit(0);
                            break;
                    default:
                        System.out.println("Uppss!");
                        br.readLine();
                        break;
                }
                
                
            }
    
          
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("error: " + e );
        }
        
    }
}
