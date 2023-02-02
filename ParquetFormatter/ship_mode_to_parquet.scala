import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, StringType, StructType};

object Ship_mode {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("sm_ship_mode_sk", IntegerType)
            .add("sm_ship_mode_id", StringType)
            .add("sm_type", StringType)
            .add("sm_code", StringType)
            .add("sm_carrier", StringType)
            .add("sm_contract", StringType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/ship_mode.dat");
        df.write.parquet("../dataParquet/ship_mode.parquet");
    }
}