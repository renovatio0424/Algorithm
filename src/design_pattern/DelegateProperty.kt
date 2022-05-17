package design_pattern

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.observable("<no name>") {
            prop, old, new ->
        prop.name
        println("prop: $prop")
        println("$old -> $new")
    }
}

fun main() {
//    val user = design_pattern.User()
//    user.name = "first"
//    user.name = "second"
    val delegateClass = ClassWithDelegate(50)
    val myClass = MyClass(10, delegateClass)
    println(myClass.memberInt)
    println(myClass.delegatedToMember)
    println(topLevelInt)
    println(myClass.delegatedToTopLevel)
    println(delegateClass.anotherClassInt)
    println(myClass.delegatedToAnotherClass)
    println(myClass.extDelegated)
}

var topLevelInt: Int = 0
class ClassWithDelegate(val anotherClassInt: Int)

class MyClass(var memberInt: Int, val anotherClassInstance: ClassWithDelegate) {
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt

    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
}
var MyClass.extDelegated: Int by ::topLevelInt
