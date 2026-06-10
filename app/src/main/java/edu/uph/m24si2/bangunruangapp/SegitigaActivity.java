package edu.uph.m24si2.bangunruangapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegitigaActivity extends AppCompatActivity {
    private EditText edtAlas, edtTinggi;
    private Button btnHitung;
    private TextView txvLuas, txvKeliling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segitiga);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtAlas = findViewById(R.id.edtAlas);
        edtTinggi = findViewById(R.id.edtTinggi);
        btnHitung = findViewById(R.id.btnHitung);
        txvLuas = findViewById(R.id.txvLuas);
        txvKeliling = findViewById(R.id.txvKeliling);

        int alas = getIntent().getIntExtra("alas", 0);
        int tinggi = getIntent().getIntExtra("tinggi",0);
        edtAlas.setText(""+alas);
        edtTinggi.setText(""+tinggi);
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int alas, tinggi;
                Double luas,keliling;
                alas = Integer.parseInt(edtAlas.getText().toString());
                tinggi = Integer.parseInt(edtTinggi.getText().toString());
                luas = (double) ((alas*tinggi)/2);
                txvLuas.setText("Luas : "+luas);
                keliling = alas + 2* Math.sqrt(((alas/2)*(alas/2))+(tinggi*tinggi));
                txvKeliling.setText("Keliling : "+keliling);
            }
        });
    }
}