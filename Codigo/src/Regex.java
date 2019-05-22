import java.util.regex.*;

public class Regex {

    public String Tildes(String s){
        s = s.replaceAll("[áàä]","a");
        s = s.replaceAll("[éèë]","e");
        s = s.replaceAll("[íìï]","i");
        //s = s.replaceAll("ñ","n"); //En caso de querer sustituir las "ñ" por "n".
        s = s.replaceAll("[óòö]","o");
        s = s.replaceAll("[úùü]","u");
        s = s.replaceAll("[ýÿ]","y");
        return s;
    }

    public String Minus(String s){
        s = s.toLowerCase();
        return s;
    }

    public String Strip_symbolnum(String s){
        s = s.replaceAll("[^a-z(?:ñ)]",""); //Todo que no sea un caracter lo ELIMINA, a excepcion de la "ñ"
        return s;
    }
}
