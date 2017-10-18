package zerozero.com.preorder.test.common;

import org.json.JSONArray;
import java.io.*;


/**
 * Created by yangfan on 16/3/15.
 */
public class ConfReader {
    public final String json_testdata = "/testData.json";

    public JSONArray readDataConf(String conf)
    {
        String cf = "";
        JSONArray jsonArray = null;

        try{
            cf = getClass().getResource(conf).getPath();
        }
        catch(Exception e){e.printStackTrace();}


        try{
            System.out.println("Configuration Path:" + cf);
            jsonArray = new JSONArray(ReadFile(cf));

        } catch (Exception e){
            e.printStackTrace();
        }
        return jsonArray;
    }

    public String ReadFile(String Path){
        BufferedReader reader = null;
        String laststr = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }
}

