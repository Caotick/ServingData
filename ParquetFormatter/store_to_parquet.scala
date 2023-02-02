import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, StringType, DateType, StructType};

object Store {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("s_store_sk", IntegerType)
            .add("s_store_id", StringType)
            .add("s_rec_start_date", DateType)
            .add("s_rec_end_date", DateType)
            .add("s_closed_date_sk", IntegerType)
            .add("s_store_name", StringType)
            .add("s_number_employees", IntegerType)
            .add("s_floor_space", IntegerType)
            .add("s_hours", StringType)
            .add("s_manager", StringType)
            .add("s_market_id", IntegerType)
            .add("s_geography_class", StringType)
            .add("s_market_desc", StringType)
            .add("s_market_manager", StringType)
            .add("s_division_id", IntegerType)
            .add("s_division_name", StringType)
            .add("s_company_id", IntegerType)
            .add("s_company_name", StringType)
            .add("s_street_number", StringType)
            .add("s_street_name", StringType)
            .add("s_street_type", StringType)
            .add("s_suite_number", StringType)
            .add("s_city", StringType)
            .add("s_county", StringType)
            .add("s_state", StringType)
            .add("s_zip", StringType)
            .add("s_country", StringType)
            .add("s_gmt_offset", DoubleType)
            .add("s_tax_percentage", DoubleType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/store.dat");
        df.write.parquet("../dataParquet/store.parquet");
    }
}