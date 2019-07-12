package au.com.nig.coffeemachine

import au.com.nig.coffeemachine.model._

object OrderService {
  private val teaPrice = BigDecimal.valueOf(0.4)
  private val chocolatePrice = BigDecimal.valueOf(0.5)
  private val coffeePrice = BigDecimal.valueOf(0.6)
  private val orangePrice = BigDecimal.valueOf(0.6)

  def isOrderValid(order: Order): Either[Order, Message] = {
    val firstLetter = order.request.getFirstPartOfReq().toLowerCase.charAt(0).toString
    (firstLetter, order.amt) match {
      case ("m", _) => Right(Message(order.request.getSecondPartOfReq()))
      case ("t", amtPaid) if amtPaid < teaPrice => Right(Message(s"Amount paid is missing ${teaPrice - amtPaid}"))
      case ("h", amtPaid) if amtPaid < chocolatePrice => Right(Message(s"Amount paid is missing ${chocolatePrice - amtPaid}"))
      case ("c", amtPaid) if amtPaid < coffeePrice => Right(Message(s"Amount paid is missing ${coffeePrice - amtPaid}"))
      case ("o", amtPaid) if amtPaid < orangePrice => Right(Message(s"Amount paid is missing ${orangePrice - amtPaid}"))
      case (_, _) => Left(order)
    }
  }
}
