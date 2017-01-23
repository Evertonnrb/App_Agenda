package br.com.nrbsistemas.agendacontatos;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import br.com.nrbsistemas.agendacontatos.database.DataBase;
import br.com.nrbsistemas.agendacontatos.dominio.RepositorioContato;
import br.com.nrbsistemas.agendacontatos.entidades.ContatoMapping;
import java.util.*;



public class Contatos extends ActionBarActivity{

    private EditText edt_nome;
    private EditText edt_telefone;
    private EditText edt_email;
    private EditText edt_endereco;
    private EditText edt_datas;
    private EditText edt_grupos;

    private Spinner spn_tipo;
    private Spinner spn_email;
    private Spinner spn_endereco;
    private Spinner spn_datas;

    private ArrayAdapter<String> adp_tipoEmail;
    private ArrayAdapter<String> adp_tipoTelefone;
    private ArrayAdapter<String> adp_tipoEndereco;
    private ArrayAdapter<String> adp_datasEspeciais;
    //classe repositorio contatos
    private ArrayAdapter<String> adpContato;

    private DataBase dataBase;
    private SQLiteDatabase conn;
    private RepositorioContato repositorioContato;
    private ContatoMapping contatoMapping;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);

        edt_nome = (EditText)findViewById(R.id.edt_nome);
        edt_email = (EditText)findViewById(R.id.edt_email);
        edt_endereco = (EditText)findViewById(R.id.edt_endereco);
        edt_datas = (EditText)findViewById(R.id.edt_datas);
        edt_grupos = (EditText)findViewById(R.id.edt_grupos);
        edt_telefone = (EditText)findViewById(R.id.edt_telefone);

        spn_tipo = (Spinner)findViewById(R.id.spn_tipo);
        spn_email = (Spinner)findViewById(R.id.spn_email);
        spn_endereco = (Spinner)findViewById(R.id.spn_endereco);
        spn_datas = (Spinner)findViewById(R.id.spn_datas);

        //adpContato = (ArrayAdapter<String>) findViewById(R.id.)

        adp_tipoEmail = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        adp_tipoEmail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adp_tipoTelefone = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adp_tipoTelefone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adp_tipoEndereco = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adp_tipoEndereco.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adp_datasEspeciais = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adp_datasEspeciais.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spn_email.setAdapter(adp_tipoEmail);
        spn_endereco.setAdapter(adp_tipoEndereco);
        spn_tipo.setAdapter(adp_tipoTelefone);
        spn_datas.setAdapter(adp_datasEspeciais);

        adp_tipoTelefone.add("Casa");
        adp_tipoTelefone.add("Trabalho");
        adp_tipoTelefone.add("Celular");
        adp_tipoTelefone.add("Outros");

        adp_tipoEmail.add("Comercial");
        adp_tipoEmail.add("Pessoal");
        adp_tipoEmail.add("Trabalho");

        adp_tipoEndereco.add("Trabalho");
        adp_tipoEndereco.add("Residencial");
        adp_tipoEndereco.add("Outros");

        adp_datasEspeciais.add("Aniversário");
        adp_datasEspeciais.add("Datas comemorativa");
        adp_datasEspeciais.add("Outros");

        try {
            dataBase = new DataBase(this);
            conn = dataBase.getWritableDatabase();
            repositorioContato = new RepositorioContato(conn);

        }catch (SQLException ex){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setMessage("Erro ao conectar "+ex);
            alerta.setNeutralButton("Ok",null);
            alerta.show();
        }
    }
    //invocando o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Instancia o menu ao layout
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //mostrando os itens de menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_acao1:
                if(contatoMapping == null){
                    inserir();
                    Toast.makeText(this,"Contato salvo com sucesso",Toast.LENGTH_SHORT).show();
                }else {
                    //alterar
                }
                finish();
                break;
            case R.id.menu_acao2:
                Toast.makeText(this,"Menu 2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_acao3:
                Toast.makeText(this,"Menu 3",Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
    private void inserir(){
        try {
            contatoMapping = new ContatoMapping();
            contatoMapping.setNome(edt_nome.getText().toString());
            contatoMapping.setTelefone(edt_telefone.getText().toString());
            contatoMapping.setEmail(edt_email.getText().toString());
            contatoMapping.setEndereco(edt_endereco.getText().toString());
            Date data = new Date();
            contatoMapping.setDatasEspeciais(data);
            contatoMapping.setGrupos(edt_grupos.getText().toString());
        }
        catch (Exception error){
            Toast.makeText(this,"Erro "+error,Toast.LENGTH_SHORT).show();
        }
    }
}
