package pl.grupowy.stahoo.Entities


import java.util.*

//

open class BasicOperation{
    var id:Int = 0
    var sourceId:Int = 0
    var amount: Float = 0.0f
    var type:OperationType = OperationType.INCOME
}