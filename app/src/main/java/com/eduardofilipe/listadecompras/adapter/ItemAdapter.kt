package com.eduardofilipe.listadecompras.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eduardofilipe.listadecompras.databinding.ItemListaBinding
import com.eduardofilipe.listadecompras.model.Compras


class ItemAdapter(
    val onClickEscluir: (Int) -> Unit,
    val onClickEditar: (Compras) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    //private var listaItem = List<Compras> = emptyList()
    private var listaItem = emptyList<Compras>()

    fun adicionarLista(lista: List<Compras>){
        this.listaItem = lista
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(itemListabinding: ItemListaBinding)
        : RecyclerView.ViewHolder(itemListabinding.root){

        private val binding: ItemListaBinding

        init {
            binding = itemListabinding
        }

        fun bind(compras: Compras){

            binding.textNomeItem.text = compras.nomeItem
            binding.editTextValorItem.setText("R$ "+ compras.valorItem.toString())
            binding.textQtdItem.text = compras.qtdItem.toString() + "x"
            binding.editTextTotalItem.setText("R$ "+ compras.totalItem.toString())

            binding.imageBtnRemoverItem.setOnClickListener {
                onClickEscluir(compras.idItem)
            }

            binding.imageBtnEditarItem.setOnClickListener {
                onClickEditar(compras)
            }


        }
    }

    //Criar a visualização
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemListaBinding = ItemListaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(itemListaBinding)
    }

    //Configurar os dados para a visualização
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val lista = listaItem[position]
        holder.bind(lista)
    }

    //Recuperar a quantidade de itens
    override fun getItemCount(): Int {
        return listaItem.size
    }
}