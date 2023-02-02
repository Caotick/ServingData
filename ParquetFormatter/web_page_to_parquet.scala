import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, StringType, DateType, StructType};

object Web_page {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("wp_web_page_sk", IntegerType)
            .add("wp_web_page_id", StringType)
            .add("wp_rec_start_date", DateType)
            .add("wp_rec_end_date", DateType)
            .add("wp_creation_date_sk", IntegerType)
            .add("wp_access_date_sk", IntegerType)
            .add("wp_autogen_flag", StringType)
            .add("wp_customer_sk", IntegerType)
            .add("wp_url", StringType)
            .add("wp_type", StringType)
            .add("wp_char_count", IntegerType)
            .add("wp_link_count", IntegerType)
            .add("wp_image_count", IntegerType)
            .add("wp_max_ad_count", IntegerType)

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/web_page.dat");
        df.write.parquet("../dataParquet/web_page.parquet");
    }
}