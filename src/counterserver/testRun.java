
package counterserver;

import com.google.gson.Gson;
import java.util.ArrayList;

public class testRun {
    
    public static void main(String[] args){
        Gson gson = new Gson();
        ArrayList<HeroData> hl = WebAPI.GenerateHeroList();
        String jStr = gson.toJson(hl);
        System.out.println(jStr.length());
//        HeroData[] reSon = gson.fromJson(jStr, HeroData[].class);
//        for(HeroData h : reSon){
//            System.out.println(h.getName() + ", " + h.getPrimaryAttribute());
//        }
    }  
}
