package com.example.kioskproject

class MenuManage(private val abstractMenu: AbstractMenu) {
    fun displayInfo(): String {
        return abstractMenu.displayInfo()
    }
}