package com.eduardofilipe.listadecompras

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*//import android.content.Intent
import android.os.Bundle
//import android.util.Log
//import android.widget.ImageView
import android.widget.TextView
//import android.widget.Toast
import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
*//*import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eduardofilipe.listadecompras.adapter.ItemAdapter
import com.eduardofilipe.listadecompras.database.ComprasDAO
import com.eduardofilipe.listadecompras.databinding.ActivityMainBinding
import com.eduardofilipe.listadecompras.model.Compras
import com.google.android.material.floatingactionbutton.FloatingActionButton*/

class MainActivity : AppCompatActivity() {

    /*private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }*/
    /*private var listaItem = emptyList<Compras>()
    private var itemAdapter: ItemAdapter? = null*/

    //findviewbyid
    /*private lateinit var rvItens: RecyclerView
    private lateinit var fabAdicionar: FloatingActionButton*/
    private lateinit var txtTotal: TextView
    //private lateinit var imageViewBannerPrincipal: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)//(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //
        /*rvItens = findViewById(R.id.rvItens)
        fabAdicionar = findViewById(R.id.fabAdicionar)*/
        txtTotal = findViewById(R.id.txtTotal)
        txtTotal.text = "R$ 00,00"

        /*imageViewBannerPrincipal = findViewById(R.id.imageViewBannerPrincipal)

        imageViewBannerPrincipal.setImageResource(R.drawable.logo_principal)*/

        /*Log.i("info_db", "OnCreate")

        binding.fabAdicionar.setOnClickListener {
            val intent = Intent(this, AdicionarItemActivity::class.java)
            startActivity(intent)
        }

        Log.i("info_db", "OnCreate")

        //RecycleView
        itemAdapter = ItemAdapter(
            { id -> confirmarExclusao(id) },
            { compras -> editar(compras) }
        )

        binding.rvItens.adapter = itemAdapter
        binding.rvItens.layoutManager = LinearLayoutManager(this)


    }

    private fun editar(compras: Compras) {
        val intent = Intent(this, AdicionarItemActivity::class.java)
        intent.putExtra("compras", compras)
        startActivity(intent)
    }


    private fun confirmarExclusao(id: Int) {
        val alertBuider = AlertDialog.Builder(this)

        alertBuider.setTitle("Confirmar exclusão")
        alertBuider.setMessage("Deseja realmente excluir este item?")

        alertBuider.setPositiveButton("Sim") { _, _ ->

            if(ComprasDAO(this).remover(id)){
                atualizarLista()

                val textView = TextView(applicationContext)
                textView.text = "Item removido com sucesso"
                val toast = Toast(applicationContext)
                toast.duration = Toast.LENGTH_SHORT
                toast.view = textView
                toast.show()

                //Toast.makeText(this, "Item removido com sucesso", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Erro ao remover item", Toast.LENGTH_SHORT).show()
            }

            Log.i("info_db", "Item excluído com sucesso")
        }

        alertBuider.setNegativeButton("Não") { _, _ ->
            Log.i("info_db", "Exclusão cancelada")
        }

        alertBuider.create().show()
    }

    private fun atualizarLista() {
        listaItem = ComprasDAO(this).listar()
        itemAdapter?.adicionarLista(listaItem)

        //Total Lista
        val totalLista = ComprasDAO(this).listar()
        var total = 0.0
        totalLista.forEach { compras ->
            total += compras.totalItem
        }
        //total duas casas decimais
        binding.txtTotal.text = "R$ ${String.format("%.2f", total)}"
    }

    override fun onStart() {
        super.onStart()
        atualizarLista()

*//*        listaItem.forEach { compras ->
            Log.i("info_db",
                "${compras.idItem} - ${compras.nomeItem} - ${compras.valorItem} - " +
                        "${compras.qtdItem} - ${compras.totalItem} \n")
        }*/

    }
}
