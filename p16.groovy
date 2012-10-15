def suma = 0
(2**1000).toString().each{suma += it.toInteger()}
println "La suma de los digitos de 2**1000 es $suma"