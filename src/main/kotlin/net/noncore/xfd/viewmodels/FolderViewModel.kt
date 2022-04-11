package net.noncore.xfd.viewmodels

import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleStringProperty
import net.noncore.xfd.models.data.storage.Folder
import net.noncore.xfd.models.data.storage.Location
import net.noncore.xfd.models.data.storage.Resource
import net.noncore.xfd.models.data.storage.local.LocalStorage
import tornadofx.ViewModel
import tornadofx.asObservable

class ResourceTableItem(resource: Resource) {
    val name = SimpleStringProperty(resource.location.name)
}

class FolderViewModel : ViewModel() {
    val resourceList = SimpleListProperty<ResourceTableItem>()
    init {
        val root = LocalStorage().find(Location("/"))
        if (root is Folder) {
            resourceList.set(root.resources().map { ResourceTableItem(it) }.asObservable())
        }
    }
}