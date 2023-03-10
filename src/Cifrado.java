/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauri
 */
public class Cifrado {
    public String encriptar(String palabra) {
        String encriptado = "";
        char caracteres[] = palabra.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            int b = caracteres[i];
            if (b > 64 && b < 123) {
                caracteres[i] = (char) (caracteres[i] + (char) 3);
            }
        }
        int inicio = 0;
        int fin = caracteres.length - 1;
        char temp;
        while (fin > inicio) {
            temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fin];
            caracteres[fin] = temp;
            fin--;
            inicio++;
        }
        double a = caracteres.length / 2;
        int valor = (int) a;
        for (int i = valor; i < caracteres.length; i++) {
            caracteres[i] = (char) (caracteres[i] - (char) 1);
        }
        encriptado = String.valueOf(caracteres);

        return encriptado;
    }
    
    
}
