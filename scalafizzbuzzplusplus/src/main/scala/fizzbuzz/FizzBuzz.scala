package fizzbuzz

object FizzBuzz {
  def getNumber(number: Int): String = {
    if (number % 15 == 0 && !number.toString.contains("3") && !number.toString.contains("5")) "fizzbuzz"
    else if (isDivisibleAndContainsNumber(number, 3) && !number.toString.contains("5")) "fizz"
    else if (isDivisibleAndContainsNumber(number, 5)) "buzz"
    else number.toString
  }

  private def isDivisibleAndContainsNumber(number:Int, dividend: Int) = {
    number % dividend == 0 || number.toString.contains(dividend.toString)
  }

  def doSomethingUselessButCrazy[U](lowerBound: Int, upperBound: Int, uselessFn: String => U): Seq[U] = {
    (lowerBound to upperBound).map(num => uselessFn(getNumber(num)))
  }
}


object Main {
  def main(args: Array[String]): Unit = {
    FizzBuzz.doSomethingUselessButCrazy(1, 100, println)
  }
}