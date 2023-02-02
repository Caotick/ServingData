import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, StructType};

object Catalog_returns {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("cr_returned_date_sk", IntegerType)
            .add("cr_returned_time_sk", IntegerType)
            .add("cr_item_sk", IntegerType)
            .add("cr_refunded_customer_sk", IntegerType)
            .add("cr_refunded_cdemo_sk", IntegerType)
            .add("cr_refunded_hdemo_sk", IntegerType)
            .add("cr_refunded_addr_sk", IntegerType)
            .add("cr_returning_customer_sk", IntegerType)
            .add("cr_returning_cdemo_sk", IntegerType)
            .add("cr_returning_hdemo_sk", IntegerType)
            .add("cr_returning_addr_sk", IntegerType)
            .add("cr_call_center_sk", IntegerType)
            .add("cr_catalog_page_sk", IntegerType)
            .add("cr_ship_mode_sk", IntegerType)
            .add("cr_warehouse_sk", IntegerType)
            .add("cr_reason_sk", IntegerType)
            .add("cr_order_number", IntegerType)
            .add("cr_return_quantity", IntegerType)
            .add("cr_return_amount", DoubleType)
            .add("cr_return_tax", DoubleType)
            .add("cr_return_amt_inc_tax", DoubleType)
            .add("cr_fee", DoubleType)
            .add("cr_return_ship_cost", DoubleType)
            .add("cr_refunded_cash", DoubleType)
            .add("cr_reversed_charge", DoubleType)
            .add("cr_store_credit", DoubleType)
            .add("cr_net_loss", DoubleType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/catalog_returns.dat");
        df.write.parquet("../dataParquet/catalog_returns.parquet");
    }
}