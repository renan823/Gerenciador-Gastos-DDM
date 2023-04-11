package com.example.gerenciadorgastos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView lblGasto;
    private TextView lblValor;

    private EditText editTextGasto;
    private EditText editTextValor;

    private Button btnTotal;
    private Button btnLista;
    private Button btnAdiciona;

    private ArrayList<String> gastos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblGasto = findViewById(R.id.lblGasto);
        lblValor = findViewById(R.id.lblValor);

        editTextGasto = findViewById(R.id.editTextGasto);
        editTextValor = findViewById(R.id.editTextValor);

        btnAdiciona = findViewById(R.id.btnAdicionar);
        btnAdiciona.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String gasto = editTextGasto.getText() + " -- " + editTextValor.getText();
                gastos.add(gasto);

                Toast.makeText(getApplicationContext(), "Adicionado", Toast.LENGTH_SHORT).show();
            }
        });

        btnLista = findViewById(R.id.btnListar);
        btnLista.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                for(int i = 0; i < gastos.size(); i++){
                    Toast.makeText(getApplicationContext(), gastos.get(i), Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnTotal = findViewById(R.id.btnTotal);
        btnTotal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double total = 0;

                for(int i = 0; i < gastos.size(); i++){
                    String gasto = gastos.get(i);
                    String[] resultado = gasto.split("--");

                    Double valor = Double.parseDouble(resultado[1]);
                    total += valor;
                }

                Toast.makeText(getApplicationContext(), Double.toString(total), Toast.LENGTH_SHORT).show();
            }
        });

    }
}