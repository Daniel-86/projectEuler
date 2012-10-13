def sumaCuadrados(listaNumeros){
    return listaNumeros.sum{ it ** 2 }
}

def cuadradoSuma(listaNumeros){
    return listaNumeros.sum() ** 2
}

def diferenciaC(listaNumeros){
    return cuadradoSuma(listaNumeros) - sumaCuadrados(listaNumeros)
}

def rango = 1..100
println "La diferencia es: ${diferenciaC(rango)}"