package util

import modelo._
import java.io._
import algoritmos.Algoritmos._

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
    	saidaImagem = args(2)
    
    (algoritmo, entrada, saidaSilhueta, saidaImagem)
  }
  
  def leEntrada(entrada: InputStream) : List[Edificio] = {
    throw new RuntimeException
  }
}
