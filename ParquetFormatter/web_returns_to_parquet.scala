import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, StructType};

object Web_returns {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("wr_returned_date_sk", IntegerType)
            .add("wr_returned_time_sk", IntegerType)
            .add("wr_item_sk", IntegerType)
            .add("wr_refunded_customer_sk", IntegerType)
            .add("wr_refunded_cdemo_sk", IntegerType)
            .add("wr_refunded_hdemo_sk", IntegerType)
            .add("wr_refunded_addr_sk", IntegerType)
            .add("wr_returning_customer_sk", IntegerType)
            .add("wr_returning_cdemo_sk", IntegerType)
            .add("wr_returning_hdemo_sk", IntegerType)
            .add("wr_returning_addr_sk", IntegerType)
            .add("wr_web_page_sk", IntegerType)
            .add("wr_reason_sk", IntegerType)
            .add("wr_order_number", IntegerType)
            .add("wr_return_quantity", IntegerType)
            .add("wr_return_amt", DoubleType)
            .add("wr_return_tax", DoubleType)
            .add("wr_return_amt_inc_tax", DoubleType)
            .add("wr_fee", DoubleType)
            .add("wr_return_ship_cost", DoubleType)
            .add("wr_refunded_cash", DoubleType)
            .add("wr_reversed_charge", DoubleType)
            .add("wr_account_credit", DoubleType)
            .add("wr_net_loss", DoubleType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/web_returns.dat");
        df.write.parquet("../dataParquet/web_returns.parquet");
    }
}