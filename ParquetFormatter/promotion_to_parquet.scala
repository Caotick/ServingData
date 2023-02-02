import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, StringType, StructType};

object Promotion {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("p_promo_sk", IntegerType)
            .add("p_promo_id", StringType)
            .add("p_start_date_sk", IntegerType)
            .add("p_end_date_sk", IntegerType)
            .add("p_item_sk", IntegerType)
            .add("p_cost", DoubleType)
            .add("p_response_target", IntegerType)
            .add("p_promo_name", StringType)
            .add("p_channel_dmail", StringType)
            .add("p_channel_email", StringType)
            .add("p_channel_catalog", StringType)
            .add("p_channel_tv", StringType)
            .add("p_channel_radio", StringType)
            .add("p_channel_press", StringType)
            .add("p_channel_event", StringType)
            .add("p_channel_demo", StringType)
            .add("p_channel_details", StringType)
            .add("p_purpose", StringType)
            .add("p_discount_active", StringType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/promotion.dat");
        df.write.parquet("../dataParquet/promotion.parquet");
    }
}