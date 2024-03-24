package myPackage;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class costumer extends user{
    private String role = "costumer";

    public costumer(String username, String password, String role)
    {   
        super(username, password);
        this.role = role;

    }
    public String getRole()
    {
        return role;
    }


    public void menuUser() throws IOException
    {
        System.out.println("ini menu user");

    }

}
