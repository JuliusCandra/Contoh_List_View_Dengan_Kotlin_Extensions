package com.dev_candra.listview_with_kotlinextensions.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.dev_candra.listview_with_kotlinextensions.R
import com.dev_candra.listview_with_kotlinextensions.model.Hero
import kotlinx.android.synthetic.main.item_list_one.view.*

class CustomAdapter (private val context : Context) : BaseAdapter() {

    internal var heroes = arrayListOf<Hero>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_list_one,parent,false)
        }
        val viewOne = ViewHolder(view as View)
        val hero = getItem(position) as Hero
        viewOne.bind(hero)
        return view
    }

    override fun getItem(position: Int): Any = heroes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = heroes.size

   inner class ViewHolder(private val view : View){
        fun bind(hero : Hero){
            with(view){
                textNama.text = hero.name
                teksDeskripsi.text = hero.description
                imgPhoto.setImageResource(hero.photo)
            }
        }
    }
}