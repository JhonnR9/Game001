class Game : Runnable {
    private var isRunning = true
    private lateinit var thread: Thread
    private val window = Window()


    override fun run() {
        var lastTime = System.nanoTime()
        val amountOfTicks = 60.0
        val ns = 1000000000 / amountOfTicks
        var delta = 0.0
        var frames = 0
        var timer = System.currentTimeMillis()

        while (isRunning) {
            val now = System.nanoTime()
            delta += (now - lastTime) / ns
            lastTime = now

            if (delta >= 1) {
                window.update()
                window.render()
                frames++
                delta--
            }
            if (System.currentTimeMillis() - timer >= 1000) {
                println("$frames")
                frames = 0
                timer = System.currentTimeMillis()

            }
        }

        stop()
    }

    @Synchronized
    fun start() {
        thread = Thread(this)
        isRunning = true
        thread.start()
    }

    @Synchronized
   private fun stop() {
        isRunning = false
        thread.join()
    }




}
