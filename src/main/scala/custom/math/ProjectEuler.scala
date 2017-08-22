package custom.math

import java.math.BigInteger

import custom.poker.{Card, Hand}

import scala.collection.immutable
import scala.collection.mutable

object ProjectEuler {
  def problem3(): Unit = {
    val n = 600851475143L
    val factors = Numbers.getFactors(n) // Should be true in case n is prime
    println("NUMBER OF FACTORS: " + factors.size)
    val primes = Primes.isPrime(factors.toSeq).filter(x => x._2).map(x => x._1)
    println("LARGEST PRIME FACTOR: " + primes.max)
  }

  def problem10(): Unit = {
    val primes = Primes.sieveOfEratosthenes(2000000)
    println(primes.sum)
    println(primes.mkString(" "))
  }

  // NOT COMPLETE
  def problem11(): Unit = {
    val rows = 20
    val columns = 20
    val sequenceLength = 4
    def coordToString(coord: (Int, Int)): String = {
      val format = "%02d"
      format.format(coord._1) + format.format(coord._2)
    }
    def stringToCoord(str: String): (Int, Int) = {
      val a = (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0')
      val b = (str.charAt(2) - '0') * 10 + (str.charAt(3) - '0')
      a -> b
    }
    def canGoUp(coord: (Int, Int)): Boolean = coord._1 >= sequenceLength - 1
    def canGoLeft(coord: (Int, Int)): Boolean = coord._2 >= sequenceLength - 1
    def canGoDown(coord: (Int, Int)): Boolean = coord._1 <= rows - sequenceLength
    def canGoRight(coord: (Int, Int)): Boolean = coord._2 <= columns - sequenceLength
    val grid = Array[String](
      "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08",
      "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00",
      "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65",
      "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91",
      "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80",
      "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50",
      "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70",
      "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21",
      "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72",
      "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95",
      "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92",
      "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57",
      "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58",
      "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40",
      "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66",
      "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69",
      "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36",
      "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16",
      "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54",
      "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48").map(st => st.split("\\s+"))
    val memos = mutable.HashMap[immutable.TreeSet[String], Long]()
    val solutions = Array.fill[Array[Long]](20)(Array.fill[Long](20)(0L))
  }

  def problem12(): Unit = {
    val factorLimit = 500
    var n = 1L
    while (Numbers.getFactors(Numbers.getNthTriangleNumber(n), true).size <= factorLimit) {
      n += 1
    }
    println(Numbers.getNthTriangleNumber(n))
  }

  def problem13(): Unit = {
    val strNumbers = scala.collection.parallel.mutable.ParArray[String](
      "37107287533902102798797998220837590246510135740250",
      "46376937677490009712648124896970078050417018260538",
      "74324986199524741059474233309513058123726617309629",
      "91942213363574161572522430563301811072406154908250",
      "23067588207539346171171980310421047513778063246676",
      "89261670696623633820136378418383684178734361726757",
      "28112879812849979408065481931592621691275889832738",
      "44274228917432520321923589422876796487670272189318",
      "47451445736001306439091167216856844588711603153276",
      "70386486105843025439939619828917593665686757934951",
      "62176457141856560629502157223196586755079324193331",
      "64906352462741904929101432445813822663347944758178",
      "92575867718337217661963751590579239728245598838407",
      "58203565325359399008402633568948830189458628227828",
      "80181199384826282014278194139940567587151170094390",
      "35398664372827112653829987240784473053190104293586",
      "86515506006295864861532075273371959191420517255829",
      "71693888707715466499115593487603532921714970056938",
      "54370070576826684624621495650076471787294438377604",
      "53282654108756828443191190634694037855217779295145",
      "36123272525000296071075082563815656710885258350721",
      "45876576172410976447339110607218265236877223636045",
      "17423706905851860660448207621209813287860733969412",
      "81142660418086830619328460811191061556940512689692",
      "51934325451728388641918047049293215058642563049483",
      "62467221648435076201727918039944693004732956340691",
      "15732444386908125794514089057706229429197107928209",
      "55037687525678773091862540744969844508330393682126",
      "18336384825330154686196124348767681297534375946515",
      "80386287592878490201521685554828717201219257766954",
      "78182833757993103614740356856449095527097864797581",
      "16726320100436897842553539920931837441497806860984",
      "48403098129077791799088218795327364475675590848030",
      "87086987551392711854517078544161852424320693150332",
      "59959406895756536782107074926966537676326235447210",
      "69793950679652694742597709739166693763042633987085",
      "41052684708299085211399427365734116182760315001271",
      "65378607361501080857009149939512557028198746004375",
      "35829035317434717326932123578154982629742552737307",
      "94953759765105305946966067683156574377167401875275",
      "88902802571733229619176668713819931811048770190271",
      "25267680276078003013678680992525463401061632866526",
      "36270218540497705585629946580636237993140746255962",
      "24074486908231174977792365466257246923322810917141",
      "91430288197103288597806669760892938638285025333403",
      "34413065578016127815921815005561868836468420090470",
      "23053081172816430487623791969842487255036638784583",
      "11487696932154902810424020138335124462181441773470",
      "63783299490636259666498587618221225225512486764533",
      "67720186971698544312419572409913959008952310058822",
      "95548255300263520781532296796249481641953868218774",
      "76085327132285723110424803456124867697064507995236",
      "37774242535411291684276865538926205024910326572967",
      "23701913275725675285653248258265463092207058596522",
      "29798860272258331913126375147341994889534765745501",
      "18495701454879288984856827726077713721403798879715",
      "38298203783031473527721580348144513491373226651381",
      "34829543829199918180278916522431027392251122869539",
      "40957953066405232632538044100059654939159879593635",
      "29746152185502371307642255121183693803580388584903",
      "41698116222072977186158236678424689157993532961922",
      "62467957194401269043877107275048102390895523597457",
      "23189706772547915061505504953922979530901129967519",
      "86188088225875314529584099251203829009407770775672",
      "11306739708304724483816533873502340845647058077308",
      "82959174767140363198008187129011875491310547126581",
      "97623331044818386269515456334926366572897563400500",
      "42846280183517070527831839425882145521227251250327",
      "55121603546981200581762165212827652751691296897789",
      "32238195734329339946437501907836945765883352399886",
      "75506164965184775180738168837861091527357929701337",
      "62177842752192623401942399639168044983993173312731",
      "32924185707147349566916674687634660915035914677504",
      "99518671430235219628894890102423325116913619626622",
      "73267460800591547471830798392868535206946944540724",
      "76841822524674417161514036427982273348055556214818",
      "97142617910342598647204516893989422179826088076852",
      "87783646182799346313767754307809363333018982642090",
      "10848802521674670883215120185883543223812876952786",
      "71329612474782464538636993009049310363619763878039",
      "62184073572399794223406235393808339651327408011116",
      "66627891981488087797941876876144230030984490851411",
      "60661826293682836764744779239180335110989069790714",
      "85786944089552990653640447425576083659976645795096",
      "66024396409905389607120198219976047599490197230297",
      "64913982680032973156037120041377903785566085089252",
      "16730939319872750275468906903707539413042652315011",
      "94809377245048795150954100921645863754710598436791",
      "78639167021187492431995700641917969777599028300699",
      "15368713711936614952811305876380278410754449733078",
      "40789923115535562561142322423255033685442488917353",
      "44889911501440648020369068063960672322193204149535",
      "41503128880339536053299340368006977710650566631954",
      "81234880673210146739058568557934581403627822703280",
      "82616570773948327592232845941706525094512325230608",
      "22918802058777319719839450180888072429661980811197",
      "77158542502016545090413245809786882778948721859617",
      "72107838435069186155435662884062257473692284509516",
      "20849603980134001723930671666823555245252804609722",
      "53503534226472524250874054075591789781264330331690"
    ).map(st => new math.BigInt(new BigInteger(st)))
    println(strNumbers.sum.toString.substring(0, 10))
  }

  def problem14(): Unit = {
    val upTo = 999999
    val counts = Array.fill[Long](upTo)(0L)
    counts(0) = 1 // set length of chain when n = 1
    def updateChainCount(n: Long): Long = {
//      print(n + " -> ")
      if (n < counts.length - 1 && counts(n.toInt - 1) != 0) counts(n.toInt - 1)
      else {
        val chain = {
          if (n % 2 == 0) updateChainCount(n / 2)
          else updateChainCount(3 * n + 1)
        } + 1
        if (n < counts.length) counts(n.toInt - 1) = chain
        chain
      }
    }
    for (i <- 1 to counts.length) {
      if (counts(i - 1) == 0) {
        counts(i - 1) = updateChainCount(i)
//        println(" |" + counts(i - 1) + "|")
      }
    }
    println(counts.indexOf(counts.max) + 1)
  }

  def problem17(): Unit = {
    // From 1-9
    val onesCount = Array[String]("one","two","three","four","five","six","seven","eight","nine").map(st => st.length).sum
    // From 1-99
    val tensCount = Array[String]("ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen").map(st => st.length).sum + (
      10 * Array[String]("twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety").map(st => st.length).sum + (onesCount * 9))
    // From 1-999
    val hundredsCount = {
      val and = "and".length
      val hundred = "hundred".length
      (100 * onesCount) + (900 * (and + hundred)) + (10 * tensCount) - (9 * and) /* "one hundred", etc. has no "and" */
    }
    println(hundredsCount + "onethousand".length)
  }

  def problem25(): Unit = {
    // Find the index of the first fibb number with 1000 digits F1 = 1, F2 = 1, F3 = 2
    import scala.math.BigInt
    val digitLimit = 1000
    var a = BigInt(1)
    var b = BigInt(1)
    var c = BigInt(2)
//    var a = 1L
//    var b = 1L
//    var c = 2L
    var index = 3
    while (c.toString.length < digitLimit) {
//      println(c)
      a = b
      b = c
      c = a + b
      index += 1
    }
    println("Length: " + c.toString.length)
    println("Number: " + c)
    println("Index: " + index)
  }

  // NOT COMPLETE
  def problem33(): Unit = {
    val stored = scala.collection.parallel.mutable.ParHashSet[Rational]()
    for (i <- 10 until 100 par) {
      for (j <- 10 until 100) {
        if (!(i % 10 == 0 && j % 10 == 0) && !(i % 11 == 0 && j % 11 == 0)) {
          val asrat = Rational(i, j)
          if (asrat.top != i && asrat.bottom != j && i.toString.charAt(1).toString == asrat.top.toString && j.toString.charAt(0).toString == asrat.bottom.toString) {
            println("%d / %d => %s".format(i, j, asrat.toString))
            stored += asrat
          }
        }
      }
    }
    // FUUUUUUUUUCK you can't reduce all the way
  }

  def problem40(): Unit = {
    val build = new mutable.StringBuilder()
    var i = 0
    while (build.length <= 1000000) {
      build ++= i.toString
      i += 1
    }
    println(
      build.charAt(1).toString.toInt *
        build.charAt(10).toString.toInt *
        build.charAt(100).toString.toInt *
        build.charAt(1000).toString.toInt *
        build.charAt(10000).toString.toInt *
        build.charAt(100000).toString.toInt *
        build.charAt(1000000).toString.toInt
    )
  }

  // NOT COMPLETE
  def problem47(): Unit = {
    // Looks like this one might need complete prime factorization
    val globalPrimes = mutable.TreeSet[Long]()
    val primeFactors = mutable.TreeMap[Long, mutable.TreeSet[Long]]()
//    primeFactors +=
  }

  // NOT COMPLETE
  def problem49(): Unit = {
    import scala.collection.mutable.TreeSet
    val globalPrimeList = TreeSet[Long]()
    val attempted = TreeSet[Long]()
//    def createPermutations(n: Long): Seq[Long] = {
//      n.toString.toCharArray.permutations.toSeq.map(n => n.mkString.toLong)
//    }
    // Must ensure they are all the same number of digits and conform to a sequence (all same dist apart)
    // Also given that there are only three terms in the sequence
  }

  // NOT COMPLETED
  def problem52(): Unit = {
    // TODO: not efficient enough
    def toDigitArray(n: Long): Array[Char] = n.toString.toCharArray.sorted
    var current = 1L
    while (current > 0) {
      val original = toDigitArray(current)
      val permuted = (original == toDigitArray(current << 1)) &&
        (original == toDigitArray(3 * current)) &&
        (original == toDigitArray(current << 2)) &&
        (original == toDigitArray(5 * current)) &&
        (original == toDigitArray(6 * current))
      if (permuted) {
        println(current)
        current = -1
      }
      current += 1
    }
  }

  // IN PROGRESS
  // NOT COMPLETE
  def problem54(): Unit = {
    def parseHand(cards: Seq[String]): Hand = {
      Hand(cards.map(c => {
        Card(
          c.dropRight(1) match {
            case "T" => 10
            case "J" => Card.Jack
            case "Q" => Card.Queen
            case "K" => Card.King
            case "A" => Card.Ace
            case other => other.toString.toInt
          }, c.takeRight(1) match {
            case "S" => Card.Spade
            case "D" => Card.Diamond
            case "H" => Card.Heart
            case "C" => Card.Club
            case _ => throw new Exception("FUCKING PANIC! PE LIED TO ME!")
          }
        )
      }).toArray)
    }
//    val lines = scala.io.Source.fromFile("poker.txt").getLines
//    var p1Wins = 0
//    for (line <- lines) {
//      val things = line.split("\\s+")
//      val hand1 = parseHand(things.take(5))
//      val hand2 = parseHand(things.takeRight(5))
//      if ((hand1 compare hand2) > 0) p1Wins += 1
//    }
//    println(p1Wins)
  }

}
