/*	Daniel Jimenez Ortega
*	Factorial con programacion dinamica
*/

class Factorial {
	static Map factoriales = [1:1]
	
	static BigInteger get (numero) {
	    if(numero <= 1)
		return 1
	    if (factoriales.containsKey(numero))
		return factoriales[numero]
	    BigInteger nuevo = numero * get(numero-1)
	    factoriales[numero] = nuevo
	    return nuevo
	}
}
