package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import views._
import models._
import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.play.EntityForm
import net.fwbrasil.activate.play.EntityForm._
import java.util.Date
import models.computerPersistenceContext._

/**
 * Manage a database of computers
 */
object Application extends Controller {

	/**
	 * This result directly redirect to the application home.
	 */
	val Home = Redirect(routes.Application.list(0, 2, ""))

	/**
	 * Describe the computer form (used in both edit and create screens).
	 */
	val computerForm =
		EntityForm[Computer](
			_.name -> nonEmptyText,
			_.introduced -> optional(date("yyyy-MM-dd")),
			_.discontinued -> optional(date("yyyy-MM-dd")),
			_.company -> optional(entity[Company]))

	// -- Actions

	/**
	 * Handle default path requests, redirect to computers list
	 */
	def index = Action { Home }

	/**
	 * Display the paginated list of computers.
	 *
	 * @param page Current page number (starts from 0)
	 * @param orderBy Column to be sorted
	 * @param filter Filter applied on computer names
	 */
	def list(page: Int, orderBy: Int, filter: String) = Action { implicit request =>
		transactional {
			Ok(html.list(
				Computer.list(page = page, orderBy = orderBy, filter = ("*" + filter + "*")),
				orderBy, filter))
		}
	}
	//
	/**
	 * Display the 'edit form' of a existing Computer.
	 *
	 * @param id Id of the computer to edit
	 */
	def edit(id: String) = Action {
		transactional {
			byId[Computer](id).map { computer =>
				Ok(html.editForm(id, computerForm.fillWith(computer)))
			}
		}.getOrElse(NotFound)
	}

	/**
	 * Handle the 'edit form' submission
	 *
	 * @param id Id of the computer to edit
	 */
	def update(id: String) = Action { implicit request =>
		transactional {
			computerForm.bindFromRequest.fold(
				formWithErrors => BadRequest(html.editForm(id, formWithErrors)),
				computerData => {
					val computer = computerData.updateEntity(id)
					Home.flashing("success" -> "Computer %s has been updated".format(computer.name))
				})
		}
	}

	/**
	 * Display the 'new computer form'.
	 */
	def create = Action {
		transactional {
			Ok(html.createForm(computerForm))
		}
	}

	/**
	 * Handle the 'new computer form' submission.
	 */
	def save = Action { implicit request =>
		transactional {
			computerForm.bindFromRequest.fold(
				formWithErrors => BadRequest(html.createForm(formWithErrors)),
				computerData => {
					val computer = computerData.createEntity
					Home.flashing("success" -> "Computer %s has been created".format(computer.name))
				})
		}
	}

	/**
	 * Handle computer deletion.
	 */
	def delete(id: String) = Action {
		transactional {
			byId[Computer](id).get.delete
			Home.flashing("success" -> "Computer has been deleted")
		}
	}

}
