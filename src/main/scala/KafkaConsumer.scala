import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.CheckpointingMode
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer09

object KafkaConsumer {



    def main(args: Array[String]) {


      val env = StreamExecutionEnvironment.getExecutionEnvironment

      //默认与语义就是精准一次

      env.enableCheckpointing(5000)

      //env.getCheckpointConfig.setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE)

      env.setMaxParallelism(5)

      // get input data


      val properties = new Properties()
      properties.setProperty("bootstrap.servers", "localhost:9092")
      // only required for Kafka 0.8
      //properties.setProperty("zookeeper.connect", "localhost:2181/kafka")
      properties.setProperty("group.id", "test")


      val myConsumer: FlinkKafkaConsumer09[String] = new FlinkKafkaConsumer09[String]("test", new SimpleStringSchema(), properties)


      val transaction = env.addSource(myConsumer)

      transaction.print()


      // execute program
      env.execute("Streaming WordCount")
    }
  }


