package com.example.ejercicio1formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ejercicio1formulario.Fecha.FNacimiento;
import com.example.ejercicio1formulario.Persona.Usuario;

public class Main2Activity extends AppCompatActivity {
    private static final String LOGTAG="Informacion2";
    Usuario user =new Usuario();
    TextView tvnombre,tvsnombre,tvapmaterno,tvappaterno,tvfn,tvedad,tvrfc,tvsignoz,tvsignozc;

    FNacimiento fechas= new FNacimiento();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //amtes de setcontent
        overridePendingTransition(R.anim.meter,R.anim.mantener);

        setContentView(R.layout.activity_main2);
        Bundle bundle = new Bundle();
        bundle=getIntent().getExtras();
        user=(Usuario)bundle.getSerializable("user");
        //puede ir o no
        //fechas=(FNacimiento)bundle.getSerializable("fechas");
        tvnombre=findViewById(R.id.tvnombre);
        tvsnombre=findViewById(R.id.tvsnombre);
        tvapmaterno=findViewById(R.id.tvapmaterno);
        tvappaterno=findViewById(R.id.tvappaterno);
        tvfn=findViewById(R.id.tvfn);
        tvedad=findViewById(R.id.tvedad);
        tvrfc=findViewById(R.id.tvrfc);
        tvsignoz=findViewById(R.id.tvsignoz);
        tvsignozc=findViewById(R.id.tvsignozc);

        tvnombre.setText(user.getNombre());
        tvsnombre.setText(user.getSnombre());
        tvapmaterno.setText(user.getAppmaterno());
        tvappaterno.setText(user.getAppaterno());
        tvfn.setText(user.getFnacimiento().toString().substring(8,10)+"/"+user.getFnacimiento().toString().substring(4,7)+"/"+user.getFnacimiento().toString().substring(24));
        tvedad.setText(String.valueOf(user.getEdad()));
        tvrfc.setText(user.getRfc());
        tvsignoz.setText(user.getSignoz());
        tvsignozc.setText(user.getSignozc());



        Log.i(LOGTAG,"Datos: "+user.getNombre()+" S: "+user.getSnombre()+" AP: "+user.getAppaterno()+" AM: "+user.getAppmaterno()+" FN: "+user.getFnacimiento()+" edad: "+user.getEdad());
    }
    @Override
    protected void onStop(){
        super.onStop();
        finish();
    }
    @Override
    protected  void onPause(){
        super.onPause();
        overridePendingTransition(R.anim.mantener,R.anim.sacar);
    }
}
