import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.{IntegerType, StringType, StructType};

object Customer_demographics {
    def main(args: Array[String]):Unit = {
        val spark = SparkSession.builder.appName("Spark").config("spark.master", "local").getOrCreate();

        val schema = new StructType()
            .add("cd_demo_sk", IntegerType)
            .add("cd_gender", StringType)
            .add("cd_marital_status", StringType)
            .add("cd_education_status", StringType)
            .add("cd_purchase_estimate", IntegerType)
            .add("cd_credit_rating", StringType)
            .add("cd_dep_count", IntegerType)
            .add("cd_dep_employed_count", IntegerType)
            .add("cd_dep_college_count", IntegerType);

        val df = spark.read.format("csv").option("header", false).option("delimiter", "|").schema(schema).load("../data/customer_demographics.dat");
        df.write.parquet("../dataParquet/customer_demographics.parquet");
    }
}