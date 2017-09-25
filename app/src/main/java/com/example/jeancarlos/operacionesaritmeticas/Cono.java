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

public class Cono extends AppCompatActivity {

    private TextView total;
    private EditText radio, altura;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);

        total = (TextView)findViewById(R.id.lblTotal);
        radio = (EditText) findViewById(R.id.txtRadCon);
        altura = (EditText) findViewById(R.id.txtAltCon);
        res = this.getResources();
    }

    public void guardar(View v) {
        String opera, dato, result;
        if (validar()) {
            int radioFinal = Integer.parseInt(radio.getText().toString());
            int alturaFinal = Integer.parseInt(altura.getText().toString());
            opera = res.getString(R.string.operacion7);
            String str = res.getString(R.string.radio);
            String str2 = res.getString(R.string.altura);
            dato = str + "\n " + radioFinal + "\n" + str2 + "\n " + alturaFinal;

            double volumen = (Math.PI * radioFinal * radioFinal * alturaFinal) / 3;
            volumen = (double) ((int) (volumen * 100.0) / 100.0);
            result = Double.toString(volumen);

            total.setText(result+"");

            Operaciones o = new Operaciones(opera, dato, result);
            o.guardar();
            borrar(v);
        }
    }

    public void borrar(View v) {
        radio.setText("");
        altura.setText("");
        radio.requestFocus();
    }

    public boolean validar() {
        if (radio.getText().toString().isEmpty()) {
            radio.setError(getResources().getString(R.string.error));
            return false;
        }
        if (altura.getText().toString().isEmpty()) {
            altura.setError(getResources().getString(R.string.error));
            return false;
        }
        if((Integer.parseInt(radio.getText().toString())==0)){
            Toast.makeText(this, res.getString(R.string.error_cero), Toast.LENGTH_SHORT).show();
            return false;
        }
        if((Integer.parseInt(altura.getText().toString())==0)){
            Toast.makeText(this, res.getString(R.string.error_cero), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
