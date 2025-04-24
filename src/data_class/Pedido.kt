package data_class
import enum_class.EstadoPedido

data class Pedido(
    val id: Int,
    val cliente: Cliente,
    val productos: List<Producto>,
    val fecha: String,
    var estado: EstadoPedido,
    var total: Float = 0f
)
/*{
    fun calcularTotal() {
        total = productos.sumOf { it.precio }
    }
}*/