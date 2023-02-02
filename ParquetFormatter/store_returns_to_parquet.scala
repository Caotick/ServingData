import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, StructType};

object Store_returns {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("sr_returned_date_sk", IntegerType)
            .add("sr_return_time_sk", IntegerType)
            .add("sr_item_sk", IntegerType)
            .add("sr_customer_sk", IntegerType)
            .add("sr_cdemo_sk", IntegerType)
            .add("sr_hdemo_sk", IntegerType)
            .add("sr_addr_sk", IntegerType)
            .add("sr_store_sk", IntegerType)
            .add("sr_reason_sk", IntegerType)
            .add("sr_ticket_number", IntegerType)
            .add("sr_return_quantity", IntegerType)
            .add("sr_return_amt", DoubleType)
            .add("sr_return_tax", DoubleType)
            .add("sr_return_amt_inc_tax", DoubleType)
            .add("sr_fee", DoubleType)
            .add("sr_return_ship_cost", DoubleType)
            .add("sr_refunded_cash", DoubleType)
            .add("sr_reversed_charge", DoubleType)
            .add("sr_store_credit", DoubleType)
            .add("sr_net_loss", DoubleType)

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/store_returns.dat");
        df.write.parquet("../dataParquet/store_returns.parquet");
    }
}