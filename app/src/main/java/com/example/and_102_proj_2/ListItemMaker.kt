package com.example.and_102_proj_2

import android.text.Editable

abstract class ListItemMaker : List<ListItem> {
    companion object {
        fun getNextListItem(
            itemNameView: Editable,
            priceView: Editable,
            storeView: Editable
        ): MutableList<ListItem> {
            var newListItem: MutableList<ListItem> = ArrayList()
            for (i in 0..0) {
                val listItem =
                    ListItem(itemNameView.toString(), priceView.toString(), storeView.toString())
                newListItem.add(listItem)
            }
            return newListItem
        }

        fun getNextListItem(): MutableList<ListItem> {
            return ArrayList()
        }
    }
}
