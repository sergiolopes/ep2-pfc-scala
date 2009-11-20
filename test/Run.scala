import org.junit.runner._
import org.scalatest.tools.Runner

object Run {
  def main(args : Array[String]) : Unit = {
    
	Runner.main(Array("-p", ".", "-o", "-s", "util.LeituraSuite"))
    Runner.main(Array("-p",".","-o","-s","algoritmos.SilhuetaAlgoritmos"))
	JUnitCore.main("imagem.MatrizTest")
    
  }
}
