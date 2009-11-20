package util

import Leitura._
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LeituraSuite extends FunSuite with ShouldMatchers {

  test("parseArgumentos sem argumentos") {
    val (numAlgoritmo, entrada, saidaSilhueta, saidaImagem) = parseArgumentos(Array());
    
    numAlgoritmo should be (3)
    entrada should be (System.in)
    saidaSilhueta should be (System.out)
    saidaImagem should be ('empty)
  }

  test("parseArgumentos com um argumento") {
    val (numAlgoritmo, entrada, saidaSilhueta, saidaImagem) = parseArgumentos(Array("2"));
    
    numAlgoritmo should be (2)
    entrada should be (System.in)
    saidaSilhueta should be (System.out)
    saidaImagem should be ('empty)
  }
  
  test("parseArgumentos com dois argumentos") {
    val (numAlgoritmo, entrada, saidaSilhueta, saidaImagem)
    	= parseArgumentos(Array("1", "entrada1.txt"));
    
    numAlgoritmo should be (1)
    entrada.getClass should be (classOf[java.io.FileInputStream])
    saidaSilhueta should be (System.out)
    saidaImagem should be ('empty)
  }
  
  test("parseArgumentos com três argumentos") {
    val (numAlgoritmo, entrada, saidaSilhueta, saidaImagem) 
    	= parseArgumentos(Array("1", "entrada1.txt", "saida1.txt"));
    
    numAlgoritmo should be (1)
    entrada.getClass should be (classOf[java.io.FileInputStream])
    saidaSilhueta.getClass should be (classOf[java.io.FileOutputStream])
    saidaImagem should be ('empty)
  }
  
  test("parseArgumentos com quatro argumentos") {
    val (numAlgoritmo, entrada, saidaSilhueta, saidaImagem) 
    	= parseArgumentos(Array("1", "entrada1.txt", "saida1.txt", "imagem.pgm"));
    
    numAlgoritmo should be (1)
    entrada.getClass should be (classOf[java.io.FileInputStream])
    saidaSilhueta.getClass should be (classOf[java.io.FileOutputStream])
    saidaImagem should be ("imagem.pgm")
  }

}
