package models

import net.fwbrasil.activate.storage.memory.MemoryStorage
import net.fwbrasil.activate.ActivateContext

object computerPersistenceContext extends ActivateContext {
	def contextName = "computerPersistenceContext"
	val storage = new MemoryStorage
}