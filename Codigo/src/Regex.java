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
        s = s.replaceAll("[^a-z(?:ñ)]|[()?]",""); //Todo que no sea un caracter lo ELIMINA, a excepcion de la "ñ"
        return s;
    }

    public String Pronombres(String s){
        s = s.replaceAll("^est[e|a]s$|^est[o|e|a]$","");
        s = s.replaceAll("^es[o|a]s$|^es[o|e|a]$","");
        s = s.replaceAll("^aquell[o|a]s$|^aquell[o|a]$|^aquel$","");
        s = s.replaceAll("^vuestr[o|a](s)?$|^nuestr[o|a](s)?$|^mi[o|a](s)?$|^tuy[o|a](s)?$|^suy[o|a](s)?$","");
        s = s.replaceAll("^un([o|a])?(s)?$|^primer([o|a])?(s)?$|^segund[o|a](s)?$|^tercer([o|a])?(s)?$|^dos$|^tres$|^cuatro$","");
        s = s.replaceAll("^alguien$|^nadie$|^nada$|^algo$","");
        s = s.replaceAll("^algun([o|a])?(s)?$|^ningun([o|a])?(s)?$|^otr[o|a](s)?$","");
        s = s.replaceAll("^vari[o|a]s$|^tod[o|a](s)?$|^much[o|a](s)?$|^poc[o|a](s)?$|^bastante(s)?$|^para$","");
        s = s.replaceAll("^yo$|^me$|^mi$|^conmigo$|^consigo$|^tu$|^te$|^ti$|^se$|^si$","");
        s = s.replaceAll("^nosotr[o|a]s$|^vosotr[o|a]s$|^ella(s)?$|^ello(s)?$|^le(s)?$","");
        return s;
    }

    public String Articulos(String s){
        s = s.replaceAll("^en$|^el$|^l[o|a](s)?$","");
        return s;
    }

    public String Prefijos(String s){
        s = s.replaceAll("^a|^an","");
        s = s.replaceAll("^ante|^anti","");
        s = s.replaceAll("^bi|^bis","");
        s = s.replaceAll("^co|^con","");
        s = s.replaceAll("^contra","");
        s = s.replaceAll("^de|^des","");
        s = s.replaceAll("^en|^entre","");
        s = s.replaceAll("^ex|^extra","");
        s = s.replaceAll("^hiper|^hipo","");
        s = s.replaceAll("^in|^inter","");
        s = s.replaceAll("^pos(t)?|^pre","");
        s = s.replaceAll("^re|^sub|^super","");
        return s;
    }

    public String Sufijos(String s){
        //SUSTANTIVOS
        s = s.replaceAll("aje$|ancia$|encia$|ante$","");
        s = s.replaceAll("al$|ar$|ario$|cion$|dad$|dor$","");
        s = s.replaceAll("eda$|ero$|eria$|ez$|ista$|ura$","");

        //ADJETIVOS
        s = s.replaceAll("able$|ible$|ado$|ido$|ano$|al$|ar$","");
        s = s.replaceAll("ense$|eño$|iento$|il$|ino$|izo$|oso$|udo$","");

        //VERBOS
        s = s.replaceAll("ear$|ecer$|ificar$|izar$","");

        //AUMENTATIVOS
        s = s.replaceAll("azo$|on$|ote$","");

        //DIMINUTIVOS
        s = s.replaceAll("([c|z])?ito$|([c|z])?illo$|([c|z])?ico$|([c|z])?uelo$|in$","");

        //DESPECTIVOS
        s = s.replaceAll("aco$|acho$|ajo$|astro$|ucho$","");
        return s;
    }
}
