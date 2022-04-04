package net.noncore.xfd.views

import javafx.application.Platform
import javafx.collections.FXCollections
import javafx.scene.input.KeyCombination
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*
import java.time.LocalDate
import kotlin.concurrent.thread

class ControlSampleView: Fragment() {
    val comboboxItems = FXCollections.observableArrayList("Tokyo", "Osaka", "Nagoya", "Sapporo", "Fukuoka")
    override val root = vbox() {
        label("Control Samples")
        vbox {
            label("Buttons")
            button("Button")
        }
        vbox {
            label("Labels")
            label("Blue Label") {
                textFill = Color.BLUE
            }
            label("Red Label") {
                textFill = Color.RED
            }
        }
        vbox {
            label("Text Fields")
            textfield()
            label("Password Field"){
                addClass(Styles.caption)
            }
            passwordfield()
        }
        vbox {
            label("Check Boxies")
            checkbox("同意する")
        }
        vbox {
            label("ComboBox")
            combobox<String> {
                items = comboboxItems
            }
        }
        vbox {
            label("Toggle Buttons")
            togglebutton {
                val state = selectedProperty().stringBinding {
                    if (it == true) "ON" else "OFF"
                }
                textProperty().bind(state)
            }
            hbox {
                togglegroup {
                    togglebutton("One")
                    togglebutton("Two")
                    togglebutton("Three")
                }
            }
        }
        vbox {
            label("Radio Buttons")
            hbox {
                togglegroup {
                    radiobutton("One")
                    radiobutton("Two")
                    radiobutton("Three")
                }
            }
        }
        vbox {
            label("Date Picker")
            datepicker {
                value = LocalDate.now()
            }
        }
        vbox {
            label("Text Area")
            textarea("なにか入力してください")
        }
        vbox {
            label("Progress Bar")
            progressbar {
                thread {
                    for (i in 1..100) {
                        Platform.runLater { progress = i.toDouble() / 100.0 }
                        Thread.sleep(100)
                    }
                }
            }
            progressindicator {
                thread {
                    for (i in 1..100) {
                        Platform.runLater { progress = i.toDouble() / 100.0 }
                        Thread.sleep(100)
                    }
                }
            }
        }
        vbox {
            label("Image View")
            imageview("samples/neko.jpg")
        }
        vbox {
            label("Scroll Pane")
            scrollpane {
                imageview("samples/neko.jpg")
            }
        }
        vbox {
            label("Hyperlink")
            hyperlink("Hyper Link").action {
                println("click link!!")
            }
        }
        vbox {
            label("Text")
            text("Text1\nText2\tText3") {
                font = Font(18.0)
            }
            textflow {
                text("Tornado") {
                    fill = Color.PURPLE
                    font = Font(20.0)
                }
                text("FX") {
                    fill = Color.ORANGE
                    font = Font(28.0)
                }
            }
        }
        vbox {
            label("Tooltip")
            button("Show Tooltip") {
                tooltip("このボタンを押したら何が起きるか表示する")
            }
        }
        vbox {
            label("Shortcut")
            label("Ctrl+Y")
            shortcut(KeyCombination.valueOf("Ctrl+Y")) {
                println("Action Ctrl+Y")
            }
            shortcut(KeyCombination.valueOf("Y")) {
                println("Action Y")
            }
        }
    }
}
