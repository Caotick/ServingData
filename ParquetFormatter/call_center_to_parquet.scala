import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, DateType, StringType, StructType};

object Call_center {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("cc_call_center_sk", IntegerType)
            .add("cc_call_center_id", StringType)
            .add("cc_rec_start_date", DateType)
            .add("cc_rec_end_date", DateType)
            .add("cc_closed_date_sk", IntegerType)
            .add("cc_open_date_sk", IntegerType)
            .add("cc_name", StringType)
            .add("cc_class", StringType)
            .add("cc_employees", IntegerType)
            .add("cc_sq_ft", IntegerType)
            .add("cc_hours", StringType)
            .add("cc_manager", StringType)
            .add("cc_mkt_id", IntegerType)
            .add("cc_mkt_class", StringType)
            .add("cc_mkt_desc", StringType)
            .add("cc_market_manager", StringType)
            .add("cc_division", IntegerType)
            .add("cc_division_name", StringType)
            .add("cc_company", IntegerType)
            .add("cc_company_name", StringType)
            .add("cc_street_number", StringType)
            .add("cc_street_name", StringType)
            .add("cc_street_type", StringType)
            .add("cc_suite_number", StringType)
            .add("cc_city", StringType)
            .add("cc_county", StringType)
            .add("cc_state", StringType)
            .add("cc_zip", StringType)
            .add("cc_country", StringType)
            .add("cc_gmt_offset", DoubleType)
            .add("cc_tax_percentage", DoubleType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/call_center.dat");
        df.write.parquet("../dataParquet/call_center.parquet");
        println(df.show(1))
    }
}