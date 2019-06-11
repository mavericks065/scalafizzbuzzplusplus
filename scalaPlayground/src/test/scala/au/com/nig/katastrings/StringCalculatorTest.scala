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
  }
}
