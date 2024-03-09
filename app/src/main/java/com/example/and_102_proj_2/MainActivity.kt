package com.example.and_102_proj_2

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {

    lateinit var listItems: List<ListItem>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemNameView = findViewById<EditText>(R.id.itemNameView)
        val priceView = findViewById<EditText>(R.id.priceView)
        val storeView = findViewById<EditText>(R.id.storeView)

        val listItemsRV = findViewById<RecyclerView>(R.id.listItemsRV)
        val listItems = ListItemMaker.getNextListItem()
        val adapter = WishlistAdapter(listItems)
        listItemsRV.adapter = adapter
        listItemsRV.layoutManager = LinearLayoutManager(this)


        findViewById<Button>(R.id.submitButton).setOnClickListener {
            hideKeyboard()
            if (itemNameView.text?.all { it.isDefined() } == true && priceView.text?.all { it.isDefined() } == true && storeView.text?.all { it.isDefined() } == true) {
                val newListItems =
                    ListItemMaker.getNextListItem(itemNameView.text, priceView.text, storeView.text)
                listItems.addAll(newListItems)
                adapter.notifyDataSetChanged()

                itemNameView.setText("")
                priceView.setText("")
                storeView.setText("")
            } else {
                itemNameView.setText("")
                priceView.setText("")
                storeView.setText("")
                Toast.makeText(this, "Enter an item name, price, and store", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    }