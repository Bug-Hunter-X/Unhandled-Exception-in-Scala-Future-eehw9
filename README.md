# Unhandled Exception in Scala Future
This repository demonstrates a common issue in Scala: not handling exceptions thrown within `Future`s. The `Bug.scala` file contains code that throws an exception if the input to `myMethod` is 0. However, this exception is not properly caught, leading to potential problems in a real application.

The solution, found in `BugSolution.scala`, utilizes a `recover` or `recoverWith` method to gracefully handle the exception, preventing unexpected termination or silent failure.