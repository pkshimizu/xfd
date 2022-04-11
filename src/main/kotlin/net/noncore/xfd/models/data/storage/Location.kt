package net.noncore.xfd.models.data.storage

import java.nio.file.Path
import kotlin.io.path.name

class Location(val path: String) {
    val name: String
        get() = Path.of(path).name
}