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

public class Cuadrado extends AppCompatActivity {

    private TextView total;
    private EditText lado;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);

        total = (TextView)findViewById(R.id.lblTotal);
        lado = (EditText)findViewById(R.id.txtLadCuad);
        res = this.getResources();

    }
    public void guardar(View v) {
        String opera, dato, result;
        if (validar()) {
            int ladoFinal = Integer.parseInt(lado.getText().toString());
            opera = res.getString(R.string.operacion1);
            String str = res.getString(R.string.valorLados);
            dato = str + "\n " + ladoFinal;

            int area = ladoFinal * ladoFinal;
            result = Integer.toString(area);

            total.setText(result+"");

            Operaciones o = new Operaciones(opera, dato, result);
            o.guardar();
            borrar(v);
        }
    }

    public void borrar(View v) {
        lado.setText("");
        lado.requestFocus();
    }

    public boolean validar() {
        if (lado.getText().toString().isEmpty()) {
            lado.setError(getResources().getString(R.string.error));
            return false;
        }
        if((Integer.parseInt(lado.getText().toString())==0)){
            Toast.makeText(this, res.getString(R.string.error_cero), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}

