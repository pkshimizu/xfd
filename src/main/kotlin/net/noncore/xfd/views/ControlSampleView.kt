package net.noncore.xfd.views

import javafx.collections.FXCollections
import javafx.scene.paint.Color
import tornadofx.*

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
    }
}
