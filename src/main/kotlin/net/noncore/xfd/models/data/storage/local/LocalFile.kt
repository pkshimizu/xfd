package net.noncore.xfd.models.data.storage.local

import net.noncore.xfd.models.data.storage.File
import net.noncore.xfd.models.data.storage.Folder
import net.noncore.xfd.models.data.storage.Size
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.nio.file.Path

internal class LocalFile(path: Path) : LocalResource(path), File {
    override val inputStream: InputStream
        get() = FileInputStream(file)
    override val outputStream: OutputStream
        get() = FileOutputStream(file)
    override val size: Size
        get() = Size(file.length())

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
