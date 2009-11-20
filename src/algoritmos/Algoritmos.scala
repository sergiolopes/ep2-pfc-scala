package algoritmos

import modelo._ 
import scala.collection.mutable.ListBuffer

object Algoritmos {
	def algoritmo1(edifs: List[Edificio]): List[ElemSilhueta] = {
	  val ordenados = edifs.sort(_ < _)
	  if(edifs.length > 0){
		  var resultado = List[ElemSilhueta]()
		  for(k <- 0 until edifs.length){
			  resultado = uniao(resultado, silhuetaDeEdificio(ordenados(k)))
			  resultado.foreach(println)
			  println("\n")
		  }
		  resultado.sort(_ < _)
	  }else{
		  Nil
	  }
	}
	def algoritmo2(edifs: List[Edificio]): List[ElemSilhueta] = throw new RuntimeException
	def algoritmo3(edifs: List[Edificio]): List[ElemSilhueta] = throw new RuntimeException
 
	def silhuetaComFoldLeft(edifs: List[Edificio]): List[ElemSilhueta] = {
	  //((List[ElemSilhueta]() /: edifs) (_ ::: silhuetaDeEdificio(_)))
	  throw new RuntimeException
	}
	def silhuetaComFoldRight(edifs: List[Edificio]): List[ElemSilhueta] = {
	  //((edifs :\ List[ElemSilhueta]()) (silhuetaDeEdificio(_) ::: _))
	  throw new RuntimeException
	}
	
 
	def uniao(s1: List[ElemSilhueta], s2: List[ElemSilhueta]): List[ElemSilhueta] = {		
		uniao_aux(s1, s2, List[ElemSilhueta]()).reverse
	}
 
	private def uniao_aux(s1: List[ElemSilhueta], s2: List[ElemSilhueta], acc:List[ElemSilhueta]): List[ElemSilhueta] =
		(s1, s2) match {
		  case (Nil, Nil) => acc;
		  case (Nil, l2) =>  l2 ::: acc;
		  case (l1, Nil) => l1 ::: acc ;
		  case(l1, l2) => {
		    if (l1(1) > l2(1)){
		    	uniao_aux(l1, l2.drop(2), adicionaElemento(acc, l2(1),l2(0)));
		    }
		    else{
		    	uniao_aux(l1.drop(2), l2, adicionaElemento(acc, l1(1),l1(0)));
		    }
		  }
	}
	
	private def adicionaElemento(acc:List[ElemSilhueta],elemIni: ElemSilhueta, elemFim: ElemSilhueta) : List[ElemSilhueta] = {
		if(acc isEmpty){
		  (elemFim :: (elemIni :: acc))
		}else{
			val ultimoIni = acc(1)
			val ultimoFim = acc(0)		
			/* caso #1 - o novo elemento esta contido na silhueta */
			if(ultimoIni.x <= elemIni.x && ultimoFim.x >= elemFim.x && ultimoIni.h >= elemIni.h) acc
			/* caso #2 - o novo elemento nao tem interseccao com a silhueta */
			else if(ultimoFim.x < elemIni.x) (elemFim :: (elemIni :: acc))
			/* caso #3 - o novo elemento tem o ponto final alem da silhueta*/
			else if(ultimoFim.x < elemFim.x){
			  /* o novo elemento eh mais alto*/
			  if(ultimoIni.h <= elemIni.h) (elemFim :: (new ElemSilhueta(elemIni.x, elemIni.h) :: acc.drop(0)))
			  /* o novo elemento eh mais baixo*/
			  else (elemFim :: (new ElemSilhueta(ultimoFim.x, elemIni.h) :: acc.drop(0)))		
			}
			/* caso #4 - o novo elemento esta dentro da silhueta, so que eh mais alto*/
			else if(ultimoIni.x <= elemIni.x && ultimoFim.x >= elemFim.x && ultimoIni.h < elemIni.h){
			  (ultimoFim :: (new ElemSilhueta(elemFim.x, elemIni.h) :: (elemIni :: acc.drop(0))))
			}
			else acc
		}
	}
 
	def silhuetaDeEdificio(edif: Edificio): List[ElemSilhueta] = {
			List(new ElemSilhueta(edif.esq,edif.alt), new ElemSilhueta(edif.dir,0))
	}
 
	// devolve o algoritmo baseado no numero dele
	def buscaAlgoritmo(num: Int) = num match {
	  case 1 => algoritmo1 _
      case 2 => algoritmo2 _
      case 3 => algoritmo3 _
      case x => throw new IllegalArgumentException("Algoritmo invalido: %d" format x)
	}
}
