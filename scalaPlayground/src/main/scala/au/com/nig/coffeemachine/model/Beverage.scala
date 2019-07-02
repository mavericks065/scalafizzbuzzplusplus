package au.com.nig.coffeemachine.model

sealed trait Beverage

case class Coffee(sugars: Int, hasStick: Boolean = false, price: BigDecimal = BigDecimal.valueOf(0.6)) extends Beverage

case class HotChocolate(sugars: Int, hasStick: Boolean = false, price: BigDecimal = BigDecimal.valueOf(0.5)) extends Beverage

case class Tea(sugars: Int, hasStick: Boolean = false, price: BigDecimal = BigDecimal.valueOf(0.4)) extends Beverage

object Beverages {
  def getType: Request => Beverage = request => {
    request.getFirstPartOfCmd() match {
      case "c" =>
        val (sugars: Int, hasStick: Boolean) = extractSugarsAndStick(request)
        Coffee(sugars, hasStick)
      case "t" =>
        val (sugars: Int, hasStick: Boolean) = extractSugarsAndStick(request)
        Tea(sugars, hasStick)
      case "h" =>
        val (sugars: Int, hasStick: Boolean) = extractSugarsAndStick(request)
        HotChocolate(sugars, hasStick)
      case _ => throw new Exception("not managed")
    }
  }

  private def extractSugarsAndStick(command: Request): (Int, Boolean) = {
    val sugars = if (command.getSecondPartOfCommand().isEmpty)
      0
    else
      command.getSecondPartOfCommand().toInt
    val hasStick = if (sugars >= 1) true else false
    (sugars, hasStick)
  }
}