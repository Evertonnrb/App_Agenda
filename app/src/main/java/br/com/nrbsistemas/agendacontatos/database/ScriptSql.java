package br.com.nrbsistemas.agendacontatos.database;

/**
 * Created by Everton on 22/01/2017.
 */

public class ScriptSql {
    public static String getCreateContato(){
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS CONTATO( ");
        sqlBuilder.append("_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("nome VARCHAR(100), ");
        sqlBuilder.append("telefone VARCHAR(14), ");
        sqlBuilder.append("tipoTelefone VARCHAR(1), ");
        sqlBuilder.append("email VARCHAR(30), ");
        sqlBuilder.append("tipoEmail VARCHAR(1), ");
        sqlBuilder.append("endereco VARCHAR(100), ");
        sqlBuilder.append("tipoEndereco VARCHAR(1), ");
        sqlBuilder.append("dataEspeciais DATE, ");
        sqlBuilder.append("tipoDatasEspeciais VARCHAR(1), ");
        sqlBuilder.append("grupos VARCHAR(255) ");
        sqlBuilder.append(");");

        return sqlBuilder.toString();
    }
}














