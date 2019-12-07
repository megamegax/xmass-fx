package com.hunyadym

import com.hunyadym.controllers.Controller
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.geometry.Rectangle2D
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Screen
import javafx.stage.Stage
import javafx.stage.StageStyle
import java.io.InputStream
import java.util.stream.Stream

class Main : Application() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }

    override fun start(primaryStage: Stage) {
        initWindow(Mode.LEFT, Stage())
        initWindow(Mode.RIGHT, Stage())
    }

    private fun initWindow(mode: Mode, primaryStage: Stage) {
        val primaryScreenBounds = Screen.getPrimary().visualBounds
        var root: Parent
        var controller: Controller

        FXMLLoader().also {
            root = it.load(javaClass.getResource("light.fxml").openStream())
            controller = it.getController<Controller>()
        }

        controller.start(mode)

        setupScreen(root, primaryStage, mode, primaryScreenBounds)

    }

    private fun setupScreen(root: Parent, primaryStage: Stage, mode: Mode, primaryScreenBounds: Rectangle2D) {
        val windowScene = Scene(root, 200.0, 100.0).apply { fill = null }
        with(primaryStage) {
            scene = windowScene
            isAlwaysOnTop = true
            initStyle(StageStyle.UNDECORATED)
            initStyle(StageStyle.TRANSPARENT)
            x = if (mode == Mode.LEFT) 0.0 else primaryScreenBounds.maxX - windowScene.width
            y = 0.0
            show()
        }
    }
}