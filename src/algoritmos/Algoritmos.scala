package algoritmos

import modelo._

object Algoritmos {
	def algoritmo1(edifs: List[Edificio]): List[ElemSilhueta] = throw new RuntimeException
	def algoritmo2(edifs: List[Edificio]): List[ElemSilhueta] = throw new RuntimeException
	def algoritmo3(edifs: List[Edificio]): List[ElemSilhueta] = throw new RuntimeException
 
	def silhuetaComFoldLeft(edifs: List[Edificio]): List[ElemSilhueta] = throw new RuntimeException
	def silhuetaComFoldRight(edifs: List[Edificio]): List[ElemSilhueta] = throw new RuntimeException
 
	def uniao(s1: List[ElemSilhueta], s2: List[ElemSilhueta]): List[ElemSilhueta] = throw new RuntimeException
 
	def silhuetaDeEdificio(edif: Edificio): List[ElemSilhueta] = throw new RuntimeException
 
	// devolve o algoritmo baseado no numero dele
	def buscaAlgoritmo(num: Int) = num match {
	  case 1 => algoritmo1 _
      case 2 => algoritmo2 _
      case 3 => algoritmo3 _
      case x => throw new IllegalArgumentException("Algoritmo invalido: %d" format x)
}
}
