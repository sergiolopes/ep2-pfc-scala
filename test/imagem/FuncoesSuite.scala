package imagem
import org.junit._
import org.hamcrest.CoreMatchers._
import Assert._
import Constantes._
import modelo._
import java.io._
import java.util.Scanner

class FuncoesSuite {
  
  @Test
  def testaPreencheRetangulo:Unit= {
    val matriz = Matriz[Int](10,10)
    Funcoes.preencheRetangulo(matriz, 2, 4, 5, 8, 42)
    
    for (i <- 0 until matriz.linhas) {
      for (j <- 0 until matriz.colunas) {
        if (i < 2 || i > 4 || j < 5 || j > 8)
        	assertThat(matriz(i,j), nullValue())
        else
            assertThat(matriz(i,j), is(42))
      }
    }
  }
  
  @Test
  def testaPreencheBorda:Unit= {
    val matriz = Matriz[Int](NLins,NCols)
    Funcoes.preencheBorda(matriz)
    
    for (i <- 0 until Base)
      for (j <- 0 until matriz.colunas)
    	assertThat(matriz(i,j), nullValue())
    
    for (j <- 0 until matriz.colunas)
    	assertThat(matriz(Base,j), is(Preto))
    
    for (i <- Base + 1 until NLins)
      for (j <- 0 until matriz.colunas)
    	assertThat(matriz(i,j), is(Branco))
  }
  
  @Test
  def testaImagemSilhueta1:Unit = {
    val silhueta = List(
    	ElemSilhueta(26, 330),
    	ElemSilhueta(78, 390),
    	ElemSilhueta(234, 0),
    	ElemSilhueta(312, 210),
    	ElemSilhueta(416, 90),
    	ElemSilhueta(494, 540),
    	ElemSilhueta(572, 90),
    	ElemSilhueta(598, 390),
    	ElemSilhueta(754, 0)
    )
    
    assertSilhuetaIgualArquivo(silhueta,"silhueta1.pgm")
  }
  
  @Test
  def testaImagemSilhueta2:Unit = {
    val silhueta = List(
    	ElemSilhueta(1, 52),
    	ElemSilhueta(4, 42),
    	ElemSilhueta(7, 61),
    	ElemSilhueta(8, 140),
    	ElemSilhueta(14, 148),
    	ElemSilhueta(16, 189),
    	ElemSilhueta(27, 134),
    	ElemSilhueta(29, 193),
    	ElemSilhueta(37, 275),
    	ElemSilhueta(48, 192),
    	ElemSilhueta(50, 144),
    	ElemSilhueta(51, 249),
    	ElemSilhueta(52, 367),
    	ElemSilhueta(65, 261),
    	ElemSilhueta(66, 144),
    	ElemSilhueta(68, 141),
    	ElemSilhueta(72, 143),
    	ElemSilhueta(74, 196),
    	ElemSilhueta(77, 245),
    	ElemSilhueta(89, 212),
    	ElemSilhueta(92, 319),
    	ElemSilhueta(93, 389),
    	ElemSilhueta(97, 472),
    	ElemSilhueta(115, 371),
    	ElemSilhueta(116, 355),
    	ElemSilhueta(123, 243),
    	ElemSilhueta(125, 290),
    	ElemSilhueta(132, 432),
    	ElemSilhueta(148, 537),
    	ElemSilhueta(167, 516),
    	ElemSilhueta(180, 281),
    	ElemSilhueta(183, 99),
    	ElemSilhueta(187, 100),
    	ElemSilhueta(189, 366),
    	ElemSilhueta(195, 373),
    	ElemSilhueta(209, 286),
    	ElemSilhueta(216, 265),
    	ElemSilhueta(218, 305),
    	ElemSilhueta(228, 428),
    	ElemSilhueta(242, 319),
    	ElemSilhueta(247, 306),
    	ElemSilhueta(258, 360),
    	ElemSilhueta(271, 354),
    	ElemSilhueta(279, 352),
    	ElemSilhueta(291, 321),
    	ElemSilhueta(292, 281),
    	ElemSilhueta(294, 363),
    	ElemSilhueta(298, 530),
    	ElemSilhueta(316, 462),
    	ElemSilhueta(332, 447),
    	ElemSilhueta(346, 400),
    	ElemSilhueta(354, 283),
    	ElemSilhueta(361, 504),
    	ElemSilhueta(377, 380),
    	ElemSilhueta(384, 489),
    	ElemSilhueta(401, 367),
    	ElemSilhueta(403, 459),
    	ElemSilhueta(407, 564),
    	ElemSilhueta(426, 301),
    	ElemSilhueta(435, 338),
    	ElemSilhueta(449, 336),
    	ElemSilhueta(457, 318),
    	ElemSilhueta(460, 491),
    	ElemSilhueta(467, 556),
    	ElemSilhueta(486, 405),
    	ElemSilhueta(492, 313),
    	ElemSilhueta(496, 197),
    	ElemSilhueta(497, 193),
    	ElemSilhueta(498, 265),
    	ElemSilhueta(499, 304),
    	ElemSilhueta(505, 306),
    	ElemSilhueta(506, 320),
    	ElemSilhueta(518, 126),
    	ElemSilhueta(519, 311),
    	ElemSilhueta(528, 329),
    	ElemSilhueta(541, 312),
    	ElemSilhueta(545, 482),
    	ElemSilhueta(563, 336),
    	ElemSilhueta(565, 423),
    	ElemSilhueta(578, 372),
    	ElemSilhueta(580, 520),
    	ElemSilhueta(598, 449),
    	ElemSilhueta(607, 443),
    	ElemSilhueta(617, 336),
    	ElemSilhueta(619, 361),
    	ElemSilhueta(628, 433),
    	ElemSilhueta(646, 217),
    	ElemSilhueta(653, 148),
    	ElemSilhueta(663, 134),
    	ElemSilhueta(669, 118),
    	ElemSilhueta(671, 76),
    	ElemSilhueta(672, 213),
    	ElemSilhueta(673, 461),
    	ElemSilhueta(690, 378),
    	ElemSilhueta(696, 336),
    	ElemSilhueta(703, 220),
    	ElemSilhueta(706, 227),
    	ElemSilhueta(709, 353),
    	ElemSilhueta(715, 383),
    	ElemSilhueta(729, 361),
    	ElemSilhueta(734, 247),
    	ElemSilhueta(740, 98),
    	ElemSilhueta(741, 155),
    	ElemSilhueta(749, 148),
    	ElemSilhueta(751, 298),
    	ElemSilhueta(761, 120),
    	ElemSilhueta(763, 185),
    	ElemSilhueta(772, 127),
    	ElemSilhueta(776, 103),
    	ElemSilhueta(778, 137),
    	ElemSilhueta(779, 142),
    	ElemSilhueta(786, 111),
    	ElemSilhueta(789, 94),
    	ElemSilhueta(792, 68),
    	ElemSilhueta(794, 64),
    	ElemSilhueta(795, 56),
    	ElemSilhueta(796, 45),
    	ElemSilhueta(797, 0)
    )
    
    assertSilhuetaIgualArquivo(silhueta,"silhueta2.pgm")
  }
  
  private def assertSilhuetaIgualArquivo(silhueta:List[ElemSilhueta], filename:String):Unit = {
    val result = new StringWriter
    Funcoes.geraImagem(silhueta, result);
    
    val expected = new Scanner(new FileReader(filename)).useDelimiter("\\Z").next();
    
    assertThat(result.toString, is(expected))
  }
}
