package au.com.nig.coffeemachine.model

import org.scalatest.WordSpec

class BeveragesTest extends WordSpec {
  "function makeBeverage" should {
    "make a tea when order starts with letter T" in {
      // WHEN
      val result = Beverages.getType(Request("T::"))

      // THEN
      result match {
        case Tea(_, _, _) => succeed
        case _ => fail("This is not a tea therefore it is wrong")
      }
    }
    "make a Coffee when order starts with letter C" in {
      // WHEN
      val result = Beverages.getType(Request("C::"))

      // THEN
      result match {
        case Coffee(_, _, _) => succeed
        case _ => fail("This is not a Coffee therefore it is wrong")
      }
    }
    "make a HotChocolate when order starts with letter H" in {
      // WHEN
      val result = Beverages.getType(Request("H::"))

      // THEN
      result match {
        case HotChocolate(_, _, _) => succeed
        case _ => fail("This is not a HotChocolate therefore it is wrong")
      }
    }
    "make a tea with the accurate number of sugars and stick" in {
      // WHEN
      val result = Beverages.getType(Request("T:1:0"))

      // THEN
      result match {
        case Tea(1, true, _) => succeed
        case _ => fail("This is not a tea with one sugar a stick therefore it is wrong")
      }
    }
    "make a Coffee with the accurate number of sugars and stick" in {
      // WHEN
      val result = Beverages.getType(Request("C::"))

      // THEN
      result match {
        case Coffee(0, false, _) => succeed
        case _ => fail("This is not a Coffee with 0 sugar and 0 stick therefore it is wrong")
      }
    }
    "make a HotChocolate with the accurate number of sugars and stick" in {
      // WHEN
      val result = Beverages.getType(Request("H:2:0"))

      // THEN
      result match {
        case HotChocolate(2, true, _) => succeed
        case _ => fail("This is not a HotChocolate with 2 sugars and a stick therefore it is wrong")
      }
    }
  }
}
