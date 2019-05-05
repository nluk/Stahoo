package pl.grupowy.stahoo.interfaces

interface AppInitializer {
    fun initialize()
    interface InitCompletedListner{
         fun onInitCompleted()
    }
}