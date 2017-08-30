
package Stocks;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.util.ToolRunner;
import Stocks.Convergence_Point.Convergence_Map;
import Stocks.Convergence_Point.Convergence_Reduce;
import Stocks.StateClassification.State_Map;
import Stocks.StateClassification.State_Reduce;

// Average class: Format the data and get averages
public class Average {

    public static class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> 
    {
    	public String companyName;
        private Text Stock = new Text();
        private Text Company_Name = new Text();
        
        @Override
        public void map(LongWritable k1, Text value, OutputCollector<Text, Text> output, Reporter rprtr) throws IOException 
        {
        	String lineString = value.toString();
        	String[] csvFields = lineString.split(",");  // Split line by commas
		//	if (csvFields[0] != null)
			companyName= csvFields[0];  // get the name from first field 1
			String input = csvFields[1]; // get closing prince from field 2
			Company_Name.set(companyName);
			Stock.set(input);
                   output.collect(Company_Name, Stock);                
            } 
    }

    
    public static class Reduce extends MapReduceBase implements Reducer<Text, Text, Text, Text>
    {
        int count = 0;
        Double Stock_avg = 0.0;
        @Override
        public void reduce(Text key,  Iterator<Text> values, OutputCollector<Text, Text> output, Reporter rprtr) throws IOException {
            
            Stock_avg = 0.0;
            count = 0;
            while(values.hasNext())
            {
                Stock_avg += Double.parseDouble(values.next().toString());
                count +=1;
            }
            Stock_avg = Stock_avg / count;
            output.collect(key, new Text(Stock_avg.toString()));           
        }
        static int printUsage()
        {
            System.out.println("Weekly_Prices [-m <maps>] [-r <reduces> ] <input> <output>");
            ToolRunner.printGenericCommandUsage(System.out);
            return -1;
        }
    }
    
 public static void main(String[] args) throws Exception { 
        // TODO code application logic here 
                
        JobConf conf = new JobConf(Average.class);
        conf.setJobName("Average");
        conf.setMapOutputKeyClass(Text.class);
        conf.setMapOutputValueClass(Text.class);
        conf.setMapperClass(mapper.class);
        conf.setReducerClass(Reduce.class);
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
        FileInputFormat.setInputPaths(conf,new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
        JobClient.runJob(conf);  
        
        JobConf conf1 = new JobConf(StateClassification.class);
        conf1.setJobName("StateClassification");
        conf1.setMapOutputKeyClass(Text.class);
        conf1.setMapOutputValueClass(Text.class);
        conf1.setMapperClass(State_Map.class);
        conf1.setReducerClass(State_Reduce.class);
        conf1.setInputFormat(TextInputFormat.class);
        conf1.setOutputFormat(TextOutputFormat.class);
        FileInputFormat.setInputPaths(conf1,new Path(args[2]));
        FileOutputFormat.setOutputPath(conf1, new Path(args[3]));
        JobClient.runJob(conf1); 
        
        JobConf conf2 = new JobConf(Convergence_Point.class);
        conf2.setJobName("Convergence Point");
        conf2.setMapOutputKeyClass(Text.class);
        conf2.setMapOutputValueClass(Text.class);
        conf2.setMapperClass(Convergence_Map.class);
        conf2.setReducerClass(Convergence_Reduce.class);
        conf2.setInputFormat(TextInputFormat.class);
        conf2.setOutputFormat(TextOutputFormat.class);
        FileInputFormat.setInputPaths(conf2,new Path(args[4]));
        FileOutputFormat.setOutputPath(conf2, new Path(args[5]));
        JobClient.runJob(conf2);
 }

}