package com.example.mykiosk

class Order() {

    var orderList = mutableListOf<Menu>()
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
                    if(orderList == null) {
                        println("주문하신 메뉴 입니다.")
                        selectedDisplay(orderList)
                    } else {
                        println("장바구니에 아무것도 존재하지 않습니다!")
                        return
                    }

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



    fun order(menu: Menu) {
        println("")
        println("${menu.name}은 ${menu.price}원 입니다. 장바구니에 추가하시겠습니까?")
        println("[y] 추가 [n] 취소")

        while (true) {

            var selectMenuOrder = InputNumber().inputNumber("selectString").toString()

            when (selectMenuOrder) {
                "y" -> {

                    addToCart(menu)
                    println("전체메뉴로 돌아갑니다.\n")
                    println("")
                    return
                }

                "n" -> {
                    println("취소하셨습니다. 전체 메뉴로 돌아갑니다.")
                    return
                }

                else -> {
                    println("잘못된 입력입니다. 영어 소문자로 정확히 입력해주세요.")
                }
            }

        }

    }


    fun addToCart(menu : Menu) {
        orderList.add(menu)
        println("${menu.name} 장바구니 추가 완료!")

    }

    fun selectedDisplay(orderList: List<Menu>){
        println("아래와 같이 주문하시겠습니까?")

        var totalPrice = 0

        orderList.forEachIndexed{idx,menu ->
            println("${idx + 1}. ${menu.name} : ${menu.price}\n")
            totalPrice += menu.price
        }

        println("총 가격: $totalPrice 원 입니다.\n")

    }

}