package br.com.nrbsistemas.agendacontatos.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import br.com.nrbsistemas.agendacontatos.entidades.ContatoMapping;

/**
 * Created by Everton on 22/01/2017.
 */

public class RepositorioContato {

    private SQLiteDatabase conn;

    public RepositorioContato(SQLiteDatabase conn){
        this.conn = conn;
    }

    public void inserirContato(ContatoMapping contatoMapping){

        ContentValues valor = new ContentValues();
        valor.put("nome",contatoMapping.getNome());
        valor.put("telefone",contatoMapping.getTelefone());
        valor.put("tipoTelefone",contatoMapping.getTipoTelefone());
        valor.put("email",contatoMapping.getEmail());
        valor.put("tipoEmail",contatoMapping.getTipoEmail());
        valor.put("endereco",contatoMapping.getTipoEndereco());
        valor.put("tipoEndereco",contatoMapping.getTipoEndereco());
        valor.put("dataEspeciais",contatoMapping.getDatasEspeciais().getTime());
        valor.put("tipoDatasEspeciais",contatoMapping.getTipoDataEspeciais());
        valor.put("grupos",contatoMapping.getGrupos());

        conn.insertOrThrow("CONTATO",null,valor);
    }

    public  void testInserirContatos(){
        //inserindo 10 registros para test
        for(int i=0; i<10; i++){
            ContentValues values = new ContentValues();
            values.put("telefone", "5555-5554");
            conn.insertOrThrow("CONTATO", null, values);
        }
    }

    public ArrayAdapter<ContatoMapping> bucarContatos(Context context){
        ArrayAdapter<ContatoMapping> adpContatos = new ArrayAdapter<ContatoMapping>(context, android.R.layout.simple_list_item_1);

        Cursor cursor =  conn.query("CONTATO",null,null,null,null,null,null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                ContatoMapping contatoMapping = new ContatoMapping();
                contatoMapping.setTelefone(cursor.getString(1));
                adpContatos.add(contatoMapping);

            }while (cursor.moveToNext());
        }

        return adpContatos;
    }
}
