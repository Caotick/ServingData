import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, StructType};

object Inventory {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("inv_date_sk", IntegerType)
            .add("inv_item_sk", IntegerType)
            .add("inv_warehouse_sk", IntegerType)
            .add("inv_quantity_on_hand", IntegerType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/inventory.dat");
        df.write.parquet("../dataParquet/inventory.parquet");
    }
}