package com.example.sistemas.appcalculonota;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed1, ed2, ed3 , ed4, ed5, ed6, ed7, ed8, ed9, ed10, ed11, ed12;
    private TextView tvdef1, tvdef2, tvdef3, tvdef4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //PRIMERA MATERIA
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        tvdef1 = (TextView) findViewById(R.id.tvdef1);

        //SEGUNDA MATERIA
        ed4 = (EditText) findViewById(R.id.ed4);
        ed5 = (EditText) findViewById(R.id.ed5);
        ed6 = (EditText) findViewById(R.id.ed6);
        tvdef2 = (TextView) findViewById(R.id.tvdef2);

        //TERCERA MATERIA
        ed7 = (EditText) findViewById(R.id.ed7);
        ed8 = (EditText) findViewById(R.id.ed8);
        ed9 = (EditText) findViewById(R.id.ed9);
        tvdef3 = (TextView) findViewById(R.id.tvdef3);

        //CUARTA MATERIA
        ed10 = (EditText) findViewById(R.id.ed10);
        ed11 = (EditText) findViewById(R.id.ed11);
        ed12 = (EditText) findViewById(R.id.ed12);
        tvdef4 = (TextView) findViewById(R.id.tvdef4);


        //PRIMERA MATERIA
        SharedPreferences prefe = getSharedPreferences("informacion", Context.MODE_PRIVATE);
        ed1.setText(prefe.getString("campo1", "0"));
        ed2.setText(prefe.getString("campo2", "0"));
        ed3.setText(prefe.getString("campo3", "0"));
        tvdef1.setText(prefe.getString("res1", tvdef1.getText().toString()));

        //SEGUNDA MATERIA

        ed4.setText(prefe.getString("campo4", "0"));
        ed5.setText(prefe.getString("campo5", "0"));
        ed6.setText(prefe.getString("campo6", "0"));
        tvdef2.setText(prefe.getString("res2", tvdef2.getText().toString()));


        //TERCERA MATERIA

        ed7.setText(prefe.getString("campo7", "0"));
        ed8.setText(prefe.getString("campo8", "0"));
        ed9.setText(prefe.getString("campo9", "0"));
        tvdef3.setText(prefe.getString("res3", tvdef3.getText().toString()));

        //CUARTA MATERIA

        ed10.setText(prefe.getString("campo10", "0"));
        ed11.setText(prefe.getString("campo11", "0"));
        ed12.setText(prefe.getString("campo12", "0"));
        tvdef4.setText(prefe.getString("res4", tvdef4.getText().toString()));


        //PRIMERA MATERIA

        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {

                    String campo1 = ed1.getText().toString();
                    String campo2 = ed2.getText().toString();
                    String campo3 = ed3.getText().toString();
                    double nro1 = Double.parseDouble(campo1);
                    double nro2 = Double.parseDouble(campo2);
                    double nro3 = Double.parseDouble(campo3);
                    if(nro1>5){
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.invalido), Toast.LENGTH_LONG);
                        notificacion.show();
                        ed1.setText("0");

                    }
                    else{
                        double operacion = ((nro1 * 0.3) + (nro2 * 0.3) + (nro3 * 0.4));
                        operacion= Math.rint(operacion*100)/100;
                        String resultado1 = String.valueOf(operacion);
                        tvdef1.setText(resultado1);

                    }



                    //INFORMACION PRIMERA NOTA
                    SharedPreferences prefere = getSharedPreferences("informacion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor trabajo = prefere.edit();

                    trabajo.putString("campo1", ed1.getText().toString());
                    trabajo.putString("campo2", ed2.getText().toString());
                    trabajo.putString("campo3", ed3.getText().toString());
                    trabajo.putString("res1", tvdef1.getText().toString());
                    trabajo.commit();

                } catch (Exception e)
                {
                    if (ed1.getText().toString().equals("") || ed2.getText().toString().equals("") || ed3.getText().toString().equals(""))
                    {
                        ed1.setText(" ");

                    }
                }
            }

        });

        ed2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {


                    String campo1 = ed1.getText().toString();
                    String campo2 = ed2.getText().toString();
                    String campo3 = ed3.getText().toString();
                    double nro1 = Double.parseDouble(campo1);
                    double nro2 = Double.parseDouble(campo2);
                    double nro3 = Double.parseDouble(campo3);
                    if(nro2>5){
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.invalido), Toast.LENGTH_LONG);
                        notificacion.show();
                        ed2.setText("0");

                    }
                    else{
                        double operacion = ((nro1 * 0.3) + (nro2 * 0.3) + (nro3 * 0.4));
                        operacion= Math.rint(operacion*100)/100;
                        String resultado1 = String.valueOf(operacion);
                        tvdef1.setText(resultado1);

                    }
                    //INFORMACION PRIMERA NOTA
                    SharedPreferences prefere = getSharedPreferences("informacion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor trabajo = prefere.edit();

                    trabajo.putString("campo1", ed1.getText().toString());
                    trabajo.putString("campo2", ed2.getText().toString());
                    trabajo.putString("campo3", ed3.getText().toString());
                    trabajo.putString("res1", tvdef1.getText().toString());
                    trabajo.commit();


                } catch (Exception e)
                {
                    if (ed1.getText().toString().equals("") || ed2.getText().toString().equals("") || ed3.getText().toString().equals(""))
                    {
                        ed2.setText(" ");
                    }
                }
            }

        });

        ed3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {

                    String campo1 = ed1.getText().toString();
                    String campo2 = ed2.getText().toString();
                    String campo3 = ed3.getText().toString();
                    double nro1 = Double.parseDouble(campo1);
                    double nro2 = Double.parseDouble(campo2);
                    double nro3 = Double.parseDouble(campo3);
                    if(nro3>5){
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.invalido), Toast.LENGTH_LONG);
                        notificacion.show();
                        ed3.setText("0");

                    }
                    else{
                        double operacion = ((nro1 * 0.3) + (nro2 * 0.3) + (nro3 * 0.4));
                        operacion= Math.rint(operacion*100)/100;
                        String resultado1 = String.valueOf(operacion);
                        tvdef1.setText(resultado1);

                    }


                    //INFORMACION PRIMERA NOTA
                    SharedPreferences prefere = getSharedPreferences("informacion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor trabajo = prefere.edit();

                    trabajo.putString("campo1", ed1.getText().toString());
                    trabajo.putString("campo2", ed2.getText().toString());
                    trabajo.putString("campo3", ed3.getText().toString());
                    trabajo.putString("res1", tvdef1.getText().toString());
                    trabajo.commit();
                } catch (Exception e)
                {
                    if (ed1.getText().toString().equals("") || ed2.getText().toString().equals("") || ed3.getText().toString().equals(""))
                    {
                        ed3.setText(" ");
                    }
                }
            }

        });

        //SEGUNDA MATERIA
        ed4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {

                    String campo4 = ed4.getText().toString();
                    String campo5 = ed5.getText().toString();
                    String campo6 = ed6.getText().toString();
                    double nro1 = Double.parseDouble(campo4);
                    double nro2 = Double.parseDouble(campo5);
                    double nro3 = Double.parseDouble(campo6);
                    if(nro1>5){
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.invalido), Toast.LENGTH_LONG);
                        notificacion.show();
                        ed4.setText("0");

                    }
                    else {
                        double operacion = ((nro1 * 0.3) + (nro2 * 0.3) + (nro3 * 0.4));
                        operacion = Math.rint(operacion * 100) / 100;
                        String resultado2 = String.valueOf(operacion);
                        tvdef2.setText(resultado2);
                    }


                    //INFORMACION SEGUNDA NOTA
                    SharedPreferences prefere = getSharedPreferences("informacion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor trabajo = prefere.edit();

                    trabajo.putString("campo4", ed4.getText().toString());
                    trabajo.putString("campo5", ed5.getText().toString());
                    trabajo.putString("campo6", ed6.getText().toString());
                    trabajo.putString("res2", tvdef2.getText().toString());
                    trabajo.commit();

                } catch (Exception e)
                {
                    if (ed4.getText().toString().equals("") || ed5.getText().toString().equals("") || ed6.getText().toString().equals(""))
                    {
                        ed4.setText(" ");;
                    }

                }
            }

        });

        ed5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {

                    String campo4 = ed4.getText().toString();
                    String campo5 = ed5.getText().toString();
                    String campo6 = ed6.getText().toString();
                    double nro1 = Double.parseDouble(campo4);
                    double nro2 = Double.parseDouble(campo5);
                    double nro3 = Double.parseDouble(campo6);
                    if(nro2>5){
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.invalido), Toast.LENGTH_LONG);
                        notificacion.show();
                        ed5.setText("0");

                    }
                    else {
                        double operacion = ((nro1 * 0.3) + (nro2 * 0.3) + (nro3 * 0.4));
                        operacion = Math.rint(operacion * 100) / 100;
                        String resultado2 = String.valueOf(operacion);
                        tvdef2.setText(resultado2);
                    }

                    //INFORMACION SEGUNDA NOTA
                    SharedPreferences prefere = getSharedPreferences("informacion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor trabajo = prefere.edit();

                    trabajo.putString("campo4", ed4.getText().toString());
                    trabajo.putString("campo5", ed5.getText().toString());
                    trabajo.putString("campo6", ed6.getText().toString());
                    trabajo.putString("res2", tvdef2.getText().toString());
                    trabajo.commit();
                } catch (Exception e)
                {
                    if (ed4.getText().toString().equals("") || ed5.getText().toString().equals("") || ed6.getText().toString().equals(""))
                    {
                        ed5.setText(" ");
                    }

                }
            }

        });

        ed6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {

                    String campo4 = ed4.getText().toString();
                    String campo5 = ed5.getText().toString();
                    String campo6 = ed6.getText().toString();
                    double nro1 = Double.parseDouble(campo4);
                    double nro2 = Double.parseDouble(campo5);
                    double nro3 = Double.parseDouble(campo6);
                    if(nro3>5){
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.invalido), Toast.LENGTH_LONG);
                        notificacion.show();
                        ed6.setText("0");

                    }
                    else {
                        double operacion = ((nro1 * 0.3) + (nro2 * 0.3) + (nro3 * 0.4));
                        operacion = Math.rint(operacion * 100) / 100;
                        String resultado2 = String.valueOf(operacion);
                        tvdef2.setText(resultado2);
                    }

                    //INFORMACION SEGUNDA NOTA
                    SharedPreferences prefere = getSharedPreferences("informacion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor trabajo = prefere.edit();

                    trabajo.putString("campo4", ed4.getText().toString());
                    trabajo.putString("campo5", ed5.getText().toString());
                    trabajo.putString("campo6", ed6.getText().toString());
                    trabajo.putString("res2", tvdef2.getText().toString());
                    trabajo.commit();
                } catch (Exception e)
                {
                    if (ed4.getText().toString().equals("") || ed5.getText().toString().equals("") || ed6.getText().toString().equals(""))
                    {
                        ed6.setText(" ");
                    }

                }
            }

        });


        //TERCERA MATERIA

        ed7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {

                    String campo7 = ed7.getText().toString();
                    String campo8 = ed8.getText().toString();
                    String campo9 = ed9.getText().toString();
                    double nro1 = Double.parseDouble(campo7);
                    double nro2 = Double.parseDouble(campo8);
                    double nro3 = Double.parseDouble(campo9);
                    if(nro1>5){
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.invalido), Toast.LENGTH_LONG);
                        notificacion.show();
                        ed7.setText("0");

                    }
                    else {
                        double operacion = ((nro1 * 0.3) + (nro2 * 0.3) + (nro3 * 0.4));
                        operacion = Math.rint(operacion * 100) / 100;
                        String resultado3 = String.valueOf(operacion);
                        tvdef3.setText(resultado3);
                    }

                    //INFORMACION TERCERA NOTA
                    SharedPreferences prefere = getSharedPreferences("informacion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor trabajo = prefere.edit();

                    trabajo.putString("campo7", ed7.getText().toString());
                    trabajo.putString("campo8", ed8.getText().toString());
                    trabajo.putString("campo9", ed9.getText().toString());
                    trabajo.putString("res3", tvdef3.getText().toString());
                    trabajo.commit();

                } catch (Exception e)
                {
                    if (ed7.getText().toString().equals("") || ed8.getText().toString().equals("") || ed9.getText().toString().equals(""))
                    {
                        ed7.setText(" ");
                    }

                }
            }

        });

        ed8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {

                    String campo7 = ed7.getText().toString();
                    String campo8 = ed8.getText().toString();
                    String campo9 = ed9.getText().toString();
                    double nro1 = Double.parseDouble(campo7);
                    double nro2 = Double.parseDouble(campo8);
                    double nro3 = Double.parseDouble(campo9);
                    if(nro2>5){
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.invalido), Toast.LENGTH_LONG);
                        notificacion.show();
                        ed8.setText("0");

                    }
                    else {
                        double operacion = ((nro1 * 0.3) + (nro2 * 0.3) + (nro3 * 0.4));
                        operacion = Math.rint(operacion * 100) / 100;
                        String resultado3 = String.valueOf(operacion);
                        tvdef3.setText(resultado3);
                    }
                    //INFORMACION TERCERA NOTA
                    SharedPreferences prefere = getSharedPreferences("informacion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor trabajo = prefere.edit();

                    trabajo.putString("campo7", ed7.getText().toString());
                    trabajo.putString("campo8", ed8.getText().toString());
                    trabajo.putString("campo9", ed9.getText().toString());
                    trabajo.putString("res3", tvdef3.getText().toString());
                    trabajo.commit();
                } catch (Exception e)
                {
                    if (ed7.getText().toString().equals("") || ed8.getText().toString().equals("") || ed9.getText().toString().equals(""))
                    {
                        ed8.setText(" ");
                    }

                }
            }

        });

        ed9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {

                    String campo7 = ed7.getText().toString();
                    String campo8 = ed8.getText().toString();
                    String campo9 = ed9.getText().toString();
                    double nro1 = Double.parseDouble(campo7);
                    double nro2 = Double.parseDouble(campo8);
                    double nro3 = Double.parseDouble(campo9);
                    if(nro3>5){
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.invalido), Toast.LENGTH_LONG);
                        notificacion.show();
                        ed9.setText("0");

                    }
                    else {
                        double operacion = ((nro1 * 0.3) + (nro2 * 0.3) + (nro3 * 0.4));
                        operacion = Math.rint(operacion * 100) / 100;
                        String resultado3 = String.valueOf(operacion);
                        tvdef3.setText(resultado3);
                    }

                    //INFORMACION TERCERA NOTA
                    SharedPreferences prefere = getSharedPreferences("informacion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor trabajo = prefere.edit();

                    trabajo.putString("campo7", ed7.getText().toString());
                    trabajo.putString("campo8", ed8.getText().toString());
                    trabajo.putString("campo9", ed9.getText().toString());
                    trabajo.putString("res3", tvdef3.getText().toString());
                    trabajo.commit();
                } catch (Exception e)
                {
                    if (ed7.getText().toString().equals("") || ed8.getText().toString().equals("") || ed9.getText().toString().equals(""))
                    {
                        ed9.setText(" ");
                    }

                }
            }

        });

        //CUARTA MATERIA

        ed10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {

                    String campo10 = ed10.getText().toString();
                    String campo11 = ed11.getText().toString();
                    String campo12 = ed12.getText().toString();
                    double nro1 = Double.parseDouble(campo10);
                    double nro2 = Double.parseDouble(campo11);
                    double nro3 = Double.parseDouble(campo12);
                    if(nro1>5){
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.invalido), Toast.LENGTH_LONG);
                        notificacion.show();
                        ed10.setText("0");

                    }else {
                        double operacion = ((nro1 * 0.3) + (nro2 * 0.3) + (nro3 * 0.4));
                        operacion = Math.rint(operacion * 100) / 100;
                        String resultado4 = String.valueOf(operacion);
                        tvdef4.setText(resultado4);
                    }

                    //INFORMACION CUARTA NOTA
                    SharedPreferences prefere = getSharedPreferences("informacion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor trabajo = prefere.edit();

                    trabajo.putString("campo10", ed10.getText().toString());
                    trabajo.putString("campo11", ed11.getText().toString());
                    trabajo.putString("campo12", ed12.getText().toString());
                    trabajo.putString("res4", tvdef4.getText().toString());

                    trabajo.commit();

                } catch (Exception e)
                {
                    if (ed10.getText().toString().equals("") || ed11.getText().toString().equals("") || ed12.getText().toString().equals(""))
                    {
                        ed10.setText(" ");
                    }

                }
            }

        });

        ed11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {

                    String campo10 = ed10.getText().toString();
                    String campo11 = ed11.getText().toString();
                    String campo12 = ed12.getText().toString();
                    double nro1 = Double.parseDouble(campo10);
                    double nro2 = Double.parseDouble(campo11);
                    double nro3 = Double.parseDouble(campo12);
                    if(nro2>5){
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.invalido), Toast.LENGTH_LONG);
                        notificacion.show();
                        ed11.setText("0");

                    }else {
                        double operacion = ((nro1 * 0.3) + (nro2 * 0.3) + (nro3 * 0.4));
                        operacion = Math.rint(operacion * 100) / 100;
                        String resultado4 = String.valueOf(operacion);
                        tvdef4.setText(resultado4);
                    }
                    //INFORMACION CUARTA NOTA
                    SharedPreferences prefere = getSharedPreferences("informacion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor trabajo = prefere.edit();

                    trabajo.putString("campo10", ed10.getText().toString());
                    trabajo.putString("campo11", ed11.getText().toString());
                    trabajo.putString("campo12", ed12.getText().toString());
                    trabajo.putString("res4", tvdef4.getText().toString());

                    trabajo.commit();
                } catch (Exception e)
                {
                    if (ed10.getText().toString().equals("") || ed11.getText().toString().equals("") || ed12.getText().toString().equals(""))
                    {
                        ed11.setText(" ");
                    }

                }
            }

        });

        ed12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {

                    String campo10 = ed10.getText().toString();
                    String campo11 = ed11.getText().toString();
                    String campo12 = ed12.getText().toString();
                    double nro1 = Double.parseDouble(campo10);
                    double nro2 = Double.parseDouble(campo11);
                    double nro3 = Double.parseDouble(campo12);
                    if(nro3>5){
                        Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.invalido), Toast.LENGTH_LONG);
                        notificacion.show();
                        ed12.setText("0");

                    }else {
                        double operacion = ((nro1 * 0.3) + (nro2 * 0.3) + (nro3 * 0.4));
                        operacion = Math.rint(operacion * 100) / 100;
                        String resultado4 = String.valueOf(operacion);
                        tvdef4.setText(resultado4);
                    }

                    //INFORMACION CUARTA NOTA
                    SharedPreferences prefere = getSharedPreferences("informacion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor trabajo = prefere.edit();

                    trabajo.putString("campo10", ed10.getText().toString());
                    trabajo.putString("campo11", ed11.getText().toString());
                    trabajo.putString("campo12", ed12.getText().toString());
                    trabajo.putString("res4", tvdef4.getText().toString());

                    trabajo.commit();
                } catch (Exception e)
                {
                    if (ed10.getText().toString().equals("") || ed11.getText().toString().equals("") || ed12.getText().toString().equals(""))
                    {
                        ed12.setText(" ");
                    }

                }
            }

        });
    }






    //METODO PARA CALCULAR NOTA FINAL SEMESTRE
    public void total(View view) {
        try {
            String resultado1 = tvdef1.getText().toString();
            String resultado2 = tvdef2.getText().toString();
            String resultado3 = tvdef3.getText().toString();
            String resultado4 = tvdef4.getText().toString();
            double nro1 = Double.parseDouble(resultado1);
            double nro2 = Double.parseDouble(resultado2);
            double nro3 = Double.parseDouble(resultado3);
            double nro4 = Double.parseDouble(resultado4);
            double operacionfinal = ((nro1+ nro2+ nro3+ nro4) / 4);
            operacionfinal= Math.rint(operacionfinal*100)/100;
            Toast notificacion = Toast.makeText(this,getResources().getString(R.string.notafinal)+" "+ operacionfinal , Toast.LENGTH_LONG);
            notificacion.show();

        }catch (Exception e){
            if (tvdef1.getText().toString().equals("#.##") || tvdef2.getText().toString().equals("#.##") || tvdef3.getText().toString().equals("#.##") || tvdef4.getText().toString().equals("#.##"))
            {
                Toast notificacion = Toast.makeText(MainActivity.this,getResources().getString(R.string.advertencia2), Toast.LENGTH_LONG);
                notificacion.show();
            }
        }



    }
    //Metodo Acerca de
    public void acercade(View view) {
        Intent i = new Intent(this, AcercaDe.class );
        startActivity(i);
    }
}
