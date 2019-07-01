package au.com.nig.coffeemachine

import org.scalatest.{Matchers, WordSpec}

class BaristaTest extends WordSpec with Matchers {

  "function makeBeverage" should {
    "make a tea when order starts with letter T" in {
      // WHEN
      val result = Barista.makeBeverage("T::")

      // THEN
      result match {
        case Tea(_, _) => succeed
        case _ => fail("This is not a tea therefore it is wrong")
      }
    }
    "make a Coffee when order starts with letter C" in {
      // WHEN
      val result = Barista.makeBeverage("C::")

      // THEN
      result match {
        case Coffee(_, _) => succeed
        case _ => fail("This is not a Coffee therefore it is wrong")
      }
    }
    "make a HotChocolate when order starts with letter H" in {
      // WHEN
      val result = Barista.makeBeverage("H::")

      // THEN
      result match {
        case HotChocolate(_, _) => succeed
        case _ => fail("This is not a HotChocolate therefore it is wrong")
      }
    }
    "display a Message when order starts with letter M" in {
      // WHEN
      val result = Barista.makeBeverage("M::")

      // THEN
      result match {
        case Message(_) => succeed
        case _ => fail("This is not a Message therefore it is wrong")
      }
    }
    "make a tea with the accurate number of sugars and stick" in {
      // WHEN
      val result = Barista.makeBeverage("T:1:0")

      // THEN
      result match {
        case Tea(1, true) => succeed
        case _ => fail("This is not a tea with one sugar a stick therefore it is wrong")
      }
    }
    "make a Coffee with the accurate number of sugars and stick" in {
      // WHEN
      val result = Barista.makeBeverage("C::")

      // THEN
      result match {
        case Coffee(0, false) => succeed
        case _ => fail("This is not a Coffee with 0 sugar and 0 stick therefore it is wrong")
      }
    }
    "make a HotChocolate with the accurate number of sugars and stick" in {
      // WHEN
      val result = Barista.makeBeverage("H:2:0")

      // THEN
      result match {
        case HotChocolate(2, true) => succeed
        case _ => fail("This is not a HotChocolate with 2 sugars and a stick therefore it is wrong")
      }
    }
    "display a Message with its content" in {
      // WHEN
      val result = Barista.makeBeverage("M:Content blabla")

      // THEN
      result match {
        case Message("Content blabla") => succeed
        case _ => fail("This is not a Message therefore it is wrong")
      }
    }
  }
}
