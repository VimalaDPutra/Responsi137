package com.example.responsi137

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    val nama    = arrayOf<String>(
        "Alienware",
        "Asus",
        "Dell",
        "Mackbook Pro",
        "Lenovo",
        "Vaio")

    val imageId = arrayOf<Int>(
        R.drawable.gb1,
        R.drawable.gb2,
        R.drawable.gb3,
        R.drawable.gb4,
        R.drawable.gb5,
        R.drawable.gb6


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val myListAdapter = ListAdapter(this,nama,imageId)
        lview.adapter = myListAdapter

        val bundle = intent.extras
        val userBro = bundle?.get("usr2").toString()
        val namaBro = bundle?.get("nama2").toString()
        val nimBro = bundle?.get("nim2").toString()
        val passBro = bundle?.get("pss2").toString()

        tombol.setOnClickListener{
            intent = Intent(this, AccountActivity::class.java)
            intent.putExtra("nim2",namaBro)
            intent.putExtra("nama2",nimBro)
            intent.putExtra("usr2",userBro)
            intent.putExtra("pss2",passBro)
            startActivity(intent)
        }

        lview.setOnItemClickListener(){adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

            var a = Integer.parseInt(itemIdAtPos.toString())
            var pr = a+1

            if (a.equals(0)){
                Toast.makeText(this, "Ini Laptop $itemAtPos , Dia adalah Laptop Alienware", Toast.LENGTH_LONG).show()
            }
            else if (a.equals(1)){
                Toast.makeText(this, "Ini Laptop $itemAtPos , Dia adalah Asus", Toast.LENGTH_LONG).show()
            }
            else if (a.equals(2)){
                Toast.makeText(this, "Ini Laptop $itemAtPos , Dia adalah Dell ", Toast.LENGTH_LONG).show()
            }
            else if (a.equals(3)){
                Toast.makeText(this, "Ini Laptop $itemAtPos , Dia adalah Mackbook Pro", Toast.LENGTH_LONG).show()
            }
            else if (a.equals(4)){
                Toast.makeText(this, "Ini Laptop $itemAtPos , Dia adalah Lenovo", Toast.LENGTH_LONG).show()
            }
            else if (a.equals(5)){
                Toast.makeText(this, "Ini Laptop $itemAtPos , Dia adalah Vaio", Toast.LENGTH_LONG).show()
            }


            else {
                Toast.makeText(this, "Pilihan Tidak ada ", Toast.LENGTH_LONG).show()
            }
        }
    }
}
