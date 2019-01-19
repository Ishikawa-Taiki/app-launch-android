package com.example.taiki.model

class GroupItem(name: String, items: List<Item> = emptyList<Item>()): Item {
    val name = name
    val items = items
}