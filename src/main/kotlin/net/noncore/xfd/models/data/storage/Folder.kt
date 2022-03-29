package net.noncore.xfd.models.data.storage

interface Folder: Resource {
    fun resources(): List<Resource>
    fun createFolder(name: String): Folder
    fun createFile(name: String): File
    fun calcSize(): Size
    fun copyTo(destination: Folder)
    fun moveTo(destination: Folder)
    fun delete()
}