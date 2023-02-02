import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, StructType};

object Web_sales {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("ws_sold_date_sk", IntegerType)
            .add("ws_sold_time_sk", IntegerType)
            .add("ws_ship_date_sk", IntegerType)
            .add("ws_item_sk", IntegerType)
            .add("ws_bill_customer_sk", IntegerType)
            .add("ws_bill_cdemo_sk", IntegerType)
            .add("ws_bill_hdemo_sk", IntegerType)
            .add("ws_bill_addr_sk", IntegerType)
            .add("ws_ship_customer_sk", IntegerType)
            .add("ws_ship_cdemo_sk", IntegerType)
            .add("ws_ship_hdemo_sk", IntegerType)
            .add("ws_ship_addr_sk", IntegerType)
            .add("ws_web_page_sk", IntegerType)
            .add("ws_web_site_sk", IntegerType)
            .add("ws_ship_mode_sk", IntegerType)
            .add("ws_warehouse_sk", IntegerType)
            .add("ws_promo_sk", IntegerType)
            .add("ws_order_number", IntegerType)
            .add("ws_quantity", IntegerType)
            .add("ws_wholesale_cost", DoubleType)
            .add("ws_list_price", DoubleType)
            .add("ws_sales_price", DoubleType)
            .add("ws_ext_discount_amt", DoubleType)
            .add("ws_ext_sales_price", DoubleType)
            .add("ws_ext_wholesale_cost", DoubleType)
            .add("ws_ext_list_price", DoubleType)
            .add("ws_ext_tax", DoubleType)
            .add("ws_coupon_amt", DoubleType)
            .add("ws_ext_ship_cost", DoubleType)
            .add("ws_net_paid", DoubleType)
            .add("ws_net_paid_inc_tax", DoubleType)
            .add("ws_net_paid_inc_ship", DoubleType)
            .add("ws_net_paid_inc_ship_tax", DoubleType)
            .add("ws_net_profit", DoubleType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/web_sales.dat");
        df.write.parquet("../dataParquet/web_sales.parquet");
    }
}