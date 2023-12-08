package com.example.kioskproject

class SelectInput {
    fun selectInput(type: String): Any {
        return when (type) {
            "selectInt" -> {
                print("\n원하는 번호를 입력해주세요. : ")
                while (true) {
                    try {
                        val selectInt: String? = readlnOrNull()
                        return selectInt?.toInt() ?: -1
                    } catch (e: Exception) {
                        println("올바른 번호를 다시 선택해주세요. 숫자만 입력 가능 합니다.")
                    }
                }
            }

            "selectDouble" -> {
                print("\n원하는 번호를 입력해주세요. : ")
                while (true) {
                    try {
                        val selectDouble: String? = readlnOrNull()
                        return selectDouble?.toDouble() ?: -1.0
                    } catch (e: Exception) {
                        println("올바른 번호를 다시 선택해주세요. 숫자(소수점 가능)만 입력 가능 합니다.")
                    }
                }
            }

            "selectString" -> {
                print("\n메뉴를 입력해주세요. : ")
                while (true) {
                    try {
                        val selectString: String? = readlnOrNull()
                        return selectString ?: -1
                    } catch (e: Exception) {
                        println("영어 소문자로 정확하게 입력해주세요.")
                    }
                }
            }

            else -> {
                return "no"
            }
        }
    }


}