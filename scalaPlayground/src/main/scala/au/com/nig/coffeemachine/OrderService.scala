package au.com.nig.coffeemachine

import au.com.nig.coffeemachine.model._

object OrderService {

  def isOrderValid(beverage: Beverage, amtPaid: BigDecimal): Either[Beverage, Message] = {
    beverage match {
      case Tea(_, _, price) if amtPaid < price =>
        Right(Message(s"Amount paid is missing ${price - amtPaid}"))
      case Coffee(_, _, price) if amtPaid < price =>
        Right(Message(s"Amount paid is missing ${price - amtPaid}"))
      case HotChocolate(_, _, price) if amtPaid < price =>
        Right(Message(s"Amount paid is missing ${price - amtPaid}"))
      case x => Left(x)
    }
  }
}
