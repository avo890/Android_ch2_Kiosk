package com.example.kioskproject

class Cart {

    fun checkAddItem(item: AbstractMenu?): Boolean {
        if (item == null) {
            println("선택하신 상품이 존재하지 않습니다. 관리자에게 문의해주세요.")
            return false
        } else {
            println(
                "\"${item.displayInfo()}\"\n" +
                        "위 메뉴를 장바구니에 추가하시겠습니까?"
            )
            println("1. 확인 2. 취소")
            while (true) {
                return when (SelectInput().selectInput("selectInt").toString().toInt()) {
                    1 -> {
                        true
                    }

                    2 -> {
                        false
                    }

                    else -> {
                        println("잘 못 된 번호를 입력했어요. 다시 입력해주세요.")
                        continue
                    }
                }
            }
        }
    }

}