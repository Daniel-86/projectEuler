/*
*	Daniel Jimenez Ortega
*
*	Si se escriben todos los numeros (en ingles) del 1 al 1000, cuantas letras se usan?.
*	No contar guiones o espacios, solo letras.
*/

import groovy.time.*


Map digitNames = [
                    0:'zero',
                    1:'one',
                    2:'two',
                    3:'three',
                    4:'four',
                    5:'five',
                    6:'six',
                    7:'seven',
                    8:'eight',
                    9:'nine',
                 ]
Map decNames = [
                    10:'ten',
                    11:'eleven',
                    12:'twelve',
                    13:'thirteen',
                    14:'fourteen',
                    15:'fifteen',
                    2:'twenty',
                    3:'thirty',
                    4:'forty',
                    5:'fifty',
                    'mas15':'teen',
                    'mas50':'ty'
               ]
Map centenas = ['unico':'hundred']
Map miles = ['unico':'thousand']

def enLetras = {numero->
    List pos = ['unidades', 'decenas', 'centenas', 'miles', 'millones', 'billones']
    String cadena = numero.toString()
    Integer longitud = cadena.size()
    String nombre = ""
    ( (longitud - 1)..0 ).each{
                             switch (pos[it]) {
                                case 'unidades':
                                    /*
                                    *	Si el numero tiene mas de 1 digito y
                                    *	las unidades son 0 o las decenas es 1
                                    *		e.g. 20, 30, 13, 18, ...
                                    *	Entonces no se procesan las unidades
                                    */
                                    if (longitud > 1 
                                            && (cadena[longitud-1] == '0' || cadena[longitud-2] == '1') )
                                        break
                                    nombre += "${digitNames[cadena[longitud - 1].toInteger()]}"
                                    break
                                    
                                case 'decenas':
                                    if (cadena[longitud - 2] == '0')
                                        break
                                    // Si las decenas estan entre 10 y 19
                                    if (cadena[longitud - 2] == '1') {
                                        // Para evitar escribir 'eightten', quitar una t
                                        if (cadena[longitud - 1] == '8') {
                                            nombre += 
                                            	    "${digitNames[ cadena[longitud -1].toInteger() ]}"\
                                            	     + "${decNames['mas15'][-3..-1]}"
                                            break
                                        }
                                        // Si esta entre 16 y 19, es el nombre del digito mas 'teen'
                                        if (cadena[longitud - 1].toInteger() > 5){
                                            nombre +=
                                            	    "${digitNames[ cadena[longitud -1].toInteger() ]}"\
                                            	       + "${decNames['mas15']}"
                                            break
                                        }
                                        nombre+="${decNames[cadena[longitud-2..longitud-1].toInteger()]}"
                                        break
                                    }
                                    //  Para evitar escribir 'eightty', quitar una t
                                    if (cadena[longitud - 2] == '8'){
                                        nombre += "${digitNames[ cadena[longitud - 2].toInteger() ]}"\
                                        	     + "${decNames['mas50'][-1]}"
                                    }
                                    // Si esta entre 60 y 99, es el nombre del digito mas 'ty'
                                    else if (cadena[longitud - 2].toInteger() > 5) {
                                        nombre += "${digitNames[ cadena[longitud - 2].toInteger() ]}"\
                                        	     + "${decNames['mas50']}"
                                    }
                                    else
                                        nombre += "${decNames[ cadena[longitud - 2].toInteger()]}"
                                    if(cadena[longitud - 1] != '0')
                                        nombre += '-'
                                    break
                                    
                                case 'centenas':
                                    if (cadena[longitud - 3] == '0')
                                        break
                                    nombre += "${digitNames[ cadena[longitud-3].toInteger() ]} "\
                                    		+ "${centenas['unico']}"
                                    if ( cadena[longitud-2..longitud-1].toInteger() > 0)
                                        nombre += " and "
                                    break
                                    
                                case 'miles':
                                    nombre += "${digitNames[ cadena[longitud-4].toInteger() ]} "\
                                    		+ "${miles['unico']}"
                                    if ( cadena[longitud-3..longitud-1].toInteger() > 0)
                                        nombre += " "
                                    break
                                    
                                default:
                                    nombre = "no identificado"
                                    break
                             }
    }
    return nombre
}


def resolver = { limite->
    Integer cantLetras = 0
    (1..limite).each{
                    String nombre = enLetras(it)
                    nombre.each{ caracter->
                                    if (caracter ==~"[a-zA-Z]")
                                        cantLetras++
                    }
    }
    return cantLetras
}



Date inicio = new Date()
def numero = 1000

println "letras usadas ${resolver(numero)}"
println "Ejecutado en ${TimeCategory.minus(new Date(), inicio)}"

