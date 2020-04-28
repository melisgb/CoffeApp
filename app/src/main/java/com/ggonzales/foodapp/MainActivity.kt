package com.ggonzales.foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
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
        listOfElements.add(CatalogueElement("BlueBerry Cream", "This blueberry ice cream, made with antioxidant-rich blueberries, cream, milk, and sugar, is a great spring and summer dessert.", R.drawable.blueberryicecream))
        listOfElements.add(CatalogueElement("Coffee", "Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain Coffea species.", R.drawable.cafe))
        listOfElements.add(CatalogueElement("Choco Cream", "Chocolate ice cream is generally made by blending cocoa powder along with the eggs, cream, vanilla and sugar used to make vanilla ice cream.", R.drawable.chocoicecream))
        listOfElements.add(CatalogueElement("Crepe", "Crepe is a very thin pancake. The term crepe derives from the Latin word crispus, which means curled.", R.drawable.crepe))
        listOfElements.add(CatalogueElement("Mango Juice", "This mango juice is made with no added sugar yet it is sufficiently sweet, fruity and so refreshing.", R.drawable.mangojuice))
        listOfElements.add(CatalogueElement("Sandwich", "A sandwich is a food typically consisting of vegetables, sliced cheese or meat, placed on or between slices of bread, or more generally any dish wherein bread serves as a container or wrapper for another food type.", R.drawable.sandwich))
        listOfElements.add(CatalogueElement("Tea", "English breakfast tea or simply breakfast tea is a traditional blend of teas originating from Assam, Ceylon, and Kenya. It is one of the most popular blended teas, common in British and Irish tea culture.", R.drawable.tea))
        listOfElements.add(CatalogueElement("Wrap", "The usual flatbreads are wheat tortillas, lavash, or pita; the filling usually consists of cold sliced meat, poultry, or fish accompanied by shredded lettuce, diced tomato or pico de gallo, guacamole, sauteed mushrooms, bacon, grilled onions, cheese, and a sauce, such as ranch or honey mustard.", R.drawable.wrap))

        adapter = CatalogueAdapter(listOfElements, this)
        catalogueGridView.adapter = adapter

        //function to control Long Clicks on Items in Grid.
        catalogueGridView.setOnItemLongClickListener { _, view, position, id ->
            Toast.makeText(this, "Long click", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CElementView::class.java)
            intent.putExtra("name", "${listOfElements[position].name!!}")
            intent.putExtra("desc", listOfElements[position].desc!!)
            intent.putExtra("image", listOfElements[position].image!!)
            intent.putExtra("hasLongClicked", "Yes")
            startActivity(intent)
            true
        }


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


            catElementView.setOnClickListener {
                val intent = Intent(context, CElementView::class.java)
                intent.putExtra("name", catElement.name!!)
                intent.putExtra("desc", catElement.desc!!)
                intent.putExtra("image", catElement.image!!)
                context!!.startActivity(intent)
            }


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
