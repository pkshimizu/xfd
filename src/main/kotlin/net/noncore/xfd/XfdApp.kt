package net.noncore.xfd

import net.noncore.xfd.views.MainView
import net.noncore.xfd.views.Styles
import tornadofx.App
import tornadofx.launch

class XfdApp: App(MainView::class, Styles::class)

fun main() {
    launch<XfdApp>()
}
