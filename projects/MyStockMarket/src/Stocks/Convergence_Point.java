package Stocks;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.util.ToolRunner;

// Convergence point class: multiply matrix till convergence
public class Convergence_Point {
    public static class Convergence_Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text>
    {
       
        private Text Stock = new Text();
        private Text Com_Name = new Text();
        Boolean stat = true;

        @Override
        public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter rprtr) throws IOException {
            int count = 1, check1 = 0;
            Double temp =  0.0;
            
            String[] row = value.toString().split("\t");
            Double check[][] = new Double[3][3];
            String Company_Name = row[0];
            Double state[][] = {{Double.parseDouble(row[1]), Double.parseDouble(row[2]), Double.parseDouble(row[3])}
                    ,{Double.parseDouble(row[4]), Double.parseDouble(row[5]), Double.parseDouble(row[6])}, 
                    {Double.parseDouble(row[7]), Double.parseDouble(row[8]), Double.parseDouble(row[9])}};
            
            Double mult_matrix[][] = new Double[3][3];
            
            for(int c =0; c <100; c++)
            {
                check1=0;
                for (int i = 0; i < 3; i++) { 
                for (int j = 0; j < 3; j++) { 
                for (int k = 0; k < 3; k++) { 
                temp += state[i][k] * state[k][j];
            }
                mult_matrix[i][j] = temp;
                
                temp = 0.0;
        }}
            
                for(int l = 0; l < 3; l++){
                for(int m = 0; m < 3; m++)
                {
                    Double diffValue = mult_matrix[l][m] - state[l][m];
                    
                    if(diffValue < 0.0) diffValue = diffValue * -1; 
                    if(diffValue <= 0.00001)
                    { 
                        stat= true;
                        check1 += 1;
                    }
                    else
                    {   stat = false;
                        state[l][m] = mult_matrix[l][m];
                          check1 = 0;  
                    }
                    System.out.println("Check1"+ "  " +check1);
                }}
                
                              
                count +=1;
                if(check1 ==9)c = 100;
            }
            
                        
            String output_string = ""+count;
            Stock.set(output_string);
            Com_Name.set(Company_Name);
            output.collect(Com_Name, Stock);            
        }
    }
    
    public static class Convergence_Reduce extends MapReduceBase implements Reducer<Text, Text, Text, Text>
    {
        private Text convergenceText = new Text();
        String convergence = null;
        @Override
        public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter rprtr) throws IOException {
            while(values.hasNext())
            {
                convergence = values.next().toString();
            }
            convergenceText.set(convergence);
            output.collect(key, convergenceText);
        }
    static int printUsage()
        {
            System.out.println("Convergence [-m <maps>] [-r <reduces> ] <input> <output>");
            ToolRunner.printGenericCommandUsage(System.out);
            return -1;
        }
    }
}
