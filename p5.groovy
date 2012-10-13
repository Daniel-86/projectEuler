def getPrimosL(listaNumeros){
    def listaPrimos = []
    listaNumeros.each{
        def esPrimo = true
        for(i=2; i<it; i++)
            if(it%i == 0){
                esPrimo = false
                break
            }
        if(esPrimo== true)
            listaPrimos += it
     }
     return listaPrimos
}

def esDivisibleEntre(numero, rango){
    def esDiv = true
    for(it in rango){
        if(numero % it != 0){
            esDiv=false
            break
        }
    }
    return esDiv
}

def minimoComunMultiplo(rango){
    def incremento = rango.max()
    def numero = incremento
//    def factores = getPrimosL(rango)
    while(!esDivisibleEntre(numero, rango))
        numero += incremento
    return numero
}

rango = 1..20
//println "primos dentro de $rango: ${getPrimosL(rango)}"
println "El minimo comun multiplo de $rango es: ${minimoComunMultiplo(rango)}"