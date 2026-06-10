package edu.uph.m24si2.bangunruangapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnSegitiga, btnPersegi, btnLingkaran, btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnSegitiga = findViewById(R.id.btnSegitiga);
        btnPersegi = findViewById(R.id.btnPersegi);
        btnLingkaran = findViewById(R.id.btnLingkaran);
        btnKeluar = findViewById(R.id.btnKeluar);
        btnSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),
                        SegitigaActivity.class);
                intent.putExtra("Alas", 10);
                intent.putExtra("Tinggi", 5);
                startActivity(intent);
            }
        });
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //apakah anda yakin?
                AlertDialog.Builder alert =
                        new AlertDialog.Builder(v.getContext());
                alert.setMessage(R.string.konfirmasiBody)
                        .setTitle(R.string.konfirmasiTitle);
                alert.setNegativeButton("Tidak",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alert.setPositiveButton("Ya",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String pesan = "Terima Kasih,Sampai Jumpa";
                                int durasi = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(v.getContext(),pesan,durasi);
                                toast.show();
                                finish();
                            }
                        });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });
    }
}