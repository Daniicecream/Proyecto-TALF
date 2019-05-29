//DANIEL VASQUEZ R. INGENIERIA EN INFORMATICA UNIVERSIDAD TECNOLOGICA METROPOLITANA
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class main {

    public static void main(String[] args) throws IOException {

        Regex r = new Regex();

        System.out.println("\t\tINSPECCIONADOR DE TEXTOS\n");
        System.out.println("Iniciando analisis de texto...\n");
        System.out.println("Proceso ejecutado exitosamente!\nlos resultados fueron almacenados en el archivo\nDiccionario.txt el cual se encuentra en la carpeta del proyecto.");

            //Crear scanner
            FileInputStream fin = new FileInputStream("text2.txt");
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
                sigpalabra = r.Pronombres(sigpalabra); //Elimina Pronombres
                sigpalabra = r.Articulos(sigpalabra); //Elimina Articulos
                sigpalabra = r.Prefijos(sigpalabra); //Elimina Prefijos
                sigpalabra = r.Sufijos(sigpalabra); //Elimina Sufijos

                //System.out.println("La cadena resultante es: " + sigpalabra + "\n"); //VERIFICADOR DE RESULTADO

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
        int auxcta = 0;//variable comparativa para ordenar y aux para almecenar valores de respaldo
        String auxpal; //aux para almacenar palabra de respaldo
        for( int i = 0; i<palabras.size();i++){
            for( int j = i+1;j<palabras.size();j++){
                if(contador.get(i)<contador.get(j)){ //intercambia el menor por el mayor
                    auxcta = contador.get(i);
                    auxpal = palabras.get(i);
                    contador.set(i, contador.get(j));
                    palabras.set(i, palabras.get(j));
                    contador.set(j, auxcta);
                    palabras.set(j, auxpal);
                }
            }
        }

        //Guardar las 10 palabras mas repetidas
        FileOutputStream fos = null;
        File doc = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try{
            doc = new File("Diccionario.txt");
            fos = new FileOutputStream(doc);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);

            bw.write("RESULTADOS DE PROYECTO PORTER:\n");
            bw.newLine();
            bw.write("Analisis del documento...");
            bw.newLine();

            for(int i = 0; i < 20 ;i++){
                bw.write("'" + palabras.get(i) + "'" + " se ha repetido " + contador.get(i) + " veces.");
                bw.newLine();
            }
            bw.flush();
            bw.close();
            osw.close();
            fos.close();
        }
        catch(Exception e){e.printStackTrace();;}

        /*for(int i = 0; i < 20 ;i++){ //VER LOS RESULTADOS EN EL CODIGO
            System.out.println(palabras.get(i) + " se ha repetido " + contador.get(i) + " veces.");
        }*/
        }
}
