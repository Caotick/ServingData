



select * from (select  sum(cs_ext_discount_amt)  as "excess discount amount" 
from 
   "catalog_sales.parquet" 
   ,"item.parquet" 
   ,"date_dim.parquet"
where
i_manufact_id = 29
and i_item_sk = cs_item_sk 
and d_date between '1999-01-07' and 
        cast(date_add('1999-01-07', 90) as date)
and d_date_sk = cs_sold_date_sk 
and cs_ext_discount_amt  
     > ( 
         select 
            1.3 * avg(cs_ext_discount_amt) 
         from 
            "catalog_sales.parquet" 
           ,"date_dim.parquet"
         where 
              cs_item_sk = i_item_sk 
          and d_date between '1999-01-07' and
                             cast(date_add('1999-01-07', 90) as date)
          and d_date_sk = cs_sold_date_sk 
      ) 
 ) limit 100;