package database

import data_class.Pedido

object Pedido_Database {
    private val pedidos = mutableListOf<Pedido>()

    fun agregarPedido(pedido: Pedido) {
        pedidos.add(pedido)
    }

    fun buscarPorClienteId(clienteId: Int): List<Pedido> {
        return pedidos.filter { it.client.id == clienteId }
    }

    fun listarPedidos(): List<Pedido> = pedidos.toList()
}