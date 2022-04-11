package net.noncore.xfd.views

import net.noncore.xfd.viewmodels.FolderViewModel
import net.noncore.xfd.viewmodels.ResourceTableItem
import tornadofx.View
import tornadofx.borderpane
import tornadofx.column
import tornadofx.tableview

class FolderView : View() {
    val vm: FolderViewModel by inject()
    override val root = borderpane {
        center = tableview(vm.resourceList) {
            column("Name", ResourceTableItem::name)
        }
    }
}
