package com.example.ejercicio1formulario.Fecha;

import android.app.DatePickerDialog;
import android.os.Build;
import android.util.Log;
import android.widget.DatePicker;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FNacimiento implements Serializable {
    //Atributos
    private static final String LOGTAG="FN";
    private int dia, mes, año;
    final private Calendar calendario= Calendar.getInstance();
    //Cosntructores

    //Metodos
        public static Date convertFecha(String fecha){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDate=null;
            try{
                fechaDate=simpleDateFormat.parse(fecha);
            }catch(ParseException ex){
                Log.i(LOGTAG, "1fechacomocadena: "+fecha+"  "+"fechacomodate: "+fechaDate);
            }
            return fechaDate;
        }
        public static String convertFecha(Date fecha){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
            String fechacomocadena=simpleDateFormat.format(fecha);
            Log.i(LOGTAG, "2fechacomocadena: "+fechacomocadena+"  "+"fechacomodate: "+fecha);
            return fechacomocadena;
        }
        public void asignacionFecha(){
            año=getCalendario().get(Calendar.YEAR);
            mes=getCalendario().get(Calendar.MONTH);
            dia=getCalendario().get(Calendar.DAY_OF_MONTH);
        }
        public boolean validarFecha(int año, int mes, int dia){
            final Calendar today= Calendar.getInstance();
            int ahoy =today.get(Calendar.YEAR);
            int mhoy=today.get(Calendar.MONTH);
            int dhoy=today.get(Calendar.DAY_OF_MONTH);
            Log.i(LOGTAG, dhoy+"vs"+dia+"/"+ahoy+"vs"+año);
            if(año<ahoy){
                return true;
            }else if(mes<mhoy){
                return true;
            }else if(dia<=dhoy){
                return true;
            }else{
                return  false;
            }

        }
     //Getters y Setters
     public Calendar getCalendario() {
         return calendario;
     }
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }




}
