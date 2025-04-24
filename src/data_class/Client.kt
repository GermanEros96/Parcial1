package data_class


data class Client(
    val id: Int,
    val nombre: String,
    val telefono: String,
    val email: String,
    val constraseña : String,
    val pedidos: MutableList<Pedido> = mutableListOf()
)




