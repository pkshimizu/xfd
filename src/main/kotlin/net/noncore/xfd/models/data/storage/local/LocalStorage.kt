package net.noncore.xfd.models.data.storage.local

import net.noncore.xfd.models.data.storage.Folder
import net.noncore.xfd.models.data.storage.Location
import net.noncore.xfd.models.data.storage.Resource
import net.noncore.xfd.models.data.storage.Storage
import java.io.File
import java.nio.file.Path
import kotlin.io.path.isDirectory

class LocalStorage : Storage {
    override fun find(location: Location): Resource {
        val path = Path.of(location.path)
        if (path.isDirectory()) {
            return LocalFolder(path)
        }
        return LocalFile(path)
    }

    override fun roots(): List<Folder> {
        return File.listRoots().map {
            LocalFolder(it.toPath())
        }
    }
}