package util

import modelo._
import java.io._
import algoritmos.Algoritmos._
import scala.io.Source 

// funções de leitura
object Leitura {
  def parseArgumentos(args : Array[String]) = {
    var algoritmo = 3
    var entrada:InputStream = System.in 
    var saidaSilhueta:OutputStream = System.out
    var saidaImagem:String = ""
    
    if (args.length >= 1)
      algoritmo = args(0).toInt
    
    if (args.length >= 2)
    	entrada = new FileInputStream(args(1))
    
    if (args.length >= 3)
    	saidaSilhueta = new FileOutputStream(args(2))
    
    if (args.length >= 4)
    	saidaImagem = args(3)
    
    (algoritmo, entrada, saidaSilhueta, saidaImagem)
  }
  
  def leEntrada(entrada: InputStream) : List[Edificio] = {
    var lista = List[Edificio]()
    val dados =  Source.fromInputStream(entrada).getLines.toList
    val qtde = dados(0).replaceAll("\n","").toInt
    for(i <- 1 to qtde){
      var array = dados(i).split("\\s+")
      lista = Edificio(array(0).toInt,array(1).toInt,array(2).toInt) :: lista
    }
    lista
  }
}
