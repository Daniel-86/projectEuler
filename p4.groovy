def esPalindrome(numero){
    def cadena = numero.toString()
    return cadena.equals(cadena.reverse())
}

def maxPal = 0
def n1P, n2P
for(n1 = 0; n1 < 999; n1++)
    for(n2 = 0; n2 < 999; n2++)
        if(esPalindrome(n1 * n2) && n1*n2> maxPal){
            maxPal = n1*n2
            n1P = n1
            n2P = n2
        }

println "El palindrome maximo formado por numeros de 3 digitos es:$maxPal, los digitos son:($n1P, $n2P)"