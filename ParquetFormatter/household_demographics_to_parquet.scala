import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, StringType, StructType};

object Household_demographics {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("hd_demo_sk", IntegerType)
            .add("hd_income_band_sk", IntegerType)
            .add("hd_buy_potential", StringType)
            .add("hd_dep_count", IntegerType)
            .add("hd_vehicle_count", IntegerType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/household_demographics.dat");
        df.write.parquet("../dataParquet/household_demographics.parquet");
    }
}