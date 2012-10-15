def eratostenes = { numero->
    Integer limite = Math.floor(Math.sqrt(numero)) + 1
    List <BigInteger> compuestos = []
    (2..limite).each{ i->
                    if (!compuestos.contains(i))
                        (i..(numero/i+1)).each{ j-> compuestos += i * j }
    }
    List <BigInteger> primos = []
    (2..numero).each{
                        if(!compuestos.contains(it))
                            primos += it
    }
    return primos
}

Integer numero = 73920
def resul = eratostenes(numero)
println "los primos anteriores a $numero son ${resul}, son ${resul.size()}"