package com.example.listaprod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listaprod.databinding.ActivityMainBinding
import com.example.listaprod.dataclass.Producto
import com.example.listaprod.dataadapter.ProductoAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var listaProd = ArrayList<Producto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        iniciar()
    }
    private fun limpiar(){
        with(binding){
            etID.setText("")
            etPrecio.setText("")
            etNombreProd.setText("")
            etID.requestFocus()

        }
    }
    private fun agregarProd(){
        with(binding){
            try{
                val id:Int = etID.text.toString().toInt()
                val nombre:String = etNombreProd.toString()
                val precio:Double = etPrecio.toString().toDouble()
                val prod = Producto(id, nombre, precio)
                listaProd.add(prod)
            }catch (ex: Exception){
                Toast.makeText(this@MainActivity, "Error: ${ex.toString()} "
                    , Toast.LENGTH_SHORT).show()
            }
            rcvLista.layoutManager = LinearLayoutManager(this@MainActivity)
            rcvLista.adapter = ProductoAdapter(listaProd)
            limpiar()
        }
    }
    private fun iniciar(){
        binding.btnAgregar.setOnClickListener{
            agregarProd()
        }
        binding.btnLimpiar.setOnClickListener{
            limpiar()
        }
    }
}