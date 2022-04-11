package net.noncore.xfd.models.data.storage.local

import net.noncore.xfd.models.data.storage.Folder
import net.noncore.xfd.models.data.storage.Location
import net.noncore.xfd.models.data.storage.Resource
import java.io.File
import java.nio.file.Path
import java.nio.file.attribute.FileTime
import java.time.ZoneId
import java.time.ZonedDateTime

internal abstract class LocalResource(path: Path) : Resource {
    protected val file = File(path.toString())

    override val location: Location
        get() = Location(file.path)
    override val parent: Folder?
        get() = if (file.isRooted) null else LocalFolder(file.parentFile.toPath())
    override val readable: Boolean
        get() = file.canRead()
    override val writable: Boolean
        get() = file.canWrite()
    override val executable: Boolean
        get() = file.canExecute()
    override val hidden: Boolean
        get() = file.isHidden
    override val exists: Boolean
        get() = file.exists()
    override val updatedAt: ZonedDateTime
        get() = ZonedDateTime.ofInstant(FileTime.fromMillis(file.lastModified()).toInstant(), ZoneId.systemDefault())
}