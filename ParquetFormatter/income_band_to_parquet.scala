import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, StructType};

object Income_band {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("ib_income_band_sk", IntegerType)
            .add("ib_lower_bound", IntegerType)
            .add("ib_upper_bound", IntegerType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/income_band.dat");
        df.write.parquet("../dataParquet/income_band.parquet");
    }
}