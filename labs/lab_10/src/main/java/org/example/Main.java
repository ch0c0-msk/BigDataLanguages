package org.example;

import org.apache.spark.sql.*;
import org.apache.spark.api.java.JavaSparkContext;

public class Main {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("Main")
                .master("local[*]")
                .getOrCreate();
        spark.sparkContext().setLogLevel("ERROR");

        JavaSparkContext jsc = new JavaSparkContext(
                spark.sparkContext());

        Dataset<Row> dataset = spark.read().format("csv")
                .option("header", "true")
                .load(System.getProperty("user.dir")+ "/src/main/resources/who_suicide_statistics.csv");

        dataset.createOrReplaceTempView("suicide_tab");

        System.out.println("\n\n\n1. all");
        spark.sql("select * from suicide_tab").show();

        System.out.println("\n\n\n2. Total number of suicides per country for 2007 year");
        spark.sql("select country, sum(suicides_no) as total_suicides from suicide_tab where year = 2007 group by country").show();

        System.out.println("\n\n\n3. Total number of suicides per year");
        spark.sql("select year, sum(suicides_no) as total_suicides from suicide_tab group by year").show();

        System.out.println("\n\n\n4. Total number of suicides per gender");
        spark.sql("select sex, sum(suicides_no) as total_suicides from suicide_tab group by sex").show();

        System.out.println("\n\n\n5. Average population for each country");
        spark.sql("select country, avg(population) as avg_population from suicide_tab group by country").show();

        System.out.println("\n\n\n6. Total number of suicides per age group");
        spark.sql("select age, sum(suicides_no) as total_suicides from suicide_tab group by age").show();

        System.out.println("\n\n\n7. Countries with the highest total number of suicides");
        spark.sql("select country, sum(suicides_no) as total_suicides from suicide_tab group by country order by total_suicides desc nulls last").show();

        System.out.println("\n\n\n8. Years with the highest total number of suicides");
        spark.sql("select year, sum(suicides_no) as total_suicides from suicide_tab group by year order by total_suicides desc nulls last").show();

        System.out.println("\n\n\n9. Suicides in Russia by year");
        spark.sql("select year, sum(suicides_no) as total_suicides from suicide_tab where country = 'Russian Federation' group by year order by year desc").show();

        System.out.println("\n\n\n10. Suicides in Russia by sex and age group");
        spark.sql("select sex, age, sum(suicides_no) as total_suicides from suicide_tab where country = 'Russian Federation' group by sex, age order by sex, age").show();
        // Stop the SparkSession and JavaSparkContext
        spark.stop();
        jsc.stop();
    }
}