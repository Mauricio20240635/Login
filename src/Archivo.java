
import java.awt.Component;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauri
 */
public class Archivo {
    Cifrado cf=new Cifrado();
      public void saveToFile(String  username,String password ) throws Exception {
          
        try {
            FileWriter writer = new FileWriter("usuarios.txt", true); // append to file
            writer.write(username + "," + cf.cifrar(password)  + "\n");
            writer.close();
            Component o = null;
            JOptionPane.showMessageDialog(o, "se guardo el usuario y contraseña");
        } catch (IOException e) {
            System.out.println("Error saving user and password to file.");
        }
       }
       
 
    public boolean readToFile(String username, String password) throws Exception {
              boolean s =false;

        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String storedUsername = parts[0];
                String storedPassword = parts[1];
          
              String save=cf.decifrar(storedPassword);
                
                if (username.equals(storedUsername) && password.equals(save)) {
               
                    s=true;
                    
                }
                else{
                       s=false;   
                }
            }

       
        } catch (IOException e) {
        s=false;  
        }
        
         return s;
         }
}




         

