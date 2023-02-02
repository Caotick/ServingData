import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, StringType, StructType};

object Reason {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("r_reason_sk", IntegerType)
            .add("r_reason_id", StringType)
            .add("r_reason_desc", StringType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/reason.dat");
        df.write.parquet("../dataParquet/reason.parquet");
    }
}