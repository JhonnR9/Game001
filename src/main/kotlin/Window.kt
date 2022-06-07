import GameConstants.Companion.dimension
import java.awt.Canvas
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.image.BufferStrategy
import java.awt.image.BufferedImage
import javax.swing.JFrame

class Window : Canvas() {
    private val jFrame: JFrame = JFrame()
    private var image: BufferedImage

    init {
        initFrame()
        image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    }

    private fun initFrame() {
        jFrame.title = "Game001"
        jFrame.preferredSize = dimension
        jFrame.add(this)
        jFrame.isResizable = false
        jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        jFrame.isVisible = true
        jFrame.pack()
        jFrame.setLocationRelativeTo(null)

    }
    private fun clearScreen(g: Graphics) {
        graphics.color = Color.GRAY
        graphics.fillRect(0, 0, width, height)
    }

    private fun createBufferStrategy(): BufferStrategy {
        if (bufferStrategy == null) {
            createBufferStrategy(3)
        }
        return bufferStrategy

    }


    fun update() {

    }

    fun render() {
        val bs = createBufferStrategy()
        var g = image.graphics
        clearScreen(g)
        //render yours objects here




        //***//
        g.dispose()
        g = bs.drawGraphics
        g.drawImage(image, 0, 0, width, height, null)
        bs.show()
    }

}