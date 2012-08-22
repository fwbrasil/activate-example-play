package models

import net.fwbrasil.activate.storage.memory.TransientMemoryStorage
import net.fwbrasil.activate.ActivateContext

object computerPersistenceContext extends ActivateContext {
	def contextName = "computerPersistenceContext"
	val storage = new TransientMemoryStorage
}