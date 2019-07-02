package au.com.nig.coffeemachine

import au.com.nig.coffeemachine.model._

/**
  * https://simcap.github.io/coffeemachine
  */
object Barista {

  def makeBeverage(order: Order): Either[Beverage, Message] = if (order.request.getFirstLetterOfReq().startsWith("m"))
    Right(Message(order.request.getSecondPartOfReq()))
  else
    Beverages.getType
    .andThen(OrderService.isOrderValid(_, order.amt))
    .apply(order.request)
}
