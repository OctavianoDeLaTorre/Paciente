import scala.collection.mutable.ListBuffer

class Paciente(
    var nombre:String = "n/a",
    var primerAp:String = "n/a",
    var segundoAp:String = "n/a",
    var fecha:ListBuffer[String] = ListBuffer("12/03/19","13/03/19","14/03/19","15/03/19"),
    var horaReg:ListBuffer[Int] = ListBuffer(1,2,3,4),
    var nivelBienstar:ListBuffer[Int] = ListBuffer(5,4,3,2),
    var temperatura:ListBuffer[Int] = ListBuffer(20,15,35,10),
    var humedad:ListBuffer[Int] = ListBuffer(50,60,40,30)){
  
  def promedioBienestar:Double={
    var sum = 0
    nivelBienstar.foreach(n => sum += n);
    return sum/nivelBienstar.length
  }
  
  
  def obtenerMayores():ListBuffer[String] = {
    var index = obtenerValorMayor(temperatura);
    var resultados = ListBuffer.empty[String]
    resultados.+=("Temperartura: "+temperatura(index))
    resultados.+=("Hora: "+horaReg(index))
    resultados.+=("Nivel bienestar: "+nivelBienstar(index))
    resultados.+=("Humedad: "+humedad(index))
    resultados.+=("Fecha: "+fecha(index))
    return resultados;    
  }
  
  private def obtenerValorMayor(lista:ListBuffer[Int]):Int ={
    var aux = lista(0)
    lista.foreach(f => if(f > aux) aux = f)
    return lista.indexOf(aux)
  }
  
  
  //Valores menores
   def obtenerMenor():ListBuffer[String] = {
    var index = obtenerValorMenor(temperatura);
    var resultados = ListBuffer.empty[String]
    resultados.+=("Temperartura: "+temperatura(index))
    resultados.+=("Hora: "+horaReg(index))
    resultados.+=("Nivel bienestar: "+nivelBienstar(index))
    resultados.+=("Humedad: "+humedad(index))
    resultados.+=("Fecha: "+fecha(index))
    return resultados    
  }
   

  
  private def obtenerValorMenor(lista:ListBuffer[Int]):Int ={
    var aux = lista(0)
    lista.foreach(f => if(f < aux) aux = f)
    return lista.indexOf(aux)
  }
  
  
  def mostrarLista(lista:ListBuffer[String],titulo:String){
    println("\n"+titulo)
    lista.foreach(f => println(f))
  }
  
}

object Prueba {
  def main(args: Array[String]): Unit = {
    var p = new Paciente()
    println("Promedio bienestar: "+p.promedioBienestar)
    p.mostrarLista(p.obtenerMayores(), "===Temperatura Mayor===")
    p.mostrarLista(p.obtenerMenor(), "===Temperatura Menor===")
  }
}





