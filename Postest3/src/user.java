// package myPackage;

public class user {
    String username;
    String password;

    public user(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }

    public static void cls() 
    {     
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    
    }
    
}
