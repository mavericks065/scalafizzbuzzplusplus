package au.com.nig.katastrings

object StringCalculator {
  def add(numbers: String): Int = {
    if (numbers.isEmpty) 0
    else numbers.split(",").flatMap(_.split("\n").map(_.toInt)).sum
  }
}
