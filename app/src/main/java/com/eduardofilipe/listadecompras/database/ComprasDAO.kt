package com.eduardofilipe.listadecompras.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.eduardofilipe.listadecompras.model.Compras

class ComprasDAO(context: Context) : IcomprasDAO {

    private val escrita = DatabaseHelper(context).writableDatabase
    private val leitura = DatabaseHelper(context).readableDatabase

    override fun salvar(compras: Compras): Boolean {

        val conteudos = ContentValues()
        conteudos.put(DatabaseHelper.COLUNA_NOME_ITEM, compras.nomeItem)
        conteudos.put(DatabaseHelper.COLUNA_VALOR_ITEM, compras.valorItem)
        conteudos.put(DatabaseHelper.COLUNA_QTD_ITEM, compras.qtdItem)
        conteudos.put(DatabaseHelper.COLUNA_TOTAL, compras.totalItem)

        try {
            escrita.insert(
                DatabaseHelper.NOME_TABELA_COMPRAS,
                null,
                conteudos
            )
            Log.i("info_db", "Sucesso ao salvar Item")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Erro ao salvar Item")
            return false
        }

        return true
    }

    override fun atualizar(compras: Compras): Boolean {

        val argumentos = arrayOf(compras.idItem.toString())
        val conteudos = ContentValues()
        conteudos.put(DatabaseHelper.COLUNA_NOME_ITEM, compras.nomeItem)
        conteudos.put(DatabaseHelper.COLUNA_VALOR_ITEM, compras.valorItem)
        conteudos.put(DatabaseHelper.COLUNA_QTD_ITEM, compras.qtdItem)
        conteudos.put(DatabaseHelper.COLUNA_TOTAL, compras.totalItem)

        try {
            escrita.update(
                DatabaseHelper.NOME_TABELA_COMPRAS,
                conteudos,
                "${DatabaseHelper.COLUNA_ID_ITEM} = ?",
                argumentos
            )
            Log.i("info_db", "Sucesso ao atualizar Item")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Erro ao atualizar Item")
            return false
        }
        return true
    }

    override fun remover(idItem: Int): Boolean {

        val argumentos = arrayOf(idItem.toString())
        try {
            escrita.delete(
                DatabaseHelper.NOME_TABELA_COMPRAS,
                "${DatabaseHelper.COLUNA_ID_ITEM} = ?",
                argumentos
            )
            Log.i("info_db", "Sucesso ao remover Item")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Erro ao remover Item")
            return false
        }
        return true
    }

    override fun listar(): List<Compras> {

        val listaItem = mutableListOf<Compras>()

        val sql = "SELECT * FROM ${DatabaseHelper.NOME_TABELA_COMPRAS}"

        val cursor = leitura.rawQuery(sql, null)

        val indiceIdItem = cursor.getColumnIndex(DatabaseHelper.COLUNA_ID_ITEM)
        val indiceNomeItem = cursor.getColumnIndex(DatabaseHelper.COLUNA_NOME_ITEM)
        val indiceValorItem = cursor.getColumnIndex(DatabaseHelper.COLUNA_VALOR_ITEM)
        val indiceQtdItem = cursor.getColumnIndex(DatabaseHelper.COLUNA_QTD_ITEM)
        val indiceTotal = cursor.getColumnIndex(DatabaseHelper.COLUNA_TOTAL)

        while (cursor.moveToNext()) {
            val idItem = cursor.getInt(indiceIdItem)
            val nomeItem = cursor.getString(indiceNomeItem)
            val valorItem = cursor.getFloat(indiceValorItem)
            val qtdItem = cursor.getInt(indiceQtdItem)
            val total = cursor.getFloat(indiceTotal)

            listaItem.add(
                Compras(idItem, nomeItem, valorItem, qtdItem, total)
            )
        }
        return listaItem
    }
}