package com.rolando.todaslasapps;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dialog extends AppCompatActivity{
    Button alertD;
    Button customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        alertD = (Button) findViewById(R.id.alertDialog);
        customDialog = (Button) findViewById(R.id.customDialog);
    }
    public void AlertDialog1(View v){
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setTitle("Alerta");
        ventana.setMessage("Esta seguro de destruir el mundo?");
        ventana.setCancelable(false);
        ventana.setPositiveButton("Si fierro", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(dialog.this,"Fierro!!!",Toast.LENGTH_SHORT).show();
            }
        });
        ventana.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(dialog.this,"Para eso me gustabas",Toast.LENGTH_SHORT).show();
            }
        });
        ventana.setNeutralButton("Si pero no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(dialog.this,"Si o no pariente",Toast.LENGTH_SHORT).show();
            }
        });
        ventana.show();
    }
    public void CustomDialogP(View v){
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setTitle("Nombre");
        ventana.setMessage("Escribe tu nombre");
        ventana.setCancelable(false);
        final EditText ET_Nombre = new EditText(this);
        ventana.setView(ET_Nombre);
        ventana.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String nombre = ET_Nombre.getText().toString().trim();
                if (nombre.length()!= 0){
                    Toast.makeText(dialog.this,"Tu Nombre" + nombre,Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(dialog.this,"Ingresa tu nombre",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ventana.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        ventana.show();
    }

}
