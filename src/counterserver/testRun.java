
package counterserver;

import com.google.gson.Gson;
import java.util.ArrayList;

public class testRun {
    
    public static void main(String[] args){
//        Gson gson = new Gson();
          CounterServer.heroes = WebAPI.GenerateHeroList();
//        for(HeroData h : hl){
//            System.out.println(h.getName());
//        }
        
        Scrapper.generateComparisonsFromHero("anti-mage").forEach((h)->{
            System.out.println(h.getHeroName());
        });
        //String jStr = gson.toJson(hl);
        //System.out.println(jStr.length());
//        HeroData[] reSon = gson.fromJson(jStr, HeroData[].class);
//        for(HeroData h : reSon){
//            System.out.println(h.getName() + ", " + h.getPrimaryAttribute());
//        }
    }  
}
