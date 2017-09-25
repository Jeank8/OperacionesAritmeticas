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

public class Circulo extends AppCompatActivity {

    private TextView total;
    private EditText radio;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        total = (TextView)findViewById(R.id.lblTotal);
        radio = (EditText)findViewById(R.id.txtRadCir);
        res = this.getResources();
    }

    public void guardar(View v) {
        String opera, dato, result;
        if (validar()) {
            int radioFinal = Integer.parseInt(radio.getText().toString());
            opera = res.getString(R.string.operacion4);
            String str = res.getString(R.string.radio);
            dato = str + "\n " + radioFinal;

            double area = Math.PI * radioFinal * radioFinal;
            area = (double) ((int) (area * 100.0) / 100.0);
            result = Double.toString(area);

            total.setText(result+"");

            Operaciones o = new Operaciones(opera, dato, result);
            o.guardar();
            borrar(v);
        }
    }

    public void borrar(View v){
        radio.setText("");
        radio.requestFocus();
    }

    public boolean validar() {
        if (radio.getText().toString().isEmpty()) {
            radio.setError(getResources().getString(R.string.error));
            return false;
        }
        if((Integer.parseInt(radio.getText().toString())==0)){
            Toast.makeText(this, res.getString(R.string.error_cero), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}