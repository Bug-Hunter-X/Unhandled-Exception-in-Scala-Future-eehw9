```scala
import scala.concurrent.{ExecutionContext, Future}

class MyClass(implicit ec: ExecutionContext) {
  def myMethod(i: Int): Future[Int] = Future {
    if (i == 0) throw new Exception("Zero is not allowed")
    i * 2
  }
}

//Example Usage
object Main extends App {
  implicit val ec = scala.concurrent.ExecutionContext.global
  val myClass = new MyClass()

  myClass.myMethod(0).onComplete{
    case scala.util.Success(value) => println(s"Success: $value")
    case scala.util.Failure(exception) => println(s"Failure: ${exception.getMessage}")
  }
  Thread.sleep(1000)
}
```