package au.com.nig.coffeemachine

import au.com.nig.coffeemachine.model._
import org.scalatest.{Matchers, WordSpec}

class BaristaTest extends WordSpec with Matchers {

  "function makeBeverage" should {
    "display a Message when order starts with letter M" in {
      // WHEN
      val result = Barista.makeBeverage(Order(Request("M::"), BigDecimal.valueOf(0)))

      // THEN
      result match {
        case Right(Message(_)) => succeed
        case _ => fail("This is not a Message therefore it is wrong")
      }
    }
    "display a Message with its content" in {
      // WHEN
      val result = Barista.makeBeverage(Order(Request("M:Content blabla"), BigDecimal.valueOf(0)))

      // THEN
      result match {
        case Right(Message("Content blabla")) => succeed
        case _ => fail("This is not a Message therefore it is wrong")
      }
    }
  }
}
