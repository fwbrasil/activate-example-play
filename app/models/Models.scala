package models

import net.fwbrasil.activate.storage.memory.MemoryStorage
import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.play.EntityForm
import java.util.Date

import computerPersistenceContext._

class Company(
	var name: String)
		extends Entity

class Computer(
	var name: String,
	var introduced: Option[Date],
	var discontinued: Option[Date],
	var company: Option[Company])
		extends Entity

/**
 * Helper for pagination.
 */
case class Page[A](items: Seq[A], page: Int, offset: Long, total: Long) {
	lazy val prev = Option(page - 1).filter(_ >= 0)
	lazy val next = Option(page + 1).filter(_ => (offset + items.size) < total)
}

object Computer {
	def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Page[(Computer, Option[Company])] = transactional {
		val navigator = paginatedQuery {
			(c: Computer) =>
				where(c.name isNotNull) select (c) orderBy {
					scala.math.abs(orderBy) match {
						case 3 =>
							if (orderBy < 0)
								c.introduced desc
							else
								c.introduced asc
						case 4 =>
							if (orderBy < 0)
								c.discontinued desc
							else
								c.discontinued asc
						case other =>
							if (orderBy < 0)
								c.name desc
							else
								c.name asc
					}
				}
		}.navigator(pageSize)
		if (navigator.numberOfResults > 0)
			Page(navigator.page(page).map(c => (c, c.company)), page, page * pageSize, navigator.numberOfResults)
		else
			Page(Nil, 0, 0, 0)
	}
}

object Company {

	/**
	 * Construct the Map[String,String] needed to fill a select options set.
	 */
	def options: Seq[(String, String)] = transactional {
		query {
			(company: Company) =>
				where(company isNotNull) select (company.id, company.name) orderBy (company.name)
		}
	}

}

