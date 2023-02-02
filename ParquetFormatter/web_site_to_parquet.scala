import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, StringType, DateType, StructType};

object Web_site {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("web_site_sk", IntegerType)
            .add("web_site_id", StringType)
            .add("web_rec_start_date", DateType)
            .add("web_rec_end_date", DateType)
            .add("web_name", StringType)
            .add("web_open_date_sk", IntegerType)
            .add("web_close_date_sk", IntegerType)
            .add("web_class", StringType)
            .add("web_manager", StringType)
            .add("web_mkt_id", IntegerType)
            .add("web_mkt_class", StringType)
            .add("web_mkt_desc", StringType)
            .add("web_market_manager", StringType)
            .add("web_company_id", IntegerType)
            .add("web_company_name", StringType)
            .add("web_street_number", StringType)
            .add("web_street_name", StringType)
            .add("web_street_type", StringType)
            .add("web_suite_number", StringType)
            .add("web_city", StringType)
            .add("web_county", StringType)
            .add("web_state", StringType)
            .add("web_zip", StringType)
            .add("web_country", StringType)
            .add("web_gmt_offset", DoubleType)
            .add("web_tax_percentage", DoubleType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/web_site.dat");
        df.write.parquet("../dataParquet/web_site.parquet");
    }
}