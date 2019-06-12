package au.com.nig.katastrings

object StringCalculator {
  def add(numbers: String): Int = {
    if (!numbers.isEmpty) {
      val numbersWithCustomDelimiter = raw"//(.)\n(.*)".r
      val (delimiter, numberList) = numbers match {
        case numbersWithCustomDelimiter(d, n) => (d, n)
        case _ => (",", numbers)
      }

      val integers =  numberList
        .split(s"[$delimiter\n]")
        .map(_.toInt)

      val negIntegers = integers.filter(_ < 0)

      if (negIntegers.nonEmpty) throw new Exception(s"negatives: ${negIntegers.mkString(", ")} not allowed")
      else integers.sum
    } else 0
  }
}
