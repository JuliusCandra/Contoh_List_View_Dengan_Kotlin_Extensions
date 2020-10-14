package com.dev_candra.listview_with_kotlinextensions.acitivites

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.dev_candra.listview_with_kotlinextensions.R
import com.dev_candra.listview_with_kotlinextensions.adapter.CustomAdapter
import com.dev_candra.listview_with_kotlinextensions.model.Hero
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var customeAdapter : CustomAdapter
    private lateinit var dataName : Array<String>
    private lateinit var dataDeskripsi : Array<String>
    private lateinit var dataPhoto : TypedArray
    private var heroes = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customeAdapter = CustomAdapter(this)
        lv_list.adapter = customeAdapter
        lv_list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this,heroes[position].name,Toast.LENGTH_SHORT).show()
        }
        addItem()
        prepare()
        initToolbar()
    }
    
    private fun addItem(){
        dataName = resources.getStringArray(R.array.data_name)
        dataDeskripsi = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }
    
    private fun prepare(){
        for (position in dataName.indices){
            val hero = Hero(
                dataName[position],
                dataDeskripsi[position],
                dataPhoto.getResourceId(position,-1)
            )
            heroes.add(hero)
        }
        customeAdapter.heroes = heroes
    }

    private fun initToolbar(){
        if (supportActionBar != null){
            supportActionBar!!.title = "Candra Julius Sinaga"
            supportActionBar!!.subtitle = "List View Dengan Kotlin Extensions"
        }
    }
}

/*
    kesimpulan kotlin extension
    tidak perlu lagi fndviewbyid
    dengan adanya androidExtensions experimental = true udah bisa pakai Parclize
    dengan adanya layoutContainer hanya perlu pakai with
 */