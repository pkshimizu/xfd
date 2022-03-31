package net.noncore.xfd.views

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val caption by cssclass()
    }
    init {
        label and heading {
            padding = box(10.px)
            fontSize = 24.px
            fontWeight = FontWeight.BOLD
        }
        label and caption {
            fontSize = 14.px
            fontWeight = FontWeight.BOLD
        }
        label {
            fontSize = 18.px
        }
        button {
            fontSize = 18.px
            fontWeight = FontWeight.BOLD
        }
        textField {
            fontSize = 18.px
        }
        checkBox {
            fontSize = 18.px
        }
        comboBox {
            fontSize = 18.px
        }
        toggleButton {
            fontSize = 18.px
        }
        radioButton {
            fontSize = 18.px
        }
    }
}