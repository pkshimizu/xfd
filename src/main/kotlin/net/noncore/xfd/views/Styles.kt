package net.noncore.xfd.views

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

val normalFontSize = 18.px
val smallFontSize = normalFontSize * 0.8
val largeFontSize = normalFontSize * 1.2
val xLargeFontSize = normalFontSize * 1.4

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val caption by cssclass()
    }
    init {
        label and heading {
            padding = box(10.px)
            fontSize = xLargeFontSize
            fontWeight = FontWeight.BOLD
        }
        label and caption {
            fontSize = smallFontSize
            fontWeight = FontWeight.BOLD
        }
        label {
            fontSize = normalFontSize
        }
        button {
            fontSize = normalFontSize
            fontWeight = FontWeight.BOLD
        }
        textField {
            fontSize = normalFontSize
        }
        checkBox {
            fontSize = normalFontSize
        }
        comboBox {
            fontSize = normalFontSize
        }
        toggleButton {
            fontSize = normalFontSize
        }
        radioButton {
            fontSize = normalFontSize
        }
        progressIndicator {
            fontSize = normalFontSize
        }
        hyperlink {
            fontSize = normalFontSize
        }
        text {
            fontSize = normalFontSize
        }
    }
}