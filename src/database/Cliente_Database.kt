package database

import data_class.Client

object Cliente_Database {
    private val clients = mutableListOf<Client>()

    fun agregarCliente(client: Client) {
        clients.add(client)
    }

    fun eliminarCliente(id: Int): Boolean {
        return clients.removeIf { it.id == id }
    }

    fun buscarPorNombre(nombre: String): List<Client> {
        return clients.filter { it.nombre.contains(nombre, ignoreCase = true) }
    }

    fun buscarPorId(id: Int): Client? {
        return clients.find { it.id == id }
    }

    fun listarTodos(): List<Client> = clients.toList()

    // NUEVAS FUNCIONES

    fun emailExiste(email: String): Boolean {
        return clients.any { it.email.equals(email, ignoreCase = true) }
    }

    fun idExiste(id: Int): Boolean {
        return clients.any { it.id == id }
    }

    fun clienteYaExiste(nombre: String, telefono: String): Boolean {
        return clients.any {
            it.nombre.equals(nombre, ignoreCase = true) &&
                    it.telefono == telefono
        }
    }
}

