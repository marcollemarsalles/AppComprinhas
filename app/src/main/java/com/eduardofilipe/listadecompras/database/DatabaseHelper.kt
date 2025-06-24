package com.eduardofilipe.listadecompras.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context : Context) : SQLiteOpenHelper(
    context, NOME_BANCO_DADOS, null, VERSAO
){
    companion object{
        const val NOME_BANCO_DADOS = "ListaDeCompras.db"
        const val VERSAO = 1
        const val NOME_TABELA_COMPRAS = "compras"
        const val COLUNA_ID_ITEM = "id_item"
        const val COLUNA_NOME_ITEM = "nome_item"
        const val COLUNA_VALOR_ITEM = "valor_item"
        const val COLUNA_QTD_ITEM = "qtd_item"
        const val COLUNA_TOTAL = "total_item"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE IF NOT EXISTS $NOME_TABELA_COMPRAS(" +
                "$COLUNA_ID_ITEM INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "$COLUNA_NOME_ITEM VARCHAR(70)," +
                "$COLUNA_VALOR_ITEM FLOAT," +
                "$COLUNA_QTD_ITEM INTEGER NOT NULL DEFAULT 1," +
                "$COLUNA_TOTAL FLOAT" +
                ");"

        try {
            db?.execSQL(sql)
            Log.i("info_db", "Tabela criada com sucesso")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Erro ao criar a tabela")
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}