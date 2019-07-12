package au.com.nig.coffeemachine

import au.com.nig.coffeemachine.model._

/**
  * https://simcap.github.io/coffeemachine
  */
object Barista {

  def makeBeverage(order: Order): Either[Beverage, Message] = {
    OrderService.isOrderValid(order) match {
      case Left(x) => Left(Beverages.getType(x.request))
      case Right(y) => Right(y)
    }
  }

}
