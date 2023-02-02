import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, StringType, StructType};

object Time_dim {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("t_time_sk", IntegerType)
            .add("t_time_id", StringType)
            .add("t_time", IntegerType)
            .add("t_hour", IntegerType)
            .add("t_minute", IntegerType)
            .add("t_second", IntegerType)
            .add("t_am_pm", StringType)
            .add("t_shift", StringType)
            .add("t_sub_shift", StringType)
            .add("t_meal_time", StringType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/time_dim.dat");
        df.write.parquet("../dataParquet/time_dim.parquet");
    }
}