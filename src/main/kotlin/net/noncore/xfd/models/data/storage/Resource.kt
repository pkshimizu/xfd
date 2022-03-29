package net.noncore.xfd.models.data.storage

import java.time.ZonedDateTime

interface Resource {
    val location: Location
    val parent: Folder?
    val readable: Boolean
    val writable: Boolean
    val executable: Boolean
    val hidden: Boolean
    val exists: Boolean
    val updatedAt: ZonedDateTime
}
