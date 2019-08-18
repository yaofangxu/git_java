import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

object SocketConsumer {
  def main(args: Array[String]): Unit = {



    val env=StreamExecutionEnvironment.getExecutionEnvironment
    env.socketTextStream("localhost", 9000).print()

    env.execute("1")


  }



}
