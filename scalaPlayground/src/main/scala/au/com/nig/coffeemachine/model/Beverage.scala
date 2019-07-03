package au.com.nig.coffeemachine.model

sealed trait Beverage

case class Coffee(sugars: Int, hasStick: Boolean = false, extraHot: Boolean = false, price: BigDecimal = BigDecimal.valueOf(0.6)) extends Beverage

case class HotChocolate(sugars: Int, hasStick: Boolean = false, extraHot: Boolean = false, price: BigDecimal = BigDecimal.valueOf(0.5)) extends Beverage

case class Tea(sugars: Int, hasStick: Boolean = false, extraHot: Boolean = false, price: BigDecimal = BigDecimal.valueOf(0.4)) extends Beverage

case class OrangeJuice(price: BigDecimal = BigDecimal.valueOf(0.6)) extends Beverage

object Beverages {
  def getType: Request => Beverage = request => {
    request.getFirstLetterOfReq() match {
      case "c" =>
        val (sugars: Int, hasStick: Boolean, extraHot: Boolean) = extractSugarsAndStick(request)
        Coffee(sugars, hasStick, extraHot)
      case "t" =>
        val (sugars: Int, hasStick: Boolean, extraHot: Boolean) = extractSugarsAndStick(request)
        Tea(sugars, hasStick, extraHot)
      case "h" =>
        val (sugars: Int, hasStick: Boolean, extraHot: Boolean) = extractSugarsAndStick(request)
        HotChocolate(sugars, hasStick, extraHot)
      case "o" => OrangeJuice()
      case _ => throw new Exception("not managed")
    }
  }
  
  private def extractSugarsAndStick(command: Request): (Int, Boolean, Boolean) = {
    val sugars = if (command.getSecondPartOfReq().isEmpty)
      0
    else
      command.getSecondPartOfReq().toInt
    val hasStick = if (sugars >= 1) true else false
    val firstPartOfRequest = command.getFirstPartOfReq().toCharArray
    val extraHot = if (firstPartOfRequest.length > 1 && firstPartOfRequest(1).equals('h')) true else false
    (sugars, hasStick, extraHot)
  }
}