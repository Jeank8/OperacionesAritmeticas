package com.example.jeancarlos.operacionesaritmeticas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity {

    private TableLayout table;
    private ArrayList<Operaciones> operacionArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        table = (TableLayout)findViewById(R.id.tblDatos);
        operacionArrayList = Datos.getOperaciones();
        for (int i = 0; i < operacionArrayList.size() ; i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(operacionArrayList.get(i).getOperacion());
            c3.setText(operacionArrayList.get(i).getDatos());
            c4.setText(operacionArrayList.get(i).getResultado());

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);

            table.addView(fila);
        }
    }
}
