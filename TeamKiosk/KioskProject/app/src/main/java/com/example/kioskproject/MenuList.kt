package com.example.kioskproject

class MenuList { // 일반 클래스로 사용하기 때문에 open 키워드 제거

    var cartList = arrayListOf<AbstractMenu>()

    var category = arrayListOf<AbstractMenu>()

    // 아이템 리스트는 외부에서 사용하지 않으므로 private로 선언
    private val hamburgerItems: ArrayList<AbstractMenu> = arrayListOf(
        Burger(1, "hamburger", "더블비프미트칠리버거", 3800, "매운맛의 더블 비프 패티 버거"),
        Burger(2, "hamburger", "더블쿼터파운더치즈", 3800, "더블 쿼터파운더와 치즈의 만남"),
        Burger(3, "hamburger", "맥스파이시", 4800, "매운맛의 크리스피 치킨 버거"),
        Burger(4, "hamburger", "불고기버거", 3900, "한국식 불고기 소스의 버거"),
        Burger(5, "hamburger", "빅맥", 4300, "큰 사이즈의 빅맥 버거")
    )
    private val drinkItems: ArrayList<AbstractMenu> = arrayListOf(
        Beverage(1, "drink", "코카콜라", 1500, "시원한 음료수", "Small"),
        Beverage(2, "drink", "코카콜라제로", 1500, "칼로리 제로 음료수", "Medium"),
        Beverage(3, "drink", "스프라이트", 1500, "레몬라임 맛 음료수", "Large"),
        Beverage(4, "drink", "환타", 1500, "과일 맛 음료수", "Regular"),
        Beverage(5, "drink", "오렌지쥬스", 2000, "신선한 오렌지 주스", "N/A")
    )

    // 사이드 메뉴 추가
    private val friedItems: ArrayList<AbstractMenu> = arrayListOf(
        Fried(1, "fried", "골든 모짜렐라 치즈스틱", 2000, "자연 모짜렐라 치즈로 빈틈 없이 고소한 치즈스틱", "2조각"),
        Fried(2, "fried", "골든 모짜렐라 치즈스틱", 4200, "자연 모짜렐라 치즈로 빈틈 없이 고소한 치즈스틱", "4조각"),
        Fried(3, "fried", "맥너겟", 2600, "바삭하고 촉촉한 치킨이 한 입에 쏙", "4조각"),
        Fried(4, "fried", "맥너겟", 3800, "바삭하고 촉촉한 치킨이 한 입에 쏙", "6조각"),
    )

    init {
        category.addAll(hamburgerItems)
        category.addAll(drinkItems)
        category.addAll(friedItems)
    }

    fun displayMenu(menu: String) {  // 카테고리별 메뉴 목록 출력하는 함수
        category.filter { it.category == menu }.forEach { println("${it.id}. ${it.displayInfo()}") }
        println("%d. %-10s | %s".format(0, "뒤로가기", "뒤로가기\n"))
    }

    fun getSelectedItem(menu: String, id: Int): AbstractMenu? {
        return category.filter { it.category == menu }.find { it.id == id }
    }

    fun getMenuCount(menu: String): Int {
        return category.count { it.category == menu }
    }

    fun addItemToCart(item: AbstractMenu?) {
        if (item == null) {
            println("선택하신 상품이 존재하지 않습니다. 관리자에게 문의해주세요.")
        } else {
            cartList.add(item)
            println("${item.name} 장바구니 추가 완료!\n")

        }
    }

    fun selectOrderOption() {

        while (true) {

            println("\n[Order MENU]")
            println("1. 장바구니 확인 및 주문하기")
            println("2. 메인메뉴로 돌아가기")
            println("3. 주문 취소 및 프로그램 종료")

            var selectOrderOption = SelectInput().selectInput("selectString").toString()

            println("")

            when (selectOrderOption) {
                "1" -> {
                    if(cartList.size != 0){
                        println("주문하신 메뉴 입니다.")
                        showCartList(cartList)
                        println(" 0. 더 주문하기  1. 최종 주문 완료 ")

                        when (SelectInput().selectInput("selectInt").toString().toInt()) {
                            0 -> {
                                return
                            }
                            1 -> {
                                // 주문 종료
                                println("주문이 완료되었습니다. 감사합니다.")
                                cartList.clear()
                                System.exit(0)
                            }
                            else -> {
                                println("잘못된 번호를 입력했어요. 다시 입력해주세요.")
                            }
                        }

                    } else {
                        println("장바구니가 비어 있습니다.")
                    }

                }

                "2" -> {
                    println("메인메뉴로 돌아갑니다.")
                    return
                }

                "3" -> {
                    println("프로그램이 종료됩니다.")
                    System.exit(0)
                }

                else -> {
                    println("잘못된 입력입니다. 정확하게 입력해주세요.")
                }

            }
        }
    }


    fun showCartList(cartList : List<AbstractMenu>) {

        var totalPrice = 0

        cartList.forEachIndexed{idx,item ->
            println("${idx + 1}. ${MenuManage(item).displayInfo()}")
            totalPrice += item.price
        }

        println("\n총 가격: $totalPrice 원 입니다.\n")

    }
}

