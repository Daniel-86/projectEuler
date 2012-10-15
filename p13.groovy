List<BigInteger> armaLista(ruta){
    def archivo = new File(ruta)
    List <BigInteger> lista = []
    archivo.eachLine{ lista += it.toBigInteger() }
    return lista
}

def archivo = "/home/rbnseven/Escritorio/projectEuler/p13Lista.txt"
List<BigInteger> numeros = armaLista(archivo)
BigInteger suma = 0
numeros.each { suma += it }
def nDigitos = 10
String digitos = suma.toString().substring(0, nDigitos)
println "Los primeros $nDigitos digitos de la suma son $digitos"