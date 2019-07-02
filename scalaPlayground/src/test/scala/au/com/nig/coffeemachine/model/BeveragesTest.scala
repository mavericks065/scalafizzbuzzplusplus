package au.com.nig.coffeemachine.model

import org.scalatest.WordSpec

class BeveragesTest extends WordSpec {
  "function makeBeverage" should {
    "make a tea when order starts with letter T" in {
      // WHEN
      val result = Beverages.getType(Request("T::"))

      // THEN
      result match {
        case Tea(_, _, _, _) => succeed
        case _ => fail("This is not a tea therefore it is wrong")
      }
    }
    "make a Coffee when order starts with letter C" in {
      // WHEN
      val result = Beverages.getType(Request("C::"))

      // THEN
      result match {
        case Coffee(_, _, _, _) => succeed
        case _ => fail("This is not a Coffee therefore it is wrong")
      }
    }
    "make a HotChocolate when order starts with letter H" in {
      // WHEN
      val result = Beverages.getType(Request("H::"))

      // THEN
      result match {
        case HotChocolate(_, _, _, _) => succeed
        case _ => fail("This is not a HotChocolate therefore it is wrong")
      }
    }
    "make a tea with the accurate number of sugars and stick" in {
      // WHEN
      val result = Beverages.getType(Request("T:1:0"))

      // THEN
      result match {
        case Tea(1, true, _, _) => succeed
        case _ => fail("This is not a tea with one sugar a stick therefore it is wrong")
      }
    }
    "make a Coffee with the accurate number of sugars and stick" in {
      // WHEN
      val result = Beverages.getType(Request("C::"))

      // THEN
      result match {
        case Coffee(0, false, _, _) => succeed
        case _ => fail("This is not a Coffee with 0 sugar and 0 stick therefore it is wrong")
      }
    }
    "make a HotChocolate with the accurate number of sugars and stick" in {
      // WHEN
      val result = Beverages.getType(Request("H:2:0"))

      // THEN
      result match {
        case HotChocolate(2, true, _, _) => succeed
        case _ => fail("This is not a HotChocolate with 2 sugars and a stick therefore it is wrong")
      }
    }
    "make an orange juice" in {
      // WHEN
      val result = Beverages.getType(Request("O::"))

      // THEN
      result match {
        case OrangeJuice(_) => succeed
        case _ => fail("This is not an orange juice")
      }
    }
    "make extrahot the drinks if the second letter is an h" in {
      // WHEN
      val extraHotChocolateResult = Beverages.getType(Request("Hh:2:0"))
      val extraHotTeaResult = Beverages.getType(Request("Th:2:0"))
      val extraCoffeeResult = Beverages.getType(Request("Ch:2:0"))

      // THEN
      extraHotChocolateResult match {
        case HotChocolate(2, true, true, _) => succeed
        case _ => fail("This is not an EXTRAHOT HotChocolate with 2 sugars and a stick therefore it is wrong")
      }
      extraHotTeaResult match {
        case Tea(2, true, true, _) => succeed
        case _ => fail("This is not an EXTRAHOT Tea with 2 sugars and a stick therefore it is wrong")
      }
      extraCoffeeResult match {
        case Coffee(2, true, true, _) => succeed
        case _ => fail("This is not an EXTRAHOT Coffee with 2 sugars and a stick therefore it is wrong")
      }
    }
  }
}
