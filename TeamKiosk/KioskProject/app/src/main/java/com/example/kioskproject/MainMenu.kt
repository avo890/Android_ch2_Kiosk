package com.example.kioskproject

class MainMenu { // 메뉴 아이템을 관리하는 클래스
    private val allMenuList = mutableMapOf<String, String>()
    private var keys = listOf<String>()
    private var values = listOf<String>()

    init {
        addItem()
        keys = allMenuList.keys.toList()
        values = allMenuList.values.toList()
    }

    private fun addItem() {  // 메인 카테고리 리스트에 아이템 추가
        allMenuList["Burgers"] = "주문 즉시 바로 조리해 더욱 맛있는, 맥도날드의 다양한 버거를 소개합니다."
        allMenuList["McCafe & Beverage"] = "언제나 즐겁게, 맥카페와 다양한 음료를 부담없이 즐기세요!"
        allMenuList["Side & Dessert"] = "버거와 함께 즐기면 언제나 맛있는 사이드와 디저트 메뉴!"
    }

    fun displayMainMenu() {  // 메인 카테고리 리스트를 출력하는 함수
        println(
            "\n--번호를 입력하시면 상세 메뉴 페이지로 이동합니다.--\n" +
                    "[ McDonald's's MENU ]"
        )

        for (i in 0 until allMenuList.size) {
            println("${i + 1}. ${keys[i]} : ${values[i]}")
        }
        println("0. %-10s : %s".format("Order", "장바구니를 확인하거나 취소합니다."))
    }

    fun selectedMainMenu(index: Int) { // 메인 카테고리 리스트에서 선택한 아이템을 출력하는 함수
        if (index < 1 || keys.size < index) {
            return
        }
        println("\"${keys[index - 1]}\"의 상세 페이지로 이동합니다.\n")
        println("[${keys[index - 1]} MENU]")

    }



}