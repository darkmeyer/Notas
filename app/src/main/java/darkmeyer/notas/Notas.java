package darkmeyer.notas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Notas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        Button b = (Button) findViewById(R.id.btnLimpiar);
        Button a = (Button) findViewById(R.id.btnCalcular);
        Button s = (Button) findViewById(R.id.btnSalir);
        final EditText txtNota1 = (EditText) findViewById(R.id.txtNota1);
        final EditText txtNota2 = (EditText) findViewById(R.id.txtNota2);
        final EditText txtNota3 = (EditText) findViewById(R.id.txtNota3);
        final EditText txtNota4 = (EditText) findViewById(R.id.txtNota4);
        final EditText txtPorc1 = (EditText) findViewById(R.id.txtPorc1);
        final EditText txtPorc2 = (EditText) findViewById(R.id.txtPorc2);
        final EditText txtPorc3 = (EditText) findViewById(R.id.txtPorc3);
        final EditText txtPorc4 = (EditText) findViewById(R.id.txtPorc4);
        final TextView txvResultado = (TextView) findViewById(R.id.txvResultado);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float n1, n2, n3, n4;
                int p1, p2, p3, p4;
                n1 = Float.parseFloat(txtNota1.getText().toString());
                n2 = Float.parseFloat(txtNota2.getText().toString());
                n3 = Float.parseFloat(txtNota3.getText().toString());
                n4 = Float.parseFloat(txtNota4.getText().toString());
                p1 = Integer.parseInt(txtPorc1.getText().toString());
                p2 = Integer.parseInt(txtPorc2.getText().toString());
                p3 = Integer.parseInt(txtPorc3.getText().toString());
                p4 = Integer.parseInt(txtPorc4.getText().toString());

                boolean salida = true;
                if (TextUtils.isEmpty(txtNota1.getText().toString()))
                    salida = false;
                else if (TextUtils.isEmpty(txtNota2.getText().toString()))
                    salida = false;
                else if (TextUtils.isEmpty(txtNota3.getText().toString()))
                    salida = false;
                else if (TextUtils.isEmpty(txtNota4.getText().toString()))
                    salida = false;
                else if (TextUtils.isEmpty(txtPorc1.getText().toString()))
                    salida = false;
                else if (TextUtils.isEmpty(txtPorc2.getText().toString()))
                    salida = false;
                else if (TextUtils.isEmpty(txtPorc3.getText().toString()))
                    salida = false;
                else if (TextUtils.isEmpty(txtPorc4.getText().toString()))
                    salida = false;
                if (salida == false) {
                    final AlertDialog.Builder myAlert = new AlertDialog.Builder(Notas.this);
                    myAlert.setTitle("Error");
                    myAlert.setMessage("Se Deben llenar todos los campos");
                    myAlert.show();
                } else {
                    if ((n1 < 1 || n1 > 7) || (n2 < 1 || n2 > 7) || (n3 < 1 || n3 > 7) || (n4 < 1 || n4 > 7)) {
                        final AlertDialog.Builder myAlert = new AlertDialog.Builder(Notas.this);
                        myAlert.setTitle("Error");
                        myAlert.setMessage("Las notas Deben ser entre 1 y 7.");
                        myAlert.show();
                    } else {
                        if ((p1 + p2 + p3 != 100) || (p4 < 1 || p4 > 100)) {
                            final AlertDialog.Builder myAlert = new AlertDialog.Builder(Notas.this);
                            myAlert.setTitle("Error");
                            myAlert.setMessage("Los porcentajes de notas deben sumar 100 y el procentaje examen debe estar entre el rango 1 y 100.");
                            myAlert.show();
                        } else {
                            float prom = ((((n1 * p1 / 100) + (n2 * p2 / 100) + (n3 * p3 / 100)) * (100 - p4)) / 100) + (n4 * p4 / 100);
                            if (prom > 4)
                                txvResultado.setTextColor(0xFF0037FF);
                            else
                                txvResultado.setTextColor(0xFFFF0000);
                            txvResultado.setText("" + prom);
                        }
                    }
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                txtNota1.setText("");
                txtNota2.setText("");
                txtNota3.setText("");
                txtNota4.setText("");
                txtPorc1.setText("");
                txtPorc2.setText("");
                txtPorc3.setText("");
                txtPorc4.setText("");
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                System.exit(0);
            }
        });
        findViewById(R.id.btnCreditos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Notas.this, Credito.class));
            }
        });
    }
}
