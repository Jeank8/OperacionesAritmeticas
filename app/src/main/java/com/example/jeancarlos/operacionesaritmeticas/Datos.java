package com.example.jeancarlos.operacionesaritmeticas;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class Datos extends AppCompatActivity {

    private static ArrayList<Operaciones> op = new ArrayList();

    public static void guardar(Operaciones p){
        op.add(p);
    }

    public static ArrayList<Operaciones> getOperaciones(){
        return op;
    }
}

