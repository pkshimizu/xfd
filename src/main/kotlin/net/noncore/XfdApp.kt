package net.noncore

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.StackPane

class XfdApp : Application() {

    override fun start(primaryStage: Stage) {
        val btn = Button()
        btn.text = "Button"
        btn.onAction = EventHandler<ActionEvent> { println("Hello World!") }

        val root = StackPane()
        root.children.add(btn)

        val scene = Scene(root, 300.0, 250.0)
        primaryStage.title = "Hello World!"
        primaryStage.scene = scene
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(XfdApp::class.java, *args)
}
