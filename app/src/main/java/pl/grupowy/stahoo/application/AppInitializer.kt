package pl.grupowy.stahoo.application

interface AppInitializer {
    fun initialize()
    interface InitCompletedListener {
        fun onInitCompleted()
    }
}