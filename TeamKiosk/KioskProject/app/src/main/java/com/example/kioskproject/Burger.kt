package com.example.kioskproject

class Burger(id: Int, category: String, name: String, price: Int, explain: String) :
    AbstractMenu(id, category, name, price, explain) {
    override fun displayInfo(): String {
        return "%-10s | ₩ %4d | %s".format(name, price, explain)
    }
}