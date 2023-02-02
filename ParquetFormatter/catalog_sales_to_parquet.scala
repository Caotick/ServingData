import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, StructType};

object Catalog_sales {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("cs_sold_date_sk", IntegerType)
            .add("cs_sold_time_sk", IntegerType)
            .add("cs_ship_date_sk", IntegerType)
            .add("cs_bill_customer_sk", IntegerType)
            .add("cs_bill_cdemo_sk", IntegerType)
            .add("cs_bill_hdemo_sk", IntegerType)
            .add("cs_bill_addr_sk", IntegerType)
            .add("cs_ship_customer_sk", IntegerType)
            .add("cs_ship_cdemo_sk", IntegerType)
            .add("cs_ship_hdemo_sk", IntegerType)
            .add("cs_ship_addr_sk", IntegerType)
            .add("cs_call_center_sk", IntegerType)
            .add("cs_catalog_page_sk", IntegerType)
            .add("cs_ship_mode_sk", IntegerType)
            .add("cs_warehouse_sk", IntegerType)
            .add("cs_item_sk", IntegerType)
            .add("cs_promo_sk", IntegerType)
            .add("cs_order_number", IntegerType)
            .add("cs_quantity", IntegerType)
            .add("cs_wholesale_cost", DoubleType)
            .add("cs_list_price", DoubleType)
            .add("cs_sales_price", DoubleType)
            .add("cs_ext_discount_amt", DoubleType)
            .add("cs_ext_sales_price", DoubleType)
            .add("cs_ext_wholesale_cost", DoubleType)
            .add("cs_ext_list_price", DoubleType)
            .add("cs_ext_tax", DoubleType)
            .add("cs_coupon_amt", DoubleType)
            .add("cs_ext_ship_cost", DoubleType)
            .add("cs_net_paid", DoubleType)
            .add("cs_net_paid_inc_tax", DoubleType)
            .add("cs_net_paid_inc_ship", DoubleType)
            .add("cs_net_paid_inc_ship_tax", DoubleType)
            .add("cs_net_profit", DoubleType)

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/catalog_sales.dat");
        df.write.parquet("../dataParquet/catalog_sales.parquet");
    }
}