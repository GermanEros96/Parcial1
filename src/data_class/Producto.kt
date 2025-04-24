package data_class
import enum_class.TipoProducto

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Float,
    val tipo: TipoProducto


)
