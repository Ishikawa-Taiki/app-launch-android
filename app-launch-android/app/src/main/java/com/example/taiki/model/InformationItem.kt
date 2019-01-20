package com.example.taiki.model

class InformationItem(text: String, linkURL: String? = null): Item {
    val text = text + linkURL
    val linkURL = linkURL
}