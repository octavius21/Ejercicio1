package com.example.ejercicio1formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import android.content.Context;

import com.example.ejercicio1formulario.Fecha.FNacimiento;
import com.example.ejercicio1formulario.Persona.Usuario;
import com.example.ejercicio1formulario.Fecha.DatosCuriosos;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer mp;
    static Context contexto;
    private static final String LOGTAG="Informacion";
    Button btnFNacimiento,btnEdad,btnRFC,btnSignoZ,btnSignoZC,btnInfoRec;
    EditText etNombre, etSNombre, etApPaterno, etApMaterno, etFNacimiento,etEdad,etRFC,etSignoZ,etSignoZC;
    final FNacimiento nacimiento=new FNacimiento();
    final DatosCuriosos dc= new DatosCuriosos();
    Usuario user=new Usuario();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp=MediaPlayer.create(this,R.raw.halotheme);
        mp.start();

        etNombre=findViewById(R.id.etNombre);
        etSNombre=findViewById(R.id.etSNombre);
        etApPaterno=findViewById(R.id.etApPaterno);
        etApMaterno=findViewById(R.id.etApMaterno);
        etFNacimiento=findViewById(R.id.etFNacimiento);
        etEdad=findViewById(R.id.etEdad);
        etRFC=findViewById(R.id.etRFC);
        etSignoZ=findViewById(R.id.etSignoZ);
        etSignoZC=findViewById(R.id.etSignoZC);

        btnFNacimiento=findViewById(R.id.btnFNacimiento);
        btnEdad=findViewById(R.id.btnEdad);
        btnRFC=findViewById(R.id.btnRFC);
        btnSignoZ=findViewById(R.id.btnSignoZ);
        btnSignoZC=findViewById(R.id.btnSignoZC);
        btnInfoRec=findViewById(R.id.btnInfoRec);

        btnInfoRec.setOnClickListener(this);
        btnFNacimiento.setOnClickListener(this);
        btnEdad.setOnClickListener(this);
        btnRFC.setOnClickListener(this);
        btnSignoZ.setOnClickListener(this);
        btnSignoZC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnInfoRec:
                //guardando datos en user
                user.setNombre(etNombre.getText().toString().toUpperCase());
                user.setSnombre(etSNombre.getText().toString().toUpperCase());
                user.setAppaterno(etApPaterno.getText().toString().toUpperCase());
                user.setAppmaterno(etApMaterno.getText().toString().toUpperCase());
                user.setFnacimiento(nacimiento.getCalendario().getTime());
                user.setEdad((!etEdad.getText().toString().isEmpty())?Integer.parseInt(etEdad.getText().toString()):-1);
                user.setRfc(etRFC.getText().toString().toUpperCase());
                user.setSignoz(etSignoZ.getText().toString().toUpperCase());
                user.setSignozc(etSignoZC.getText().toString().toUpperCase());

                Log.i(LOGTAG,"Datos: "+user.getNombre()+" S: "+user.getSnombre()+" AP: "+user.getAppaterno()+" AM: "+user.getAppmaterno()+" FN: "+user.getFnacimiento()+" Edad: "+user.getEdad()+" RFC: "+user.getRfc());

                if(!user.validarDatos(user.getNombre(), user.getSnombre(), user.getAppaterno(), user.getAppmaterno())
                 ||user.getFnacimiento()==null||user.getRfc()==null||user.getSignoz()==null||user.getSignozc()==null||user.getEdad()==-1){

                    Toast.makeText(MainActivity.this, getResources().getText(R.string.obligacion), Toast.LENGTH_SHORT).show();

                    if(etNombre.getText().toString().isEmpty())
                        etNombre.setError(getResources().getString(R.string.obligatorio));

                    if(etApPaterno.getText().toString().isEmpty())
                        etApPaterno.setError(getResources().getString(R.string.obligatorio));

                    if(etApMaterno.getText().toString().isEmpty())
                        etApMaterno.setError(getResources().getString(R.string.obligatorio));

                    //etFNacimiento.getText().length()!=0
                    if(etFNacimiento.getText().toString().isEmpty())
                        etFNacimiento.setError(getResources().getString(R.string.obligatorio));
                    if(etEdad.getText().toString().isEmpty())
                        etEdad.setError(getResources().getString(R.string.obligatorio));
                    if(etRFC.getText().toString().isEmpty())
                        etRFC.setError(getResources().getString(R.string.obligatorio));
                    if(etSignoZ.getText().toString().isEmpty())
                        etSignoZ.setError(getResources().getString(R.string.obligatorio));
                    if(etSignoZC.getText().toString().isEmpty())
                        etSignoZC.setError(getResources().getString(R.string.obligatorio));

                }else{

                    Toast.makeText(MainActivity.this, getResources().getString(R.string.guardando), Toast.LENGTH_SHORT).show();
                    //empaquetar los datos
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user",user);
                    //Podria ir o no pero los datos ya los meti en usurio
                    //bundle.putSerializable("fechas",nacimiento);
                    //bundle.putSerializable("cs",dc);
                    //paso de actividad
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    //metiendo mi empaquetado a mi intent
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
            case R.id.btnFNacimiento:
                nacimiento.asignacionFecha();
                DatePickerDialog datePickerDialog =new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                //Realizar comprobacion de dia de nacimeinto que no sea igual o mayor que la fecha actual
                                nacimiento.getCalendario().set(Calendar.YEAR,year);
                                nacimiento.getCalendario().set(Calendar.MONTH,month);
                                nacimiento.getCalendario().set(Calendar.DAY_OF_MONTH,dayOfMonth);
                                if(nacimiento.validarFecha(nacimiento.getCalendario().get(Calendar.YEAR), nacimiento.getCalendario().get(Calendar.MONTH), nacimiento.getCalendario().get(Calendar.DAY_OF_MONTH))) {
                                    //Mensaje
                                    Log.i(LOGTAG, "Fecha de Nacimiento" + nacimiento.getCalendario().getTime());
                                    Toast.makeText(MainActivity.this, getResources().getString(R.string.fnacimiento)+": "+ nacimiento.getCalendario().getTime(), Toast.LENGTH_SHORT).show();
                                    //convierto en String la fecha
                                    String currentDateString = DateFormat.getDateInstance().format(nacimiento.getCalendario().getTime());
                                    //La pone en su Plain text
                                    etFNacimiento.setText(currentDateString);
                                    //guardo el fecha de nacimiento en campos separados
                                    nacimiento.setDia(dayOfMonth);
                                    dc.setDiaN(nacimiento.getDia());
                                    nacimiento.setMes(month+1);
                                    dc.setMesN(nacimiento.getMes());
                                    nacimiento.setAño(year);
                                    dc.setAñoN(nacimiento.getAño());
                                    Log.i(LOGTAG, "Fecha de Nac por partes:" + nacimiento.getDia() + "/" + nacimiento.getMes() + "/" + nacimiento.getAño());
                                }else{
                                    etFNacimiento.setError(getResources().getString(R.string.maxfech));
                                    Toast.makeText(MainActivity.this, getResources().getString(R.string.maxfech), Toast.LENGTH_SHORT).show();
                                    etFNacimiento.setText("");
                                }
                            }
                        }
                        ,nacimiento.getAño() , nacimiento.getMes(), nacimiento.getDia());
                datePickerDialog.show();
                break;

            case R.id.btnEdad:
                if(etFNacimiento.getText().toString().isEmpty())
                    etFNacimiento.setError(getResources().getString(R.string.obligatorio));
                else {
                    Log.i(LOGTAG, "Fecha de Nac por partes para la edad:" + dc.getDiaN() + "/" + dc.getMesN() + "/" + dc.getAñoN());
                    etEdad.setText(dc.convertIntToString(dc.calculoEdad(dc.getDiaN(), dc.getMesN(), dc.getAñoN())));
                }
                break;

            case R.id.btnRFC:
                Log.i(LOGTAG,"RFC "+etNombre.getText().toString().isEmpty()+etApPaterno.getText().toString().isEmpty()+etApMaterno.getText().toString().isEmpty()+etFNacimiento.getText().toString().isEmpty());
                if(true==(etNombre.getText().toString().isEmpty()||etApPaterno.getText().toString().isEmpty()||etApMaterno.getText().toString().isEmpty()||etFNacimiento.getText().toString().isEmpty())){
                    if(etNombre.getText().toString().isEmpty())
                        etNombre.setError(getResources().getString(R.string.obligatorio));

                    if(etApPaterno.getText().toString().isEmpty())
                        etApPaterno.setError(getResources().getString(R.string.obligatorio));

                    if(etApMaterno.getText().toString().isEmpty())
                        etApMaterno.setError(getResources().getString(R.string.obligatorio));
                    //etFNacimiento.getText().length()!=0
                    if(etFNacimiento.getText().toString().isEmpty())
                        etFNacimiento.setError(getResources().getString(R.string.obligatorio));
                }else {
                    user.setNombre(etNombre.getText().toString());
                    user.setSnombre(etSNombre.getText().toString());
                    user.setAppaterno(etApPaterno.getText().toString());
                    user.setAppmaterno(etApMaterno.getText().toString());
                    user.setFnacimiento(nacimiento.getCalendario().getTime());
                    Log.i(LOGTAG, "Fecha de Nac por partes para RFC:" + dc.getDiaN() + "/" + dc.getMesN() + "/" + dc.getAñoN());
                    etRFC.setText(user.ObtenerRfc(dc.getAñoN(), dc.getMesN(), dc.getDiaN()));
                    Log.i(LOGTAG, " RFC:" + user.getRfc());
                }
                break;
            case R.id.btnSignoZ:
                if(etFNacimiento.getText().toString().isEmpty())
                    etFNacimiento.setError(getResources().getString(R.string.obligatorio));
                else{
                    etSignoZ.setText(dc.calculoZodiacal(getApplicationContext(),dc.getDiaN(), dc.getMesN(), dc.getAñoN()));
                }
                break;
            case R.id.btnSignoZC:
                if(etFNacimiento.getText().toString().isEmpty())
                    etFNacimiento.setError(getResources().getString(R.string.obligatorio));
                else{
                    etSignoZC.setText(dc.calculoZodiacalChino(getApplicationContext(),dc.getAñoN()));
                }
                break;

            default:
              break;
        }//swtich
    }//onclick
    @Override
    protected void onStart(){
        super.onStart();
    }
    @Override
    protected void onResume(){
        //cuando se va y vuelve el usuario para que permanezca la info
        super.onResume();
    }
    @Override
    protected  void onPause(){
        super.onPause();
        mp.pause();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        mp.start();
    }
    @Override
    protected  void onStop(){
        super.onStop();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }


}
