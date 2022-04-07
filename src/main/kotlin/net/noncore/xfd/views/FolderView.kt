package net.noncore.xfd.views

import net.noncore.xfd.views.components.ResourceTable
import tornadofx.*

class FolderView : View() {
    val resourceTable: ResourceTable by inject()
    override val root = borderpane {
        center = resourceTable.root
    }
}
