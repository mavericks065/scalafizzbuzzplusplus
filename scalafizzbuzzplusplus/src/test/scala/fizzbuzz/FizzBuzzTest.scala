package fizzbuzz

import org.scalatest.{Matchers, WordSpec}

class FizzBuzzTest extends WordSpec with Matchers {
  "getNumber" should {
    "return fizz when divisible by 3" in {
      // GIVEN
      val three = 3
      val num = 21

      // WHEN
      val result = FizzBuzz.getNumber(three)
      val result2 = FizzBuzz.getNumber(num)

      // THEN
      result shouldEqual "fizz"
      result2 shouldEqual "fizz"
    }
    "return fizz if it has a 3" in {
      // GIVEN
      val three = 3
      val num = 30

      // WHEN
      val result = FizzBuzz.getNumber(three)
      val result2 = FizzBuzz.getNumber(num)

      // THEN
      result shouldEqual "fizz"
      result2 shouldEqual "fizz"
    }
    "return buzz when divisible by 5" in {
      // GIVEN
      val five = 5
      val num = 50

      // WHEN
      val result = FizzBuzz.getNumber(five)
      val result2 = FizzBuzz.getNumber(num)

      // THEN
      result shouldEqual "buzz"
      result2 shouldEqual "buzz"
    }
    "return buzz if it has a 5" in {
      // GIVEN
      val five = 5
      val num = 15

      // WHEN
      val result = FizzBuzz.getNumber(five)
      val result2 = FizzBuzz.getNumber(num)

      // THEN
      result shouldEqual "buzz"
      result2 shouldEqual "buzz"
    }
    "return fizzbuzz when divisible by 15" in {
      // GIVEN
      val num = 180
      val num2 = 90

      // WHEN
      val result = FizzBuzz.getNumber(num)
      val result2 = FizzBuzz.getNumber(num2)

      // THEN
      result shouldEqual "fizzbuzz"
      result2 shouldEqual "fizzbuzz"
    }
    "return the number otherwise" in {
      // GIVEN
      val num = 7

      // WHEN
      val result = FizzBuzz.getNumber(num)

      // THEN
      result shouldEqual "7"
    }
  }

}
