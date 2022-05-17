package design_pattern

fun main() {
    val seller = NikeShoeSeller()
    val buyer = ShoesMaterialBuyer()
    val nikeShoesStore = Store(seller, buyer)
    nikeShoesStore.buy()
    nikeShoesStore.sell()
}

class NikeShoeSeller : Seller {
    override fun sell() {
        println("sell Nike Shoes")
    }
}

class ShoesMaterialBuyer : Buyer {
    override fun buy() {
        println("buy shoes' materials")
    }
}
interface Seller {
    fun sell()
}

interface Buyer {
    fun buy()
}

class Store(seller: Seller, buyer: Buyer): Seller by seller, Buyer by buyer