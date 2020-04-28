package com.ggonzales.foodapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.catalogue_element.*
import kotlinx.android.synthetic.main.catalogue_element.view.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var adapter : CatalogueAdapter? = null
        var listOfElements = ArrayList<CatalogueElement>()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Loading Catalogue Elements
        listOfElements.add(CatalogueElement("BlueBerry Cream", "BlueBerry Ice Cream", R.drawable.blueberryicecream))
        listOfElements.add(CatalogueElement("Coffee", "Coffee", R.drawable.cafe))
        listOfElements.add(CatalogueElement("Choco Cream", "Chocolate Ice Cream", R.drawable.chocoicecream))
        listOfElements.add(CatalogueElement("Crepe", "Crepe", R.drawable.crepe))
        listOfElements.add(CatalogueElement("Mango Juice", "Mango Juice", R.drawable.mangojuice))
        listOfElements.add(CatalogueElement("Sandwich", "Sandwich", R.drawable.sandwich))
        listOfElements.add(CatalogueElement("Tea", "English Tea", R.drawable.tea))
        listOfElements.add(CatalogueElement("Wrap", "Salad Wrap", R.drawable.wrap))

        adapter = CatalogueAdapter(listOfElements, this)
        catalogueGridView.adapter = adapter
    }

    inner class CatalogueAdapter: BaseAdapter{
        var elementsList = ArrayList<CatalogueElement>()
        var context : Context? = null

        constructor(elementsList : ArrayList<CatalogueElement>, context: Context) : super() {
            this.elementsList = elementsList
            this.context = context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var catElementView = inflater.inflate(R.layout.catalogue_element, null)
            val catElement = elementsList[position]
            catElementView.elementTxtView.text = catElement.name!!
            catElementView.elementImageButton.setImageResource(catElement.image!!)
            return catElementView
        }

        override fun getItem(position: Int): Any {
            return elementsList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return elementsList.size
        }

    }

}
