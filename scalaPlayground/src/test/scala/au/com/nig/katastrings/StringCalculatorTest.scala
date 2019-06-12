package au.com.nig.katastrings

import org.scalatest.{Matchers, WordSpec}

class StringCalculatorTest extends WordSpec with Matchers {

  "function add" should {
    "return 0 if empty String" in {
      // Given
      val testString = ""

      // When
      val result = StringCalculator.add(testString)

      // Then
      result shouldEqual 0
    }
    "return the number if only one number in the String" in {
      // Given
      val testString = "9"

      // When
      val result = StringCalculator.add(testString)

      // Then
      result shouldEqual 9
    }
    "return the sum of the 2 numbers if there are two numbers in the String" in {
      // Given
      val testString = "9,6"

      // When
      val result = StringCalculator.add(testString)

      // Then
      result shouldEqual 15
    }
    "return the sum of the numbers if there are SEVERAL numbers in the String" in {
      // Given
      val testString = "9,6,1,1"

      // When
      val result = StringCalculator.add(testString)

      // Then
      result shouldEqual 17
    }
  }
}
