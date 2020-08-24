package com.example.taiki.viewmodel

import java.util.*

class ScreenStack : ArrayDeque<String>() {
    fun pushScreen(screen: String) {
        push(screen)
    }

    fun popScreen(): String? {
        return try {
            pop()
        } catch (e: NoSuchElementException) {
            null
        }
    }

    fun peekScreen(): String? {
        return try {
            peek()
        } catch (e: NoSuchElementException) {
            null
        }
    }

//    fun getItemList(): List<Item> {
//        val filterName = peekScreen() ?: "root"
//        val list = SaveData.loadServiceList()?.filter { it.parentName.equals(filterName) }?.map {
//            DataModel.convertItemFromWebAPIData(
//                it
//            )
//        }
//        return list ?: emptyList()
//    }

}