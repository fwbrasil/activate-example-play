package test

import models.computerPersistenceContext._
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import net.fwbrasil.activate.play.ActivatePlayTest

class ApplicationSpec extends SpecificationWithJUnit with ActivatePlayTest {

    import models._

    // -- Date helpers

    def dateIs(date: java.util.Date, str: String) = new java.text.SimpleDateFormat("yyyy-MM-dd").format(date) == str

    // --

    "Application" should {

        "redirect to the computer list on /" in {

            val result = controllers.Application.index(FakeRequest())

            status(result) must equalTo(SEE_OTHER)
            redirectLocation(result) must beSome.which(_ == "/computers")

        }

        "list computers on the the first page" inActivate {
            val result = controllers.Application.list(0, 2, "")(FakeRequest())

            status(result) must equalTo(OK)
            contentAsString(result) must contain("564 computers found")
        }

        "filter computer by name" inActivate {
            val result = controllers.Application.list(0, 2, "Apple")(FakeRequest())

            status(result) must equalTo(OK)
            contentAsString(result) must contain("12 computers found")
        }

        "create new computer" inActivate {
            val badResult = controllers.Application.save(FakeRequest())

            status(badResult) must equalTo(BAD_REQUEST)

            val apple = transactional {
                select[Company].where(_.name :== "Apple Inc.").head
            }

            val badDateFormat = controllers.Application.save(
                FakeRequest().withFormUrlEncodedBody("name" -> "FooBar", "introduced" -> "badbadbad", "company" -> apple.id))

            status(badDateFormat) must equalTo(BAD_REQUEST)
            contentAsString(badDateFormat) must contain("""selected>Apple Inc.</option>""")
            contentAsString(badDateFormat) must contain("""<input type="text" id="introduced" name="introduced" value="badbadbad" >""")
            contentAsString(badDateFormat) must contain("""<input type="text" id="name" name="name" value="FooBar" >""")

            val result = controllers.Application.save(
                FakeRequest().withFormUrlEncodedBody("name" -> "FooBar", "introduced" -> "2011-12-24", "company" -> apple.id))

            status(result) must equalTo(SEE_OTHER)
            redirectLocation(result) must beSome.which(_ == "/computers")
            flash(result).get("success") must beSome.which(_ == "Computer FooBar has been created")

            val list = controllers.Application.list(0, 2, "FooBar")(FakeRequest())

            status(list) must equalTo(OK)
            contentAsString(list) must contain("One computer found")
        }
    }
}