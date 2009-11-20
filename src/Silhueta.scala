import java.io._
import modelo._

import algoritmos.Algoritmos._
import imagem.Funcoes.geraImagem
import util.Leitura._
import util.Saida._

object Silhueta {
  def main(args : Array[String]) : Unit = {
    
    val (numAlgoritmo, entrada, saidaSilhueta, saidaImagem) = parseArgumentos(args)
    val edificios = leEntrada(entrada)
    val algoritmo = buscaAlgoritmo(numAlgoritmo)
    val silhueta  = algoritmo(edificios)
    
    imprimeSilhueta(silhueta, saidaSilhueta)
    
    if (!saidaImagem.isEmpty)
    	geraImagem(silhueta, saidaImagem)
  }
}
