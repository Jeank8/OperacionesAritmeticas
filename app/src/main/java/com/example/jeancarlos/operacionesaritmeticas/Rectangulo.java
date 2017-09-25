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

public class Rectangulo extends AppCompatActivity {

    private TextView total;
    private EditText base, altura;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        total = (TextView)findViewById(R.id.lblTotal);
        base = (EditText)findViewById(R.id.txtBasRec);
        altura = (EditText)findViewById(R.id.txtAltRec);
        res = this.getResources();
    }

    public void guardar(View v) {
        String opera, dato, result;
        if (validar()) {
            int baseFinal = Integer.parseInt(base.getText().toString());
            int alturaFinal = Integer.parseInt(altura.getText().toString());
            opera = res.getString(R.string.operacion2);
            String str1 = res.getString(R.string.base) + "\n " + baseFinal;
            String str2 = res.getString(R.string.altura) + "\n " + alturaFinal;
            dato = str1 + "\n " + str2;

            int area = baseFinal * alturaFinal;
            result = Integer.toString(area);

            total.setText(result+"");

            Operaciones o = new Operaciones(opera, dato, result);
            o.guardar();
            borrar(v);
        }
    }

    public void borrar(View v){
        base.setText("");
        altura.setText("");
        base.requestFocus();
    }

    public boolean validar() {
        if (base.getText().toString().isEmpty()) {
            base.setError(getResources().getString(R.string.error));
            return false;
        }
        if (altura.getText().toString().isEmpty()) {
            altura.setError(getResources().getString(R.string.error));
            return false;
        }
        if((Integer.parseInt(base.getText().toString())==0)){
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
