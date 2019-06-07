package com.example.a3ainfo.mysql_livrob;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a3ainfo.mysql_livrob.R;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome, editTextAutor, editTextGenero;
    Button buttonConfInclusao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAutor = (EditText)findViewById(R.id.editTextAutor);
        editTextNome = (EditText)findViewById(R.id.editTextNome);
        editTextGenero = (EditText)findViewById(R.id.editTextGenero);
        buttonConfInclusao = (Button)findViewById(R.id.buttonConfInclusao);

        buttonConfInclusao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DtoLIvro dtoLIvro = new DtoLIvro();
                dtoLIvro.nome = editTextNome.getText().toString();
                dtoLIvro.autor = editTextAutor.getText().toString();
                dtoLIvro.genero = editTextGenero.getText().toString();

                DaoLivro daoLivro = new DaoLivro();
                String msg = daoLivro.inserir(dtoLIvro);


                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setMessage(msg).show();



//                FabricaConexao fabricaConexao = new FabricaConexao();
//                Connection conn = fabricaConexao.conectar();
//                if(conn == null){
//                    Toast.makeText(MainActivity.this, "Deu xabu", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(MainActivity.this, "Oçá", Toast.LENGTH_SHORT).show();
//                }


            }
        });

    }
}
