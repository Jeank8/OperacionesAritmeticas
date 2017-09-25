package com.example.jeancarlos.operacionesaritmeticas;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Areas extends AppCompatActivity {

    private ListView ls;
    private Resources res;
    private String[] opc;
    private Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

        ls = (ListView)findViewById(R.id.lstAreas);
        res = this.getResources();
        opc = res.getStringArray(R.array.lstAreas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);
        ls.setAdapter(adapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        in = new Intent(Areas.this, Cuadrado.class);
                        startActivity(in);
                        break;
                    case 1:
                        in = new Intent(Areas.this, Rectangulo.class);
                        startActivity(in);
                        break;
                    case 2:
                        in = new Intent(Areas.this, Triangulo.class);
                        startActivity(in);
                        break;
                    case 3:
                        in = new Intent(Areas.this, Circulo.class);
                        startActivity(in);
                        break;
                }
            }
        });
    }
}