package com.hunyadym.controllers

import com.hunyadym.Mode
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.net.URL
import java.util.*

class Controller : Initializable {
    @FXML
    lateinit var image: ImageView

    private lateinit var lightsOn: Image
    private lateinit var lightsOff: Image
    private var lightState = false

    override fun initialize(location: URL?, resources: ResourceBundle?) {

    }

    fun start(mode: Mode) {
        loadLights(mode)


        Thread(Runnable {
            while (true) {
                Thread.sleep(400)
                Platform.runLater {
                    if (lightState) {
                        image.image = lightsOn
                        lightState = !lightState
                    } else {
                        image.image = lightsOff
                        lightState = !lightState
                    }
                }
            }
        }).start()
    }

    private fun loadLights(mode: Mode) {
        when (mode) {
            Mode.LEFT -> {
                lightsOn = Image(javaClass.getResource("izzo_bal_1.png").toURI().toString())
                lightsOff = Image(javaClass.getResource("izzo_bal_2.png").toURI().toString())
            }
            else -> {
                lightsOn = Image(javaClass.getResource("izzo_jobb_1.png").toURI().toString())
                lightsOff = Image(javaClass.getResource("izzo_jobb_2.png").toURI().toString())
            }
        }
    }
}