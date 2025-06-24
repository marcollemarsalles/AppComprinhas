package com.eduardofilipe.listadecompras.database

import com.eduardofilipe.listadecompras.model.Compras

interface IcomprasDAO {

    fun salvar (compras: Compras): Boolean
    fun atualizar (compras: Compras): Boolean
    fun remover (idItem: Int): Boolean
    fun listar (): List<Compras>

}