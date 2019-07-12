package au.com.nig.coffeemachine

import au.com.nig.coffeemachine.model._
import org.scalatest.{Matchers, WordSpec}

class OrderServiceTest extends WordSpec with Matchers {
  "function isOrderValid" should {
    "send back Messages when amt paid is less than the price of a beverage" in {
      // WHEN
      val invalidTeaResult = OrderService.isOrderValid(Order(Request("Th:1:0"), BigDecimal.valueOf(0.3)))
      val invalidCoffeeResult = OrderService.isOrderValid(Order(Request("c:1:0"), BigDecimal.valueOf(0.3)))
      val invalidHotChocolateResult = OrderService.isOrderValid(Order(Request("H:1:0"), BigDecimal.valueOf(0.3)))

      // THEN
      invalidTeaResult.isRight shouldBe true
      invalidTeaResult.right.get shouldEqual Message("Amount paid is missing 0.1")
      invalidCoffeeResult.isRight shouldBe true
      invalidCoffeeResult.right.get shouldEqual Message("Amount paid is missing 0.3")
      invalidHotChocolateResult.isRight shouldBe true
      invalidHotChocolateResult.right.get shouldEqual Message("Amount paid is missing 0.2")
    }
  }
}
