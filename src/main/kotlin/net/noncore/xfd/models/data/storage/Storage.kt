package net.noncore.xfd.models.data.storage

interface Storage {
    fun find(location: Location): Resource
    fun roots(): List<Folder>
}
