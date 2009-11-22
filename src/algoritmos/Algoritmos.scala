package algoritmos

import modelo._ 
import scala.collection.mutable.ListBuffer

object Algoritmos {
	def algoritmo1(edifs: List[Edificio]): List[ElemSilhueta] = {
	  val ordenados = edifs.sort(_ > _) // ordena em ordem de decrescente de dir
	  if(edifs.length > 0){
		  var resultado = List[ElemSilhueta]()
		  for(k <- 0 until edifs.length){
			  resultado = uniao(resultado, silhuetaDeEdificio(ordenados(k)))
		  }
		  resultado.sort(_ < _)
	  }else{
		  Nil
	  }
	}
	def algoritmo2(edifs: List[Edificio]): List[ElemSilhueta] = {
		algoritmo2_aux(edifs.sort(_ > _), List[ElemSilhueta]()).sort(_ < _)
		
	}
 
	private def algoritmo2_aux(edifs: List[Edificio], acc: List[ElemSilhueta]): List[ElemSilhueta] = (edifs) match {
	  case (Nil) => acc
	  case (l1) =>  algoritmo2_aux(edifs.drop(1), uniao(acc, silhuetaDeEdificio(edifs.head)))
	}
	
	def algoritmo3(edifs: List[Edificio]): List[ElemSilhueta] = {
		algoritmo3_aux(edifs.sort(_>_)).sort(_<_)
	}
	
	def algoritmo3_aux(edifs: List[Edificio]): List[ElemSilhueta] = edifs match{
	  case Nil => Nil
	  case (l1)  =>  {
		if(l1.length == 1) silhuetaDeEdificio(l1(0)) 
		else {
			val split = l1.splitAt(l1.length / 2)
			uniao(algoritmo3_aux(split._1), algoritmo3_aux(split._2))
		}
	  }
 
	}
 
	def silhuetaComFoldLeft(edifs: List[Edificio]): List[ElemSilhueta] = {
	  //((List[ElemSilhueta]() /: edifs) (_ ::: silhuetaDeEdificio(_)))
	  throw new RuntimeException
	}
	def silhuetaComFoldRight(edifs: List[Edificio]): List[ElemSilhueta] = {
	  //((edifs :\ List[ElemSilhueta]()) (silhuetaDeEdificio(_) ::: _))
	  throw new RuntimeException
	}
	
	/**
	* s1 e s2 estao em ordem crescente de coordenada horizontal x. 
	*/
	def uniao(s1: List[ElemSilhueta], s2: List[ElemSilhueta]): List[ElemSilhueta] = uniao_aux(s1, s2).reverse
 
	// s1 e s2 estao em ordem decresente de x
	private def uniao_aux(s1: List[ElemSilhueta], s2: List[ElemSilhueta]): List[ElemSilhueta] =
		(s1, s2) match {
		  case (Nil, Nil) => Nil;		  
		  case (l1, Nil) => l1.reverse;
		  case (Nil, l2) =>  l2.reverse;
		  case(l1, l2) => {
		    if (l1.head < l2.head){
		    	adicionaElemento(uniao_aux(l1.drop(2), l2), l1(0), l1(1));
		    }
		    else{
		    	adicionaElemento(uniao_aux(l1, l2.drop(2)), l2(0), l2(1));
		    }
		  }
	}

 	private def adicionaElemento(acc:List[ElemSilhueta],elemIni: ElemSilhueta, elemFim: ElemSilhueta) : List[ElemSilhueta] = {
		if(acc isEmpty){
		  (elemIni :: (elemFim :: acc))
		}else{
			val ultimoIni = acc(0)
			val ultimoFim = acc(1)
			/*caso 1: O novo elemento contem o ultimo elemento */
			if(elemIni.x < ultimoIni.x && elemFim.x > ultimoFim.x && ultimoIni.h == 0) (elemIni :: (elemFim :: acc.drop(2)))
			/*caso 2: O novo elemento comeca e termina no mesmo ponto do ultimo da silhueta, so q eh mais alto */
			else if(elemIni.x == ultimoIni.x && elemFim.x == ultimoFim.x && elemIni.h > ultimoIni.h) (elemIni :: (elemFim :: acc.drop(2)))
			/* caso #3 - o novo elemento nao tem interseccao com a silhueta */
			else if(elemFim.x < ultimoIni.x) (elemIni :: (elemFim :: acc))
			/* caso #4 - o novo elemento esta contido na silhueta */
			else if(elemIni.x >= ultimoIni.x && elemFim.x <= ultimoFim.x && elemIni.h <= ultimoIni.h) acc
			/* caso #5 - o novo elemento tem o ponto inicial 'antes' da silhueta e termina dentro dela*/
			else if(elemIni.x < ultimoIni.x && elemFim.x <= ultimoFim.x){
			  /* o novo elemento eh mais alto*/
			  if(ultimoIni.h <= elemIni.h) (elemIni :: (new ElemSilhueta(elemFim.x, ultimoIni.h)  ::  acc.drop(1)))
			  /* o novo elemento eh mais baixo*/
			  else (elemIni :: acc)		
			}
			/* caso #6 - o novo elemento esta dentro dos limites da silhueta, so que eh mais alto */
			else if(elemIni.x >= ultimoIni.x && elemFim.x <= ultimoFim.x && elemIni.h > ultimoIni.h)  (ultimoIni :: (elemIni :: (new ElemSilhueta(elemFim.x,ultimoIni.h) :: acc.drop(1))))
			/* caso #7 - semelhante ao caso 5, so q ultimo, na eh o termino da silhueta.. necessario procurar o final dela para saber a altura */
			else if(elemIni.x < ultimoIni.x && elemFim.x > ultimoFim.x){
			  val lista = acc.filter((x:ElemSilhueta) => x.h == 0)
			  if(lista.head.x > elemFim.x){ 
			    if(elemIni.h <= ultimoIni.h)(elemIni:: acc) 
			  	else  elemIni :: acc.drop(1) 
			  }else acc // nunca deve acontecer esta caso por conta da ordenacao
			}
			else{
				throw new RuntimeException("Caso nao coberto: acc: "+acc + " " +elemIni+" " + elemFim)
				acc
			}
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
