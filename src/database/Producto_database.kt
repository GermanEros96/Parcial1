package database

import data_class.Producto
import enum_class.TipoProducto

class Producto_database {
    private val productos = mutableListOf<Producto>()

    fun agregarProducto(producto: Producto) {
        productos.add(producto)
    }

    fun eliminarProducto(id: Int): Boolean {
        return productos.removeIf { it.id == id }
    }

    fun modificarProducto(id: Int, nuevoProducto: Producto): Boolean {
        val index = productos.indexOfFirst { it.id == id }
        return if (index != -1) {
            productos[index] = nuevoProducto
            true
        } else false
    }

    fun buscarPorNombre(nombre: String): List<Producto> {
        return productos.filter { it.nombre.contains(nombre, ignoreCase = true) }
    }

    fun buscarPorTipo(tipo: TipoProducto): List<Producto> {
        return productos.filter { it.tipo == tipo }
    }

    fun buscarPorPrecio(precio: Double): List<Producto> {
        return productos.filter { it.precio == precio }
    }

    fun listarTodos(): List<Producto> = productos.toList()
}