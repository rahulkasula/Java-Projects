package Stocks;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Objects;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.util.ToolRunner;


// StateClassification class: set state classification and transition state

public class StateClassification {
    public static class State_Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text>
    {
        String prev_stock_state = "Bull";
        private Text Name = new Text();
        private Text Stock = new Text();
        Double stored_price = 0.0;
        String stock_state = null;
        @Override
        public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter rprtr) throws IOException {
            String[] row = value.toString().split("\t"); // split row by tab
            Double stock_price = Double.parseDouble(row[1]); // take the second value
            String[] name_Extracted = value.toString().split("_");
            String Company_name = name_Extracted[0];
            if(stock_price > stored_price + 0.3)
            {
                stock_state = prev_stock_state + " to Bull" ;
                stored_price = stock_price;
                prev_stock_state = "Bull";
            }
            else if(stock_price < stored_price - 0.3)
            {
                stock_state = prev_stock_state + " to Bear";
                stored_price = stock_price;
                prev_stock_state = "Bear";
            }
            else
            {
                stock_state = prev_stock_state + " to Stagnant";
                stored_price = stock_price;
                prev_stock_state = "Stagnant";
            }
            Name.set(Company_name);
            Stock.set(stock_state);
            output.collect(Name, Stock);            
        }
    }
public static class State_Reduce extends MapReduceBase implements Reducer<Text, Text, Text, Text>
{
    private String stock_state;
    private Text matrix = new Text();
    private String output_string = null;
    DecimalFormat df = new DecimalFormat("0.0000");  
        @Override
        public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter rprtr) throws IOException {
    
            Double br_br = 0.0;
            Double br_bl = 0.0;
            Double br_st = 0.0;
            Double bl_bl = 0.0;
            Double bl_br = 0.0;
            Double bl_st = 0.0;
            Double st_bl = 0.0;
            Double st_br = 0.0;
            Double st_st = 0.0;
    
            while(values.hasNext())
            {
                stock_state = values.next().toString();
                
             if(stock_state.equals("Bear to Bear"))
             {
                 br_br++;
             }
             else if(stock_state.equals("Bear to Bull"))
             {
                 br_bl++;
             }
             else if(stock_state.equals("Bear to Stagnant"))
             {
                 br_st++;
             }
             else if(stock_state.equals("Bull to Bull"))
             {
                 bl_bl++;
             }
             else if(stock_state.equals("Bull to Bear"))
             {
                 bl_br++;
             }
             else if(stock_state.equals("Bull to Stagnant"))
             {
                 bl_st++;
             }
             else if(stock_state.equals("Stagnant to Bull"))
             {
                 st_bl++;
             }
             else if(stock_state.equals("Stagnant to Bear"))
             {
                 st_br++;
             }
             else if(stock_state.equals("Stagnant to Stagnant"))
             {
                 st_st++;
             }
             output_string = df.format(bl_bl/51) +"\t"+ df.format(bl_br/51)+"\t"+df.format(bl_st/51)+"\t"+df.format(br_bl/51)+"\t"+df.format(br_br/51)+"\t"+df.format(br_st/51)
                    +"\t"+df.format(st_bl/51)+"\t"+df.format(st_br/51)+"\t"+df.format(st_st/51);
            }
            
            matrix.set(output_string);
            output.collect(key, matrix);
        }
        static int printUsage()
        {
            System.out.println("StateClassification [-m <maps>] [-r <reduces> ] <input> <output>");
            ToolRunner.printGenericCommandUsage(System.out);
            return -1;
        }
    }
}