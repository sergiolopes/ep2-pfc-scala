package util
import java.io._
import modelo._

object Saida {
  def imprimeSilhueta(silhueta: List[ElemSilhueta], saida: OutputStream) : Unit = {
	val escritor = new PrintWriter(saida)
	escritor.println(silhueta.length)
	silhueta.foreach(escritor.println)
	escritor.close()
	saida.close()
  }
}
