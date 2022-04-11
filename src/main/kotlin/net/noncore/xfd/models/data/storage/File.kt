package net.noncore.xfd.models.data.storage

import java.io.InputStream
import java.io.OutputStream

interface File : Resource {
    val inputStream: InputStream
    val outputStream: OutputStream
    val size: Size
    fun copyTo(destination: Folder)
    fun moveTo(destination: Folder)
    fun delete()
}