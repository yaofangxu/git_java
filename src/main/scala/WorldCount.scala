import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time

object WorldCount {
  def main(args: Array[String]) {

  // Checking input parameters
  val params = ParameterTool.fromArgs(args)

  // set up the execution environment
  val env = StreamExecutionEnvironment.getExecutionEnvironment

  // make parameters available in the web interface
  env.getConfig.setGlobalJobParameters(params)

  // get input data

  val text =env.readTextFile("/Users/momo/Downloads/settings.xml")


  val counts: DataStream[(String, Int)] = text
    // split up the lines in pairs (2-tuples) containing: (word,1)
    .flatMap(_.toLowerCase.split("\\W+"))
    .filter(_.nonEmpty)
    .map((_, 1))
    // group by the tuple field "0" and sum up tuple field "1"
    .keyBy(0)
    .sum(1)

  // emit result
  if (params.has("output")) {
    counts.writeAsText(params.get("output"))
  } else {
    println("Printing result to stdout. Use --output to specify output path.")
    counts.print().setParallelism(1)
  }

  // execute program
  env.execute("Streaming WordCount")
}
}