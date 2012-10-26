/*
*    Daniel Jimenez Ortega
*    Cuales son los primeros 10 digitos de la suma de 100 numeros de 50 digitos?
*/

import groovy.time.*


List<BigInteger> armaLista(ruta){
    def archivo = new File(ruta)
    List <BigInteger> lista = []
    archivo.eachLine{ lista += it.toBigInteger() }
    return lista
}


Date inicio = new Date()
def archivo = "./p13Lista.txt"
List<BigInteger> numeros = armaLista(archivo)
BigInteger suma = 0
numeros.each { suma += it }
def nDigitos = 10
String digitos = suma.toString().substring(0, nDigitos)

println "Los primeros $nDigitos digitos de la suma son $digitos"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"
