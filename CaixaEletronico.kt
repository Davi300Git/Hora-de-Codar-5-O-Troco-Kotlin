import kotlin.system.exitProcess

var saldo = 100.5 // Float

fun main() {
    print("Digite o seu nome: ")
    val nome = readln()
    println("Olá $nome, é um prazer ter você por aqui!")

    inicio()
}

fun inicio() {
    while (true) {

        println("""
            Selecione uma opção :
            1.Ver Saldo.
            2.Fazer Deposito.
            3.Fazer Saque.
            4.Sair.
        """.trimIndent())
        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> verSaldo()
            2 -> fazerDeposito()
            3 -> fazerSaque()
            4 -> sair()
            else -> erro()
        }
    }
}

fun verSaldo() {
    println("Seu saldo atual é: $saldo")
    inicio()
}

fun fazerDeposito() {
    print("Qual o valor para depósito? ")
    val deposito = readln().toFloatOrNull()

    if (deposito == null) {
        println("Por favor, informe um número válido.")
        fazerDeposito()
    } else {
        saldo += deposito
        verSaldo()
    }
}

fun fazerSaque() {
    print("Qual o valor para saque? ")
    val saque = readln().toFloatOrNull()

    if (saque == null) {
        println("Por favor, informe um número válido.")
        fazerSaque()
    } else {
        saldo -= saque
        verSaldo()
    }
}

fun erro() {
    println("Por favor, informe um número entre 1 e 4.")
    inicio()
}

fun sair() {
    print("Você deseja sair? (S/N) ")
    val confirma = readln()

    when (confirma) {
        ("S") -> exitProcess(0)
        "N" -> inicio()
        else -> sair()
    }
}
