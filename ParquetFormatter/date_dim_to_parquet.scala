import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, StringType, DateType, StructType};

object Date_dim {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("d_date_sk", IntegerType)
            .add("d_date_id", StringType)
            .add("d_date", DateType)
            .add("d_month_seq", IntegerType)
            .add("d_week_seq", IntegerType)
            .add("d_quarter_seq", IntegerType)
            .add("d_year", IntegerType)
            .add("d_dow", IntegerType)
            .add("d_moy", IntegerType)
            .add("d_dom", IntegerType)
            .add("d_qoy", IntegerType)
            .add("d_fy_year", IntegerType)
            .add("d_fy_quarter_seq", IntegerType)
            .add("d_fy_week_seq", IntegerType)
            .add("d_day_name", StringType)
            .add("d_quarter_name", StringType)
            .add("d_holiday", StringType)
            .add("d_weekend", StringType)
            .add("d_following_holiday", StringType)
            .add("d_first_dom", IntegerType)
            .add("d_last_dom", IntegerType)
            .add("d_same_day_ly", IntegerType)
            .add("d_same_day_lq", IntegerType)
            .add("d_current_day", StringType)
            .add("d_current_week", StringType)
            .add("d_current_month", StringType)
            .add("d_current_quarter", StringType)
            .add("d_current_year", StringType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/date_dim.dat");
        df.write.parquet("../dataParquet/date_dim.parquet");
    }
}