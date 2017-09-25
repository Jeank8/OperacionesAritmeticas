package com.example.jeancarlos.operacionesaritmeticas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cubo extends AppCompatActivity {

    private TextView total;
    private EditText arista;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        total = (TextView)findViewById(R.id.lblTotal);
        arista = (EditText)findViewById(R.id.txtCuboLad);
        res = this.getResources();
    }

    public void guardar(View v) {
        String opera, dato, result;
        if (validar()) {
            int aristaFinal = Integer.parseInt(arista.getText().toString());
            opera = res.getString(R.string.operacion8);
            String str = res.getString(R.string.valorLados);
            dato = str + "\n " + aristaFinal;

            double volumen = (aristaFinal * aristaFinal * aristaFinal);
            volumen = (double) ((int) (volumen * 100.0) / 100.0);
            result = Double.toString(volumen);

            total.setText(result+"");

            Operaciones o = new Operaciones(opera, dato, result);
            o.guardar();
            borrar(v);
        }
    }

    public void borrar(View v){
        arista.setText("");
        arista.requestFocus();
    }

    public boolean validar() {
        if (arista.getText().toString().isEmpty()) {
            arista.setError(getResources().getString(R.string.error));
            return false;
        }
        if((Integer.parseInt(arista.getText().toString())==0)){
            Toast.makeText(this, res.getString(R.string.error_cero), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}

