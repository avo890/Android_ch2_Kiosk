package com.example.kioskproject

class Beverage(
    id: Int,
    category: String,
    name: String,
    price: Int,
    explain: String,
    private val size: String
) :
    AbstractMenu(id, category, name, price, explain) {
    override fun displayInfo(): String {
        return if (size == "N/A") {  // 메뉴의 사이즈가 "N/A" 일때의 경우도 추가
            "%-10s | ₩ %4d | %s".format(name, price, explain)
        } else {
            "%s - %-5s | ₩ %4d | %s".format(name, size, price, explain)
        }
    }
}