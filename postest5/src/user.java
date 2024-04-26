// package myPackage;
import java.io.IOException;

public abstract class user {
    protected String username,password, name, role;
    public abstract void menu() throws IOException;
    
    public user(String username, String password, String name, String role)
    {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    protected void profil()
    {
        System.out.println("nama : " + this.name);
        System.out.println("username : " + this.username);
        
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
