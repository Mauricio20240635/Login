/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauri
 */
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Cifrado {
    
    /**
     *
     * @param texto
     * @return
     * @throws Exception
     */
    public String cifrar(String texto) throws Exception {
        // Generar una clave secreta
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey clave = keyGenerator.generateKey();

        // Cifrar el texto con la clave secreta
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        byte[] textoCifrado = cipher.doFinal(texto.getBytes());

        // Codificar el texto cifrado en Base64
        byte[] claveEnBytes = clave.getEncoded();
        String claveEnBase64 = Base64.getEncoder().encodeToString(claveEnBytes);
        String textoCifradoEnBase64 = Base64.getEncoder().encodeToString(textoCifrado);

        // Combinar la clave y el texto cifrado en un solo string separado por un guion
        return claveEnBase64 + "-" + textoCifradoEnBase64;
    }
    
       public String decifrar(String texto) throws Exception {
           String textoCifrado = texto;
String[] partes = textoCifrado.split("-");
String claveEnBase64 = partes[0];
String textoCifradoEnBase64 = partes[1];


byte[] claveEnBytes = Base64.getDecoder().decode(claveEnBase64);
byte[] textoCifradoEnBytes = Base64.getDecoder().decode(textoCifradoEnBase64);

SecretKeySpec clave = new SecretKeySpec(claveEnBytes, "AES");

Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, clave);
byte[] textoDescifradoEnBytes = cipher.doFinal(textoCifradoEnBytes);
String textoDescifrado = new String(textoDescifradoEnBytes);

System.out.println(textoDescifrado);
return textoDescifrado;
       }
    
    
    
    
}
