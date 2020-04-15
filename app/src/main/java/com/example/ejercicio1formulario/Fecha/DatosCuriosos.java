package com.example.ejercicio1formulario.Fecha;
import android.content.Context;
import android.util.Log;
import com.example.ejercicio1formulario.R;
import java.io.Serializable;
import java.util.Calendar;

public class DatosCuriosos implements Serializable {
    private static final String LOGTAG="DC";
    private int diaN;
    private int mesN;
    private int añoN;
    private int edad;
    private String signozodiacal;
    private String signozodiacalchino;
    private Context contexto;

    public String calculoZodiacal(Context contexto,int dianac, int mesnac, int añonac){
        this.contexto=contexto;
        switch(mesnac){
            case 1:
                //Enero
                if(dianac>21)
                    return contexto.getResources().getString(R.string.acuario);
                else
                    return contexto.getResources().getString(R.string.capricornio);
            case 2:
                //Febrero
                if(dianac>21)
                    return contexto.getResources().getString(R.string.piscis);
                else
                    return contexto.getResources().getString(R.string.acuario);
            case 3:
                //Marzo
                if(dianac>=21)
                    return contexto.getResources().getString(R.string.aries);
                else
                    return contexto.getResources().getString(R.string.piscis);
            case 4:
                //Abril
                if(dianac>21)
                    return contexto.getResources().getString(R.string.tauro);
                else
                    return contexto.getResources().getString(R.string.aries);
            case 5:
                //Mayo
                if(dianac>21)
                    return contexto.getResources().getString(R.string.geminis);
                else
                    return contexto.getResources().getString(R.string.tauro);
            case 6:
                //junio
                if(dianac>21)
                    return contexto.getResources().getString(R.string.cancer);
                else
                    return contexto.getResources().getString(R.string.geminis);
            case 7:
                //julio
                if(dianac>21)
                    return contexto.getResources().getString(R.string.leo);
                else
                    return contexto.getResources().getString(R.string.cancer);
            case 8:
                //agosto
                if(dianac>21)
                    return contexto.getResources().getString(R.string.virgo);
                else
                    return contexto.getResources().getString(R.string.leo);
            case 9:
                //septiembre
                if(dianac>21)
                    return contexto.getResources().getString(R.string.libra);
                else
                    return contexto.getResources().getString(R.string.virgo);
            case 10:
                //Octubre
                if(dianac>21)
                    return contexto.getResources().getString(R.string.escorpio);
                else
                    return contexto.getResources().getString(R.string.libra);
            case 11:
                if(dianac>21)
                    return contexto.getResources().getString(R.string.sagitario);
                else
                    return contexto.getResources().getString(R.string.escorpio);
            case 12:
                if(dianac>21)
                    return contexto.getResources().getString(R.string.capricornio);
                else
                    return contexto.getResources().getString(R.string.sagitario);
            default:
                return contexto.getResources().getString(R.string.sayajin);
        }
    }
    public String calculoZodiacalChino(Context contexto,int añonac){
        int resto = añonac % 12;
        switch (resto) {
            case 0: return contexto.getResources().getString(R.string.mono);
            case 1: return contexto.getResources().getString(R.string.gallo);
            case 2: return contexto.getResources().getString(R.string.perro);
            case 3: return contexto.getResources().getString(R.string.cerdo);
            case 4: return contexto.getResources().getString(R.string.rata);
            case 5: return contexto.getResources().getString(R.string.buey);
            case 6: return contexto.getResources().getString(R.string.tigre);
            case 7: return contexto.getResources().getString(R.string.conejo);
            case 8: return contexto.getResources().getString(R.string.dragon);
            case 9: return contexto.getResources().getString(R.string.serpiente);
            case 10: return contexto.getResources().getString(R.string.caballo);
            case 11: return contexto.getResources().getString(R.string.cabra);
            default: return contexto.getResources().getString(R.string.sayajin);
        }
    }

    public int calculoEdad(int dianac, int mesnac, int añonac){
        Log.i(LOGTAG, "1 dianac "+dianac+" mesnac "+mesnac+" añonac "+añonac);
        final Calendar today= Calendar.getInstance();
        int ahoy =today.get(Calendar.YEAR);
        int mhoy=today.get(Calendar.MONTH+1);
        int dhoy=today.get(Calendar.DAY_OF_MONTH);
        Log.i(LOGTAG, "1 diahoy "+dhoy+" meshoy "+mhoy+" añohoy "+ahoy);
        int edad=ahoy-añonac;
        int aux=mhoy-mesnac;
        if(añonac<ahoy){
            if(mesnac>mhoy){
                Log.i(LOGTAG, "1 edad "+edad);
                return (edad-1);
            }else if(mesnac==mhoy){
                if(dianac<=dhoy){
                    Log.i(LOGTAG, "2 edad "+edad);
                    return(edad);
                }else {
                    Log.i(LOGTAG, "3 edad "+edad);
                    return (edad-1);
                }
            }else if(mesnac<mhoy) {
                Log.i(LOGTAG, "4 edad " + edad);
                return (edad);
            }
        }
            Log.i(LOGTAG, "5 edad "+edad);
        return 0;
    }
    public String convertIntToString(int edad){
        String sedad=String.valueOf(edad);
        return sedad;
        }

    public int getDiaN() {
        return diaN;
    }

    public void setDiaN(int diaN) {
        this.diaN = diaN;
    }

    public int getMesN() {
        return mesN;
    }

    public void setMesN(int mesN) {
        this.mesN = mesN;
    }

    public int getAñoN() {
        return añoN;
    }

    public void setAñoN(int añoN) {
        this.añoN = añoN;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getSignozodiacal() {
        return signozodiacal;
    }

    public void setSignozodiacal(String signozodiacal) {
        this.signozodiacal = signozodiacal;
    }

    public String getSignozodiacalchino() {
        return signozodiacalchino;
    }

    public void setSignozodiacalchino(String signozodiacalchino) {
        this.signozodiacalchino = signozodiacalchino;
    }

}
