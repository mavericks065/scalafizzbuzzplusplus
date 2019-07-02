package au.com.nig.coffeemachine

import au.com.nig.coffeemachine.model.{Coffee, HotChocolate, Message, Tea}
import org.scalatest.{Matchers, WordSpec}

class OrderServiceTest extends WordSpec with Matchers {

  "fn isOrderValid" should {
    "send back Messages when amt paid is less than the price of a beverage" in {
      // WHEN
      val invalidTeaResult = OrderService.isOrderValid(Tea(0), BigDecimal.valueOf(0.2))
      val invalidCoffeeResult = OrderService.isOrderValid(Coffee(0), BigDecimal.valueOf(0.2))
      val invalidHotChocolateResult = OrderService.isOrderValid(HotChocolate(0), BigDecimal.valueOf(0.2))

      // THEN
      invalidTeaResult.isRight shouldBe true
      invalidTeaResult.right.get shouldEqual Message("Amount paid is missing 0.2")
      invalidCoffeeResult.isRight shouldBe true
      invalidCoffeeResult.right.get shouldEqual Message("Amount paid is missing 0.4")
      invalidHotChocolateResult.isRight shouldBe true
      invalidHotChocolateResult.right.get shouldEqual Message("Amount paid is missing 0.3")
    }
    "send back the beverages when amt paid is correct" in {
      // WHEN
      val validTeaResult = OrderService.isOrderValid(Tea(0), BigDecimal.valueOf(0.4))
      val validCoffeeResult = OrderService.isOrderValid(Coffee(0), BigDecimal.valueOf(0.6))
      val validHotChocolateResult = OrderService.isOrderValid(HotChocolate(0), BigDecimal.valueOf(0.5))

      // THEN
      validTeaResult.isLeft shouldBe true
      validTeaResult.left.get shouldEqual Tea(0)
      validCoffeeResult.isLeft shouldBe true
      validCoffeeResult.left.get shouldEqual Coffee(0)
      validHotChocolateResult.isLeft shouldBe true
      validHotChocolateResult.left.get shouldEqual HotChocolate(0)
    }
  }
}
