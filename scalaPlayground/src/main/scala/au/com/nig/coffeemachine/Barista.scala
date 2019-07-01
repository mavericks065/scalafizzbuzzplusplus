package au.com.nig.coffeemachine

/**
  * https://simcap.github.io/coffeemachine
  */
object Barista {

  def makeBeverage(command: String): Beverage = {
    val deconstructCommand = command.split(":")
    val beverageType = deconstructCommand(0).toLowerCase()

    beverageType match {
      case "c" =>
        val (sugars: Int, hasStick: Boolean) = extractSugarsAndStick(deconstructCommand)
        Coffee(sugars, hasStick)
      case "t" =>
        val (sugars: Int, hasStick: Boolean) = extractSugarsAndStick(deconstructCommand)
        Tea(sugars, hasStick)
      case "h" =>
        val (sugars: Int, hasStick: Boolean) = extractSugarsAndStick(deconstructCommand)
        HotChocolate(sugars, hasStick)
      case "m" =>
        val content = if (deconstructCommand.length > 1)
          deconstructCommand(1)
        else ""
        Message(content)
      case _ => throw new Exception("not managed")
    }
  }

  private def extractSugarsAndStick(deconstructCommand: Array[String]) = {
    val sugars = if (deconstructCommand.length > 1)
      deconstructCommand(1).toInt
    else 0
    val hasStick = if (sugars >= 1) true else false
    (sugars, hasStick)
  }
}

sealed trait Beverage

case class Coffee(sugars: Int, hasStick: Boolean = false) extends Beverage

case class HotChocolate(sugars: Int, hasStick: Boolean = false) extends Beverage

case class Tea(sugars: Int, hasStick: Boolean = false) extends Beverage

case class Message(content: String) extends Beverage
