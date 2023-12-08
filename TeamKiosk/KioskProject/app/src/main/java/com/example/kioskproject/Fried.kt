package com.example.kioskproject

class Fried(
    id: Int,
    category: String,
    name: String,
    price: Int,
    description: String,
    private val size: String
) :
    AbstractMenu(id, category, name, price, description) {
    override fun displayInfo(): String {
        return if (size == "N/A") {
            "%-10s | ₩ %4d | %s".format(name, size, price, explain)
        } else {
            "%s - %-5s| ₩ %4d | %s".format(name, size, price, explain)
        }
    }
}