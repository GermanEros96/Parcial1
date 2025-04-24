package database

import data_class.Product
import enum_class.TipoProducto

object Producto_Database {
    private val products = mutableListOf<Product>()

    fun agregarProducto(product: Product) {
        products.add(product)
    }

    fun eliminarProducto(id: Int): Boolean {
        return products.removeIf { it.id == id }
    }

    fun modificarProducto(id: Int, nuevoProduct: Product): Boolean {
        val index = products.indexOfFirst { it.id == id }
        return if (index != -1) {
            products[index] = nuevoProduct
            true
        } else false
    }

    fun buscarPorNombre(nombre: String): List<Product> {
        return products.filter { it.nombre.contains(nombre, ignoreCase = true) }
    }

    fun buscarPorTipo(tipo: TipoProducto): List<Product> {
        return products.filter { it.tipo == tipo }
    }

    fun buscarPorPrecio(precio: Float): List<Product> {
        return products.filter { it.precio == precio }
    }

    fun listarTodos(): List<Product> = products.toList()
}