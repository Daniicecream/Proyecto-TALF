import java.io.*;
import java.util.*;

public class Archivos {
    private Scanner sc;

    public void Abrir(){
        try{
            sc = new Scanner(new File("ejemplo.txt"));
            System.out.println("Leyendo archivo... ");
        }
        catch(Exception e){
            System.out.println("ERROR: no se pudo encontrar el archivo.");
        }
    }

    public void Leer(){
        String s = "";
        while(sc.hasNext()){ //Mientras halla texto que leer...

            //System.out.println(x.nextLine()+"\n");
            //s = s + sc.nextLine(); // Guarda en un string lo que lea el Scanner del .txt
        }
        System.out.println("Cadena S: \n");
        System.out.println(s);
    }

    public void Cerrar(){
        sc.close();
    }
}
