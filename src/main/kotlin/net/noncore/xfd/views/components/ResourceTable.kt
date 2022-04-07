package net.noncore.xfd.views.components

import net.noncore.xfd.models.data.storage.Resource
import tornadofx.*

class ResourceTable: View() {
    override val root = tableview(listOf<Resource>().asObservable())
}
