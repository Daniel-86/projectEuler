/*
*	Daniel Jimenez Ortega
*
*	Cuantos domingos fueron primero de mes durante el siglo 20 ( 1 Ene 1901 a 31 Dec 2000 )
*/

import groovy.time.*


Map Dia = ['domingo':1, 'lunes':2, 'martes':3, 'miercoles':4, 'jueves':5, 'viernes':6, 'sabado':7]
def numXenLapso = { diaSemana, fechaIni, fechaFin->
    Calendar inicio = fechaIni.toCalendar()
    Calendar fin = fechaFin.toCalendar()
    Calendar primero = inicio
    while (primero.get(Calendar.DAY_OF_WEEK) != diaSemana)
        primero = primero.next()
    Integer numDias = 0
    for (def i = primero; i < fin; i = i.next()) {
        if (i.get(Calendar.DAY_OF_WEEK) == diaSemana && i.get(Calendar.DAY_OF_MONTH) == 1)
            numDias++
    }

    return numDias
}


Date inicio = new Date()
String formatoFecha = "dd-MM-yyyy"
String nombreDia = 'jueves'
Integer diaSemana = Dia[nombreDia]
Date fechaIni = Date.parse(formatoFecha, '01-01-1901')
Date fechaFin = Date.parse(formatoFecha, '31-12-2000')
Integer nDias = numXenLapso(diaSemana, fechaIni, fechaFin)
println "En el periodo (${fechaIni.format(formatoFecha)} - ${fechaFin.format(formatoFecha)}) "\
	+ "hubo $nDias dias $nombreDia que fueron primero de mes"
println "Ejectuado en ${TimeCategory.minus(new Date(), inicio)}"

