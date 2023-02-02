import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, StructType};

object Store_sales {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("ss_sold_date_sk", IntegerType)
            .add("ss_sold_time_sk", IntegerType)
            .add("ss_item_sk", IntegerType)
            .add("ss_customer_sk", IntegerType)
            .add("ss_cdemo_sk", IntegerType)
            .add("ss_hdemo_sk", IntegerType)
            .add("ss_addr_sk", IntegerType)
            .add("ss_store_sk", IntegerType)
            .add("ss_promo_sk", IntegerType)
            .add("ss_ticket_number", IntegerType)
            .add("ss_quantity", IntegerType)
            .add("ss_wholesale_cost", DoubleType)
            .add("ss_list_price", DoubleType)
            .add("ss_sales_price", DoubleType)
            .add("ss_ext_discount_amt", DoubleType)
            .add("ss_ext_sales_price", DoubleType)
            .add("ss_ext_wholesale_cost", DoubleType)
            .add("ss_ext_list_price", DoubleType)
            .add("ss_ext_tax", DoubleType)
            .add("ss_coupon_amt", DoubleType)
            .add("ss_net_paid", DoubleType)
            .add("ss_net_paid_inc_tax", DoubleType)
            .add("ss_net_profit", DoubleType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/store_sales.dat");
        df.write.parquet("../dataParquet/store_sales.parquet");
    }
}