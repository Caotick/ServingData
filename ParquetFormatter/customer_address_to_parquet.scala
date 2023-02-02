import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, StringType, StructType};

object Customer_address {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("ca_address_sk", IntegerType)
            .add("ca_address_id", StringType)
            .add("ca_street_number", StringType)
            .add("ca_street_name", StringType)
            .add("ca_street_type", StringType)
            .add("ca_suite_number", StringType)
            .add("ca_city", StringType)
            .add("ca_county", StringType)
            .add("ca_state", StringType)
            .add("ca_zip", StringType)
            .add("ca_country", StringType)
            .add("ca_gmt_offset", DoubleType)
            .add("ca_location_type", StringType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/customer_address.dat");
        df.write.parquet("../dataParquet/customer_address.parquet");
    }
}