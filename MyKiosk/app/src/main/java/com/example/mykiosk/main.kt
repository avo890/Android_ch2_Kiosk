package com.example.mykiosk

fun main() {

    val order = Order()
    val burger = Burger("",0)

    var orderList = mutableListOf<Menu>()

    val allMenusList = mutableMapOf<String,String>()
    allMenusList.put("Order", "장바구니를 확인하거나 취소합니다.")
    allMenusList.put("Burgers","주문 즉시 요리하는 버거 메뉴")
    allMenusList.put("McCafe","다양한 음료 메뉴")

    val burgerList = mutableListOf<Menu>(
        Burger("맥스파이시 상하이 버거 단품", 5500),
        Burger("맥크리스피 디럭스 버거 단품", 6800)
    )

    val mcCafeList = mutableListOf<Menu>(
        McCafe("Hot-드립커피", 2000),
        McCafe("Ice-드립커피", 1800)
    )

    val detailedMenu = mutableListOf<List<Menu>>()
    detailedMenu.add(burgerList)
    detailedMenu.add(mcCafeList)


    println("")
    println("[맥도날드 키오스크]")
    println("")

    while (true) {


        println("[전체 메뉴 : 번호를 입력하시면 상세 메뉴 페이지로 이동합니다.]")
        for (i in 0 until  allMenusList.size) {
            val key = allMenusList.keys.toList()[i]
            val value = allMenusList.values.toList()[i]
            println("$i. $key : $value")
        }

        val selectAllMenu = InputNumber().inputNumber("selectInt").toString().toInt()

        val keys = allMenusList.keys.toList()
        val idxKey = keys[selectAllMenu]

        println("")
        println("---------------------------------------------------")
        println("[${idxKey}의 상세 페이지로 이동합니다.]")

        when (selectAllMenu) {
            0 ->{
                order.orderOption()


            }

            1 -> {
                detailedDisplay(burgerList)
                var selectBurgerMenu = InputNumber().inputNumber("selectInt").toString().toInt()
                order.order(burgerList.get(selectBurgerMenu-1))

            }

            2 -> {
                detailedDisplay(mcCafeList)
                var selectMcCafeMenu = InputNumber().inputNumber("selectInt").toString().toInt()
                order.order(mcCafeList.get(selectMcCafeMenu-1))
            }


            else -> {
                println("잘못된 번호입니다. 올바른 번호를 입력해주세요.")
            }
        }

    }




}

fun detailedDisplay(detailedMenu : List<Menu>) {

    detailedMenu.forEachIndexed{idx,menu ->
        println("${idx + 1}. ${menu.name} : ${menu.price}")
        }
}

fun orderOption() {

    var select = ""

    while (true) {

        println("c. 장바구니 확인 및 주문 완료")
        println("b. 메인메뉴로 돌아가기")
        println("q. 주문 취소 및 프로그램 종료")

        var selectOrderOption = InputNumber().inputNumber("selectString").toString()

        println("")

        when (selectOrderOption) {
            "c" -> {
                println("주문하신 메뉴 입니다.")


            }

            "b" -> {
                println("메인메뉴로 돌아갑니다.")
                main()
            }
            "q" -> {
                println("프로그램이 종료됩니다.")
                System.exit(0)

            }

            else -> {
                println("잘못된 입력입니다. 정확하게 입력해주세요.")
            }

        }
    }
}


