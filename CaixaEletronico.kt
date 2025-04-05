import kotlin.system.exitProcess

var saldo = 100.5 // Double
var nome = ""
const val SENHA_CORRETA = "3589"

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
            2.Ver Extrato.
            3.Fazer Saque.
            4.Fazer Deposito.
            5.Fazer Transferencia. 
            6.Sair.
        """.trimIndent())
        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> verSaldo()
            2 -> verExtrato()
            3 -> fazerSaque()
            4 -> fazerDeposito()
            5 -> fazerTransferencia()
            6 -> sair()
            else -> erro()
        }
    }
}
fun verificarSenha(): Boolean {
    print("Digite sua senha: ")
    return readln() == SENHA_CORRETA
}

fun verSaldo() {
    if (!verificarSenha()) {
        println("Senha incorreta!")
        verExtrato()
        return
    }
    println("Seu saldo atual é: $saldo")
    inicio()
}

fun fazerDeposito() {
    if (!verificarSenha()) {
        println("Senha incorreta!")
        verExtrato()
        return
    }
    print("Qual o valor para depósito? ")
    val deposito = readln().toFloatOrNull()

    if (deposito == null) {
        println("Por favor, informe um número válido.")
        fazerDeposito()
    } else if(deposito <= 0){
        println("Operação não autorizada")
        fazerDeposito()
    } else {
        saldo += deposito
        verSaldo()
    }
}

fun fazerSaque() {
    if (!verificarSenha()) {
        println("Senha incorreta!")
        verExtrato()
        return
    }
    print("Qual o valor para saque? ")
    val saque = readln().toFloatOrNull()

    if (saque == null) {
        println("Por favor, informe um número válido.")
        fazerSaque()
    } else if(saque <= 0){
        println("Operação não autorizada")
        fazerSaque()
    }else if(saque > saldo){
        println("Operação não autorizada")
        fazerSaque()
    }else {
        saldo -= saque
        verSaldo()
    }
}

fun fazerTransferencia() {
    if (!verificarSenha()) {
    println("Senha incorreta!")
    verExtrato()
    return
}

    print("Qual o o número da conta? ")
    val conta = readln().toFloatOrNull()
    print("Qual o valor da transferencia? ")
    val saque = readln().toFloatOrNull()

    if (saque == null) {
        println("Por favor, informe um número válido.")
        fazerSaque()
    } else if(saque <= 0){
        println("Operação não autorizada")
        fazerSaque()
    }else if(saque > saldo){
        println("Operação não autorizada")
        fazerSaque()
    }else {
        saldo -= saque
        verSaldo()
    }
}

fun verExtrato(){
    if (!verificarSenha()) {
        println("Senha incorreta!")
        verExtrato()
        return
    }
    println("""
        Seu extrato:
        -500,00
        +600,00
        -5,00
        +2,00
        -900,00
        +12.000,00
    """.trimIndent())
}
fun erro() {
    println("Por favor, informe um número entre 1 e 6.")
    inicio()
}

fun sair() {
    print("Você deseja sair? (S/N) ")

    when (readln().uppercase()) {
        ("S") -> {
            println("$nome, foi um prazer ter você por aqui!")
            exitProcess(0)
        }
        ("N") -> inicio()
        else -> sair()
    }
}
