package au.com.nig.coffeemachine.model

case class Order(request: Request, amt: BigDecimal)

case class Request(request: String) {
  val deconstructedCommand: Array[String] = request.split(":")

  def getFirstPartOfCmd(): String = request.charAt(0).toString.toLowerCase()

  def getSecondPartOfCommand(): String = if (deconstructedCommand.length > 1) deconstructedCommand(1) else ""
}