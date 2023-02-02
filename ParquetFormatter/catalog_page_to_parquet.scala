import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, StringType, StructType};

object Catalog_page {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("cp_catalog_page_sk", IntegerType)
            .add("cp_catalog_page_id", StringType)
            .add("cp_start_date_sk", IntegerType)
            .add("cp_end_date_sk", IntegerType)
            .add("cp_department", StringType)
            .add("cp_catalog_number", IntegerType)
            .add("cp_catalog_page_number", IntegerType)
            .add("cp_description", StringType)
            .add("cp_type", StringType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/catalog_page.dat");
        df.write.parquet("../dataParquet/catalog_page.parquet");
    }
}