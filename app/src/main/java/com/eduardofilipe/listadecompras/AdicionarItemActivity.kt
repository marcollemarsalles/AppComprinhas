package com.eduardofilipe.listadecompras

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eduardofilipe.listadecompras.database.ComprasDAO
import com.eduardofilipe.listadecompras.databinding.ActivityAdicionarItemBinding
import com.eduardofilipe.listadecompras.model.Compras

class AdicionarItemActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAdicionarItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Recuperar o item passado
        var compras: Compras? = null
        val bundle = intent.extras
        if (bundle != null){
            compras = bundle.getSerializable("compras") as Compras
            binding.editTxtItem.setText(compras.nomeItem)
            binding.editTextValorItem.setText(compras.valorItem.toString())
            binding.editTextQtdItem.setText(compras.qtdItem.toString())
        }


        ConfigurarToobar()

        binding.btnSalvar.setOnClickListener {
            
            if (binding.editTxtItem.text.isNotEmpty()) {

                if (compras != null) {
                    editar(compras)
                }else{
                    salvar()
                }

            }else{

                val textView = TextView(applicationContext)
                textView.text = "Preencha um item"
                val toast = Toast(applicationContext)
                toast.duration = Toast.LENGTH_SHORT
                toast.view = textView
                toast.show()

                //Toast.makeText(this, "Preencha um item", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun editar(compras: Compras) {
        val nomeItem = binding.editTxtItem.text.toString()
        val valorItem = binding.editTextValorItem.text.toString().toFloat()
        val qtdItem = binding.editTextQtdItem.text.toString().toInt()
        val totalItem = valorItem * qtdItem

        val comprasAtualizar = Compras(
            compras.idItem, nomeItem, valorItem, qtdItem, totalItem
        )
        val ComprasDAO = ComprasDAO(this)
        if (ComprasDAO.atualizar(comprasAtualizar)) {

            val textView = TextView(applicationContext)
            textView.text = "Item atualizado com sucesso"
            val toast = Toast(applicationContext)
            toast.duration = Toast.LENGTH_SHORT
            toast.view = textView
            toast.show()

            //Toast.makeText(this, "Item atualizado com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    private fun salvar() {
        val nomeItem = binding.editTxtItem.text.toString()
        val valorItem = binding.editTextValorItem.text.toString().toFloat()
        val qtdItem = binding.editTextQtdItem.text.toString().toInt()
        val totalItem = valorItem * qtdItem

        val compras = Compras(
            -1, nomeItem, valorItem, qtdItem, totalItem
        )
        val ComprasDAO = ComprasDAO(this)
        if (ComprasDAO.salvar(compras)) {

            val textView = TextView(applicationContext)
            textView.text = "Item adicionado com sucesso"
            val toast = Toast(applicationContext)
            toast.duration = Toast.LENGTH_SHORT
            toast.view = textView
            toast.show()

            //Toast.makeText(this, "Item adicionado com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        }
    }


    private fun ConfigurarToobar() {
        binding.tbAddItem.setTitle ("Adicionar novo item")
        binding.tbAddItem.setTitleTextColor(getColor(R.color.white))

        setSupportActionBar(binding.tbAddItem)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}



