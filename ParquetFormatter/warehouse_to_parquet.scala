import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, StringType, StructType};

object Warehouse {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("w_warehouse_sk", IntegerType)
            .add("w_warehouse_id", StringType)
            .add("w_warehouse_name", StringType)
            .add("w_warehouse_sq_ft", IntegerType)
            .add("w_street_number", StringType)
            .add("w_street_name", StringType)
            .add("w_street_type", StringType)
            .add("w_suite_number", StringType)
            .add("w_city", StringType)
            .add("w_county", StringType)
            .add("w_state", StringType)
            .add("w_zip", StringType)
            .add("w_country", StringType)
            .add("w_gmt_offset", DoubleType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/warehouse.dat");
        df.write.parquet("../dataParquet/warehouse.parquet");
    }
}