package au.com.nig.katastrings

object StringCalculator {
  def add(numbers: String): Int = {
    if (!numbers.isEmpty) {
      val delimiter = if (numbers.startsWith("//")) numbers.charAt(2) else ','
      numbers
        .stripPrefix(s"//$delimiter\n")
        .split(delimiter)
        .flatMap(_.split("\n").map(_.toInt))
        .sum
    } else 0
  }
}
