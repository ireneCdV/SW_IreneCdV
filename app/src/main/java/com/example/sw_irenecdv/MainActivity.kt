package com.example.sw_irenecdv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sw_irenecdv.adapter.SWAdapter
import com.example.sw_irenecdv.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Hacemos el binding del recyclerView
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recycler.layoutManager = LinearLayoutManager(this)
        val SWadapter = SWAdapter(emptyList())
        binding.recycler.adapter = SWadapter

        binding.VerListado.setOnClickListener{

        CoroutineScope(Dispatchers.IO).launch{
            val call = getRetrofit().create(APIService::class.java).getSW("people")
            val personaje = call.body()
            runOnUiThread{
                if (call.isSuccessful){
                    val resultado = personaje?.results ?:emptyList()
                    SWadapter.notifyDataSetChanged()
                    Toast.makeText(this@MainActivity,SWadapter.SWList.first().name, Toast.LENGTH_SHORT).show()

                    binding.GuardarListado

                }

                else
                    Toast.makeText(this@MainActivity, "Ha ocurrido un error", Toast.LENGTH_LONG).show()
            }
        }
        }

    }

   

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}