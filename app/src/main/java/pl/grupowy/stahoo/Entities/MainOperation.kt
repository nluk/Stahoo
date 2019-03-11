package pl.grupowy.stahoo.Entities

import java.util.*

class MainOperation : BasicOperation(){

    var targetId:Int = 0
    var name: String = ""
    var description: String = ""
    var isCyclical: Boolean = false
    var isDivided: Boolean = false
    var dateTime: Date = Date()
}