import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, StringType, StructType};

object Customer {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("c_customer_sk", IntegerType)
            .add("c_customer_id", StringType)
            .add("c_current_cdemo_sk", IntegerType)
            .add("c_current_hdemo_sk", IntegerType)
            .add("c_current_addr_sk", IntegerType)
            .add("c_first_shipto_date_sk", IntegerType)
            .add("c_first_sales_date_sk", IntegerType)
            .add("c_salutation", StringType)
            .add("c_first_name", StringType)
            .add("c_last_name", StringType)
            .add("c_preferred_cust_flag", StringType)
            .add("c_birth_day", IntegerType)
            .add("c_birth_month", IntegerType)
            .add("c_birth_year", IntegerType)
            .add("c_birth_country", StringType)
            .add("c_login", StringType)
            .add("c_email_address", StringType)
            .add("c_last_review_date_sk", IntegerType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/customer.dat");
        df.write.parquet("../dataParquet/customer.parquet");
    }
}