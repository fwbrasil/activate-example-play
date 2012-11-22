package models

import net.fwbrasil.activate.storage.memory.TransientMemoryStorage
import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.entity.EntityHelper
import net.fwbrasil.activate.migration.Migration
import net.fwbrasil.activate.storage.relational.PooledJdbcRelationalStorage
import net.fwbrasil.activate.storage.relational.idiom.mySqlDialect

object computerPersistenceContext extends ActivateContext {
	val storage = new PooledJdbcRelationalStorage {
		val jdbcDriver = "com.mysql.jdbc.Driver"
		val user = "root"
		val password = ""
		val url = "jdbc:mysql://127.0.0.1/computer"
		val dialect = mySqlDialect
	}
}

