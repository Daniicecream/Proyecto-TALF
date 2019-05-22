//DANIEL VASQUEZ R. INGENIERIA EN INFORMATICA UNIVERSIDAD TECNOLOGICA METROPOLITANA
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class main {

    public static void main(String[] args) throws IOException {

        Regex r = new Regex();

        System.out.println("\t\tINSPECCIONADOR DE TEXTOS\n");
        System.out.println("Iniciando analisis de texto...\n");
        System.out.println("Luego de realizar el analisis, se obtuvo como resultado\nque las diez palabras mas repetidas son:\n");

            //Crear scanner
            FileInputStream fin = new FileInputStream("contador8.txt");
            Scanner sc = new Scanner(fin);

            //Crear Lista que almacenara las palabras
            ArrayList<String> palabras = new ArrayList<String>();
            ArrayList<Integer> contador = new ArrayList<Integer>();

            //Leer el archivo y encontrar palabras
            while(sc.hasNext()){ //Mientras halla texto que leer...

                //Obtener la siguiente palabra
                String sigpalabra =  sc.next();//Guarda lo que no sea un espacio en blanco

                //Transforma la palabra a minusculas
                sigpalabra = r.Minus(sigpalabra);

                //Sustituir letras con tilde
                sigpalabra = r.Tildes(sigpalabra);

                //Eliminar puntuacion y simbolos
                sigpalabra = r.Strip_symbolnum(sigpalabra);

                //Filtrar palabra con REGEX'S


                System.out.println("La cadena resultante es: " + sigpalabra + "\n"); //VERIFICADOR DE RESULTADO

                //Verificar que la palabra no exista en la lista
                if(sigpalabra.isEmpty()){ } //Si el string obtenido esta vacio no hara nada "FILTRO DE CARACTERES VACIOS"
                else{
                    if(palabras.contains(sigpalabra)){ //si el arreglo "palabras" contiene la palabra almacenada en "sigpalabra"
                        int index = palabras.indexOf(sigpalabra); //encuentra la palabra
                        contador.set(index, contador.get(index)+1); //le suma 1 al contador de dicha palabra
                    }
                    else { //si la palabra almacenada en "sigpalabra" no existe en el arreglo "palabras"...
                        palabras.add(sigpalabra); //se agrega al arreglo
                        contador.add(1); //se cuenta como una vez
                    }
                }
        }
        //Cerrar texto y Scanner
        fin.close(); //cerrar texto lectura
        sc.close(); //cerrar escaner

        //Ordenar palabras por contador de mayor a menor

        //Guardar las 10 palabras mas repetidas
        for(int i = 0;i<palabras.size();i++){
            System.out.println(palabras.get(i) + " se ha repetido " + contador.get(i) + " veces.");
        }
        }
}
