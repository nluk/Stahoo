package pl.grupowy.stahoo.Entities


import java.util.*



open class BaseOperation{
    var id:Int = 0
    var fromId:Int = 0
    var toId:Int = 0
    var amount: Float = 0.0f
    var dateTime: Date = Date()
    var type:OperationType = OperationType.INCOME

}