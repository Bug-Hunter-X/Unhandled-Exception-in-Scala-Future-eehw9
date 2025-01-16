```scala
import scala.concurrent.{ExecutionContext, Future}

class MyClass(implicit ec: ExecutionContext) {
  def myMethod(i: Int): Future[Int] = Future {
    if (i == 0) throw new Exception("Zero is not allowed")
    i * 2
  }.recover { case e: Exception => 0 } //Handles exception
  //Alternative solution using recoverWith
  //def myMethod(i: Int): Future[Int] = Future {
  //  if (i == 0) throw new Exception("Zero is not allowed")
  //  i * 2
  //}.recoverWith { case e: Exception => Future.successful(0) }
}

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