def archivo = new File("/home/rbnseven/Escritorio/projectEuler/names.txt")
def nombres = []
archivo.each{ nombres += it.split(",").flatten()}
nombres = nombres.collect{ it[1..-2] }.sort()
def letras = ('A'..'Z')
def suma = 0
nombres.each {nombre->
            def score = 0
            nombre.each{ letra->
                        score += letras.findIndexOf {it == letra} + 1
                    }
            def pos = nombres.findIndexOf {it == nombre} + 1
            suma += score * pos
        }
println "la suma es $suma"
