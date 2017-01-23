package br.com.nrbsistemas.agendacontatos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.database.sqlite.*;
import android.database.*;

import br.com.nrbsistemas.agendacontatos.database.DataBase;
import br.com.nrbsistemas.agendacontatos.dominio.RepositorioContato;
import br.com.nrbsistemas.agendacontatos.entidades.ContatoMapping;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btn_add;
    private EditText edt_pesquisa;
    private ListView list_contatos;

    private DataBase dataBase;
    private  SQLiteDatabase conn;
    private ArrayAdapter<ContatoMapping> adpContatos;
    private RepositorioContato repositorioContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = (ImageButton)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        edt_pesquisa = (EditText)findViewById(R.id.edt_pesquisa);
        list_contatos = (ListView)findViewById(R.id.list_contatos);

        //instanciando a conecao
        try {
            dataBase = new DataBase(this);
            //aletraro a chamada do metodo para modo escrita
            conn = dataBase.getWritableDatabase();
            //conn = dataBase.getReadableDatabase();
            //criando uma instancia de repositorio contato para testar o metodo de inserir
            repositorioContato = new RepositorioContato(conn);

            //repositorioContato.testInserirContatos();

            adpContatos = repositorioContato.bucarContatos(this);
            //passando o adaptador de contatos para carregar na list view
            list_contatos.setAdapter(adpContatos);

            //AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            //dialogo.setMessage("Conectado com sucesso");
            //dialogo.setNeutralButton("Ok ;-)",null);
            //dialogo.show();
        }catch (SQLException erro){
            Toast.makeText(this,"Erro ao conectar "+erro.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        if(v == btn_add){
            Intent intent = new Intent(this, Contatos.class);
            Toast.makeText(this,"Redirecionando",Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_acao1:
                AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
                dialogo.setMessage("Opção selecionada");
                dialogo.setIcon(R.mipmap.ic_launcher);
                dialogo.setNeutralButton("Ok .|.",null);
                dialogo.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
