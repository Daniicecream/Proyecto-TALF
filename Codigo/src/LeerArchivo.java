import java.io.*;
import java.util.*;

public class LeerArchivo {
    private Scanner x;

    public void Abrir(){
        try{
            x = new Scanner(new File("ejemplo.txt"));
        }
        catch(Exception e){
            System.out.println("no se pudo encontrar el archivo");
        }
    }

    public void Leer(){
        while(x.hasNext()){
            System.out.println(x.nextLine()+"\n");
        }
    }

    public void Cerrar(){
        x.close();
    }

}
