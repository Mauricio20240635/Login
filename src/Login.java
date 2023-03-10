/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauri
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Login extends JFrame {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
  JButton Registrar;
  Archivo txt = new Archivo();

    public Login() {
        
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);

        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton(" Login");
        panel.add(loginButton);
        
        Registrar= new JButton("Registrar");
        panel.add(Registrar);

        Login.HandlerLogin handler = new Login.HandlerLogin();
        loginButton.addActionListener(handler);
        
       Login.HandlerRegistrar handler2 = new Login.HandlerRegistrar();
        Registrar.addActionListener(handler2);
        add(panel);

        setVisible(true);
    }

    
    private class HandlerLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
          String str,str2;
            str =usernameField.getText();
            str2= passwordField.getText();
            boolean Respuesta;
            Respuesta = txt.readToFile(str,str2);
            if(Respuesta=true){
               setVisible(false);
            try {
            // Close current program
            Runtime.getRuntime().exec("taskkill /f /im javaw.exe");

            // Open another program (e.g. Notepad)
            Runtime.getRuntime().exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
            }
        }
    }

      private class HandlerRegistrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
        String str,str2;
            str =usernameField.getText();
            str2= passwordField.getText();
            txt.saveToFile(str,str2);
        }
    }
    
    }
