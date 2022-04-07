package net.noncore.xfd

import net.noncore.xfd.views.FolderView
import net.noncore.xfd.views.Styles
import tornadofx.App
import tornadofx.launch

class XfdApp: App(FolderView::class, Styles::class)

fun main() {
    launch<XfdApp>()
}
