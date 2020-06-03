import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class cpu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		JSONObject object1 = new JSONObject();
		JSONArray val1=new JSONArray();
		
		File file=new File("C:\\java files\\Hackaton\\src\\CPU.txt");
		
		float maximum=0f;
		float tot=0f;
		float avg1=0f;
		
		int count=1;
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(file));
		
			String s="";
		
			
			while((s=br.readLine())!=null)
			{
				String s1=s.substring(42,46);
				
				s1=s1.trim();
				
				float val2=Float.parseFloat(s1);
				
				if(maximum<val2)
				{
					maximum=val2;
				}
				
				tot=tot+val2;
			
				//System.out.println(count+"s:"+s1);
				String cnt=count+"s";
				
				JSONObject ob = new JSONObject();
				ob.put(cnt,val2);
				val1.add(ob);
				
				count++;
			}
		}
		
		catch(Exception e)
		{
			
		}
		//System.out.println("count:"+count);
		
		avg1=tot/(count-1);
		
		double avg2 = Math.round(avg1 * 100.0) / 100.0;
		
		//System.out.println("max :"+max);
		//System.out.println("avg:"+avg1);
		
		
		object1.put("values",val1);
		object1.put("maxcpu",maximum);
		object1.put("Avgcpu",avg2);
		
		JSONObject rep=new JSONObject();
		
		rep.put("sampletransaction", object1);
		
		try
		{
		
		FileWriter fw=new FileWriter("C:\\java files\\Hackaton\\src\\JSONop.json");
		
		fw.write(rep.toString());
		fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		//reading file
		
		
		System.out.print(val1.toJSONString());
		
				JSONParser jsonParser = new JSONParser();
				
				
				try
				{
					FileReader reader = new FileReader("C:\\java files\\Hackaton\\src\\JSONop.json");
		            Object obj = jsonParser.parse(reader);
		            JSONObject jo=(JSONObject)obj;
		            
		            System.out.println(jo.toString());
		            
		            
		            
		            Double avg3=(Double)jo.get("AverageMemory(MB)");
		        } 
				catch(Exception e)
				{
					System.out.println(e);
				}
	}

}
