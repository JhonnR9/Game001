import java.awt.Dimension
import java.awt.Toolkit

class GameConstants {

    companion object {
        private val screen: Dimension = Toolkit.getDefaultToolkit().screenSize
        private const val scale = 0.5
        private  val width = (screen.width* scale).toInt()
        private val height = (screen.height* scale).toInt()

        val dimension = Dimension(width, height)


    }

}