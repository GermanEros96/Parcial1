package data_class


data class Cliente(
    val id: Int,
    val nombre: String,
    val telefono: String,
    val email: String,
    val pedidos: MutableList<Pedido> = mutableListOf()
)




