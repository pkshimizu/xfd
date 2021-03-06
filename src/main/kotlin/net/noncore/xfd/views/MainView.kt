package net.noncore.xfd.views

import tornadofx.*

class MainView : View("Hello TornadoFX") {
    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
        button("Open Control Sample View") {
            action {
                find<ControlSampleView>().openModal()
            }
        }
    }
}
