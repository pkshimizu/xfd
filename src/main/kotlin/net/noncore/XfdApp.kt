package net.noncore

import net.noncore.views.MainView
import tornadofx.App
import tornadofx.launch

class XfdApp: App(MainView::class, Styles::class)

fun main() {
    launch<XfdApp>()
}
