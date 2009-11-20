import org.junit.runner._
import org.scalatest.tools.Runner

object Run {
  def main(args : Array[String]) : Unit = {
    
	Runner.main(Array("-p", ".", "-o", "-s", "util.LeituraSuite"))
    JUnitCore.main("imagem.MatrizTest")
    
  }
}
