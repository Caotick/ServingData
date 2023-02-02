import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, DoubleType, StringType, DateType, StructType};

object Item {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("i_item_sk", IntegerType)
            .add("i_item_id", StringType)
            .add("i_rec_start_date", DateType)
            .add("i_rec_end_date", DateType)
            .add("i_item_desc", StringType)
            .add("i_current_price", DoubleType)
            .add("i_wholesale_cost", DoubleType)
            .add("i_brand_id", IntegerType)
            .add("i_brand", StringType)
            .add("i_class_id", IntegerType)
            .add("i_class", StringType)
            .add("i_category_id", IntegerType)
            .add("i_category", StringType)
            .add("i_manufact_id", IntegerType)
            .add("i_manufact", StringType)
            .add("i_size", StringType)
            .add("i_formulation", StringType)
            .add("i_color", StringType)
            .add("i_units", StringType)
            .add("i_container", StringType)
            .add("i_manager_id", IntegerType)
            .add("i_product_name", StringType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/item.dat");
        df.write.parquet("../dataParquet/item.parquet");
    }
}