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
    "return the sum of 2 numbers if they are delimited by a NEW LINES" in {
      // Given
      val testString = "1\n1"

      // When
      val result = StringCalculator.add(testString)

      // Then
      result shouldEqual 2
    }
    "return the sum of the numbers if there are SEVERAL numbers in the String with NEW LINES" in {
      // Given
      val testString = "9,6,1\n1"

      // When
      val result = StringCalculator.add(testString)

      // Then
      result shouldEqual 17
    }
    "get the delimiter and do the sum of the numbers if there is no" in {
      // Given
      val testString = "//,\n9,1"

      // When
      val result = StringCalculator.add(testString)

      // Then
      result shouldEqual 10
    }
  }
}
