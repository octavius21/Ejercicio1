package com.example.ejercicio1formulario.Persona;

import android.content.Context;
import android.util.Log;

import java.io.Serializable;
import java.util.Date;
import android.content.Context;

public class Usuario implements Serializable {
    //Atributos
    private static final String LOGTAG="USER";
    private String nombre;
    private String snombre;
    private String appaterno;
    private String appmaterno;
    private Date fnacimiento;
    private int edad;
    private String rfc;
    private String signoz;
    private String signozc;
    private Context contexto;
    //Constructores
    //Metodos
    public String ObtenerRfc(int año,int mes,int dia){
        String aux1=Integer.toString(año);
        //comieenza en el tercer dato
        aux1=aux1.substring(2);
        if(mes<9){
            String aux2=Integer.toString(mes);
            //se le agrega el 0
            aux2="0"+mes;
            if(dia<9){
                String aux3=Integer.toString(mes);
                //se le agrega el 0
                aux3="0"+dia;
                Log.i(LOGTAG, " "+getAppaterno().substring(0,2)+getAppmaterno().substring(0,1)+getNombre().substring(0,1)+aux1+aux2+aux3);
                rfc=getAppaterno().substring(0,2)+getAppmaterno().substring(0,1)+getNombre().substring(0,1)+aux1+aux2+aux3;
            }else {
                Log.i(LOGTAG, " " + getAppaterno().substring(0,2) + getAppmaterno().substring(0,1) + getNombre().substring(0,1) + aux1 + aux2 + dia);
                rfc = getAppaterno().substring(0,2) + getAppmaterno().substring(0,1) + getNombre().substring(0,1) + aux1 + aux2 + dia;
                return rfc;
            }
        }else if(dia<9){
            String aux3=Integer.toString(mes);
            //se le agrega el 0
            aux3="0"+dia;
            rfc=getAppaterno().substring(0,2)+getAppmaterno().substring(0,1)+getNombre().substring(0,1)+aux1+mes+aux3;
            return rfc;
        }else
        rfc=getAppaterno().substring(0,2)+getAppmaterno().substring(0,1)+getNombre().substring(0,1)+aux1+mes+dia;
        return rfc;
    }

    public boolean validarDatos(String nombre, String snombre,String appaterno, String apmaterno){
        Log.i(LOGTAG, nombre+" "+snombre+" "+appaterno+" "+apmaterno);
            if(nombre==null || appaterno==null || apmaterno==null) {
                return false;
            }else{
                return true;
            }
    }
        //Getters y Setters
    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getAppmaterno() {
        return appmaterno;
    }

    public void setAppmaterno(String appmaterno) {
        this.appmaterno = appmaterno;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getSignoz() {
        return signoz;
    }

    public void setSignoz(String signoz) {
        this.signoz = signoz;
    }

    public String getSignozc() {
        return signozc;
    }

    public void setSignozc(String signozc) {
        this.signozc = signozc;
    }
}
