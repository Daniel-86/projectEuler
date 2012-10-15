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
    String cadena = numero.toString()//; println "como cadena $cadena"
    def longitud = cadena.size()//; println "mide $longitud"
    String nombre = ""
    ((longitud - 1)..0).each{//println "analizando ${pos[it]}"
                                switch(pos[it]){
                                case 'unidades':
                                    if(longitud > 1 
                                            && (cadena[longitud-1] == '0' || cadena[longitud-2] == '1'))
                                        break
                        //            println "\t${cadena[it].toInteger()}"
                                    nombre += "${digitNames[cadena[longitud - 1].toInteger()]}"
                                    break
                                    
                                case 'decenas':
                                    if (cadena[longitud - 2] == '0')
                                        break
                                    if (cadena[longitud - 2] == '1'){
                                        if (cadena[longitud - 1] == '8'){
                                            nombre += "${digitNames[ cadena[longitud -1].toInteger() ]}${decNames['mas15'][-3..-1]}"
                                            break
                                        }
                                        if (cadena[longitud - 1].toInteger() > 5){
                                            nombre += "${digitNames[ cadena[longitud -1].toInteger() ]}${decNames['mas15']}"
                                            break
                                        }
                                        nombre += "${decNames[ cadena[longitud-2..longitud-1].toInteger() ]}"
                                        break
                                    }
                                    if (cadena[longitud - 2] == '8'){
                                        nombre += "${digitNames[ cadena[longitud -2].toInteger() ]}${decNames['mas50'][-1]}"
                                    }else if (cadena[longitud - 2].toInteger() > 5){
                                        nombre += "${digitNames[cadena[longitud - 2].toInteger()]}${decNames['mas50']}"
                                    }
                                    else{
                                        nombre += "${decNames[ cadena[longitud - 2].toInteger()]}"
                                    }
                                    if(cadena[longitud - 1] != '0')
                                        nombre += '-'
                                    break
                                    
                                case 'centenas':
                                    if (cadena[longitud - 3] == '0')
                                        break
                                    nombre += "${digitNames[ cadena[longitud-3].toInteger() ]} ${centenas['unico']}"
                                    if ( cadena[longitud-2..longitud-1].toInteger() > 0)
                                        nombre += " and "
                                    break
                                case 'miles':
                                    nombre += "${digitNames[ cadena[longitud-4].toInteger() ]} ${miles['unico']}"
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
    def cantLetras = 0
    (1..limite).each{
                    String nombre = enLetras(it)
                    nombre.each{ caracter->
                                    if (caracter ==~"[a-zA-Z]")
                                        cantLetras++
                                }
                  }
    return cantLetras
}

def numero = 1000
//println "$numero ${enLetras(numero)}"
println "letras usadas ${resolver(numero)}"
/*"one hundred and seven".each{
                                if (it ==~"[a-z]")
                                    println it
                             }*/