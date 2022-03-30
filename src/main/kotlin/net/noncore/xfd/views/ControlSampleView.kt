package net.noncore.xfd.views

import tornadofx.*

class ControlSampleView: Fragment() {
    override val root = vbox() {
        label("Control Samples")
        hbox() {
            label("Button")
            button("Button")
        }
    }
}