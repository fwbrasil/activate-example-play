package models

import net.fwbrasil.activate.storage.memory.TransientMemoryStorage
import net.fwbrasil.activate.ActivateContext

object computerPersistenceContext extends ActivateContext {
    val storage = new TransientMemoryStorage
}

