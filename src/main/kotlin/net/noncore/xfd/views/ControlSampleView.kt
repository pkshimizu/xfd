package net.noncore.xfd.views

import javafx.application.Platform
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.control.SelectionMode
import javafx.scene.control.TreeItem
import javafx.scene.input.KeyCombination
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*
import java.time.LocalDate
import java.time.Period
import kotlin.concurrent.thread

class ControlSampleView : Fragment() {
    val comboboxItems = FXCollections.observableArrayList("Tokyo", "Osaka", "Nagoya", "Sapporo", "Fukuoka")
    override val root = vbox {
        label("Control Samples")
        scrollpane {
            vbox {
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
                    label("Password Field") {
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
                vbox {
                    label("List View")
                    listview(listOf("AAA", "BBB", "CCC", "DDD", "EEE").asObservable()) {
                        selectionModel.selectionMode = SelectionMode.MULTIPLE

                    }
                }
                vbox {
                    label("Table View")
                    tableview(
                        listOf(
                            Person(1, "Samantha Stuart", LocalDate.of(1981, 12, 4)),
                            Person(2, "Tom Marks", LocalDate.of(2005, 1, 23)),
                            Person(3, "Stuart Gills", LocalDate.of(1989, 5, 23)),
                            Person(4, "Nicole Williams", LocalDate.of(1998, 8, 11))
                        ).asObservable()
                    ) {
                        isEditable = true
                        column("ID", Person::idProperty).makeEditable()
                        column("Name", Person::nameProperty).makeEditable()
                        column("Birthday", Person::birthdayProperty).makeEditable()
                        readonlyColumn("Age", Person::ageProperty).cellFormat {
                            text = it.value.toString()
                            style {
                                if (it.value!! < 18) {
                                    backgroundColor += c("#8b0000")
                                    textFill = Color.WHITE
                                } else {
                                    backgroundColor += Color.WHITE
                                    textFill = Color.BLACK
                                }
                            }
                        }
                    }
                }
                vbox {
                    label("Tree View")
                    treeview<String> {
                        root = TreeItem("Root")
                        populate { parent ->
                            if (parent == root) listOf("AAA", "BBB", "CCC") else listOf()
                        }
                    }
                }
            }
        }
    }
}

class Person(id: Int, name: String, birthday: LocalDate) {
    val idProperty = SimpleIntegerProperty(id)
    var id by idProperty

    val nameProperty = SimpleStringProperty(name)
    var name by nameProperty

    val birthdayProperty = SimpleObjectProperty(birthday)
    var birthday by birthdayProperty

    // Make age an observable value as well
    val ageProperty = birthdayProperty.objectBinding { Period.between(it, LocalDate.now()).years }
}
