package au.com.nig.katastrings

object StringCalculator {
  def add(numbers: String): Int = {
    if (!numbers.isEmpty) {
      val delimiter = if (numbers.startsWith("//")) numbers.charAt(2) else ','

      val integers =  numbers
        .stripPrefix(s"//$delimiter\n")
        .split(delimiter)
        .flatMap(_.split("\n").map(_.toInt))

      val negIntegers = integers.filter(i => i < 0)

      if (negIntegers.length > 0) throw new Exception(s"negatives: ${negIntegers.mkString(", ")} not allowed")
      else integers.sum
    } else 0
  }
}
