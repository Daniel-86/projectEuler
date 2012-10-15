def factoriales = [1:1]
def factorial
factorial = {BigInteger numero->
    if(numero <= 1)
        return 1
    if (factoriales.containsKey(numero))
        return factoriales[numero]
    def nuevo = numero * factorial(numero-1)
    factoriales[numero] = nuevo
    return nuevo
}

def sumaDigitos = {numero->
    String cadena = numero.toString()
    Integer suma = 0
    cadena.each { suma+= it.toInteger() }
    return suma
}

Integer numero = 100
println "La suma de los digitos de $numero! = ${factorial(numero)} es ${sumaDigitos(factorial(numero))}"