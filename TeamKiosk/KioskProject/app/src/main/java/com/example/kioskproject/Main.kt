package com.example.kioskproject

fun main() {
    val cart = Cart()
    val mainMenu = MainMenu()
    val menuList = MenuList()
    val selectInput = SelectInput()

    while (true) {
        mainMenu.displayMainMenu()
        val selectAllMenu = selectInput.selectInput("selectInt").toString().toInt()
        mainMenu.selectedMainMenu(selectAllMenu)

        when (selectAllMenu) {
            0 -> {
                menuList.selectOrderOption()

            }

            1 -> {
                // TODO 버거 메뉴
                val category = "hamburger"
                menuList.displayMenu(category)
                while (true) {
                    when (val selectItem =
                        selectInput.selectInput("selectInt").toString().toInt()) {
                        0 -> {
                            break
                        }

                        in 1..menuList.getMenuCount(category) -> {
                            val item = menuList.getSelectedItem(category, selectItem)
                            if (cart.checkAddItem(item)) { // add item
                                menuList.addItemToCart(item)
                            }
                            break
                        }

                        else -> {
                            println("잘 못 된 번호를 입력했어요. 다시 입력해주세요.")
                        }
                    }
                }

            }

            2 -> {
                // TODO 음료 메뉴
                val category = "drink"
                menuList.displayMenu(category)
                while (true) {
                    when (val selectItem =
                        selectInput.selectInput("selectInt").toString().toInt()) {
                        0 -> {
                            break
                        }

                        in 1..menuList.getMenuCount(category) -> {
                            val item = menuList.getSelectedItem(category, selectItem)
                            if (cart.checkAddItem(item)) { // add item
                                menuList.addItemToCart(item)
                            }
                            break
                        }

                        else -> {
                            println("잘 못 된 번호를 입력했어요. 다시 입력해주세요.")
                        }
                    }
                }
            }

            3 -> {
                // TODO 사이드 메뉴
                val category = "fried"
                menuList.displayMenu(category)
                while (true) {
                    when (val selectItem =
                        selectInput.selectInput("selectInt").toString().toInt()) {
                        0 -> {
                            break
                        }

                        in 1..menuList.getMenuCount(category) -> {
                            val item = menuList.getSelectedItem(category, selectItem)
                            if (cart.checkAddItem(item)) { // add item
                                menuList.addItemToCart(item)
                            }
                            break
                        }

                        else -> {
                            println("잘 못 된 번호를 입력했어요. 다시 입력해주세요.")
                        }
                    }
                }
            }

            else -> {
                println("잘 못 된 번호입니다. 올바른 번호를 입력해주세요.")
            }
        }


    }
}