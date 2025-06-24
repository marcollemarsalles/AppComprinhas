package com.eduardofilipe.listadecompras.model

import java.io.Serializable

data class Compras (
    val idItem: Int,
    val nomeItem: String,
    val valorItem: Float,
    val qtdItem: Int,
    val totalItem: Float
): Serializable