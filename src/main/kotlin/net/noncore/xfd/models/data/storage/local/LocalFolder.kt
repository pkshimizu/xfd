package net.noncore.xfd.models.data.storage.local

import net.noncore.xfd.models.data.storage.File
import net.noncore.xfd.models.data.storage.Folder
import net.noncore.xfd.models.data.storage.Resource
import net.noncore.xfd.models.data.storage.Size
import java.nio.file.Path
import java.nio.file.Paths

internal class LocalFolder(path: Path) : LocalResource(path), Folder {
    override fun resources(): List<Resource> {
        return file.listFiles().map {
            when {
                it.isFile -> LocalFile(it.toPath())
                it.isFile -> LocalFolder(it.toPath())
                else -> throw UnsupportedOperationException()
            }
        }.toList()
    }

    override fun createFolder(name: String): Folder {
        val path = Paths.get(file.path, name)
        path.toFile().mkdirs()
        return LocalFolder(path)
    }

    override fun createFile(name: String): File {
        val path = Paths.get(file.path, name)
        path.toFile().createNewFile()
        return LocalFile(path)
    }

    override fun calcSize(): Size {
        return Size(file.listFiles().filter { it.isFile }.map { it.length() }.sum())
    }

    override fun copyTo(destination: Folder) {
        TODO("Not yet implemented")
    }

    override fun moveTo(destination: Folder) {
        TODO("Not yet implemented")
    }

    override fun delete() {
        file.delete()
    }
}