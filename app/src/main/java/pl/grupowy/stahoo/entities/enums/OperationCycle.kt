package pl.grupowy.stahoo.entities.enums

enum class OperationCycle(val cycleType: Int) {
    SINGLE(0),
    EVERYDAY(1),
    EVERY_WEEK(2),
    EVERY_MONTH(3)
}