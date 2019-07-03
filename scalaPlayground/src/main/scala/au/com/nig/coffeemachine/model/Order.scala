package au.com.nig.coffeemachine.model

case class Order(request: Request, amt: BigDecimal)

case class Request(request: String) {
  val deconstructedCommand: Array[String] = request.split(":")

  def getFirstLetterOfReq(): String = request.charAt(0).toString.toLowerCase()

  def getFirstPartOfReq(): String = deconstructedCommand(0)

  def getSecondPartOfReq(): String = if (deconstructedCommand.length > 1) deconstructedCommand(1) else ""
}