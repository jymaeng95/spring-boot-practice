package com.group.libraryapp

import com.group.libraryapp.calculator.Calculator

/**
 * 사칙연산에 대한 수동으로 만든 테스트코드
 */
fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.`덧셈 테스트`()
    calculatorTest.`뺄셈 테스트`()
    calculatorTest.`곱셈 테스트`()
    calculatorTest.`나눗셈 테스트`()
    calculatorTest.`0으로 나눗셈 테스트`()
}
class CalculatorTest {

    fun `덧셈 테스트`() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.add(3)

        // then
        if (calculator.number != 8) {
            throw IllegalStateException()
        }
    }

    fun `뺄셈 테스트`() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.minus(3)

        // then
        if (calculator.number != 2) {
            throw IllegalStateException()
        }
    }
    fun `곱셈 테스트`() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.multiply(3)

        // then
        if (calculator.number != 15) {
            throw IllegalStateException()
        }
    }

    fun `나눗셈 테스트`() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.multiply(2)

        // then
        if (calculator.number != 2) {
            throw IllegalStateException()
        }
    }

    fun `0으로 나눗셈 테스트`() {
        // given
        val calculator = Calculator(5)

        // when
        try {
            calculator.divide(0)
        } catch (e: IllegalArgumentException) {
            if(e.message != "0으로 나눌 수 없습니다.")
                throw IllegalStateException("메세지가 다릅니다." +
                        "")
            // success
            return
        } catch (e: Exception) {
            throw IllegalStateException()
        }
        throw IllegalStateException("기대하는 예외가 발생하지 않았습니다.")

    }
}