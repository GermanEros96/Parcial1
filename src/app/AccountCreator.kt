package app

import database.Cliente_Database
import data_class.Client

class AccountCreator {

    fun createAccount(): Client {
        val name = getInput("Ingrese su nombre: ")
        val phone = getInput("Ingrese su teléfono: ")
        val email = getEmail("Ingrese su email: ")
        val password = getPasswordInput("Genere su contraseña")

        val id = generateUniqueId()

        val nuevoCliente = Client(
            id = id,
            nombre = name,
            telefono = phone,
            email = email,
            constraseña = password
        )

        Cliente_Database.agregarCliente(nuevoCliente)
        return nuevoCliente
    }

    private fun getInput(message: String): String {
        println(message)
        return readLine()?.takeIf { it.isNotBlank() } ?: run {
            println("Entrada no válida. Intente nuevamente.")
            getInput(message)
        }
    }

    private fun getPasswordInput(message: String): String {
        while (true) {
            val password = getInput(message)
            if (validPassword(password)) {
                return password
            } else {
                println("La contraseña debe tener al menos 6 caracteres.")
            }
        }
    }

    private fun validPassword(password: String) = password.length >= 6

    private fun getEmail(message: String): String {
        while (true) {
            val email = getInput(message)
            if (isValidEmail(email) && !Cliente_Database.emailExiste(email)) {
                return email
            } else {
                println("Email inválido o ya registrado.")
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val regex = Regex("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")
        return email.matches(regex)
    }

    private fun generateUniqueId(): Int {
        var id = (1..9999).random()
        while (Cliente_Database.idExiste(id)) {
            id = (1..9999).random()
        }
        return id
    }
}
