
package counterserver;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import java.util.ArrayList;
import java.util.Comparator;

public class Scrapper {
    
    public static ArrayList<HeroComparison> generateComparisonsFromHero(String parent){// parent represents the hero to be compared too!
        try{
            int indexOfParent = 0;
            for(HeroData h : CounterServer.heroes){
                if(h.getName().equals(parent))
                    indexOfParent = CounterServer.heroes.indexOf(h);
            }
            UserAgent userAgent = new UserAgent();
            userAgent.visit("https://www.dotabuff.com/heroes/"+parent.toLowerCase()+"/matchups");
            Element heroTable = userAgent.doc.findFirst("<div class=content-inner>").findFirst("<tbody>");
            Elements heroRows = heroTable.findEach("<tr>");
            ArrayList<HeroComparison> comparisons = new ArrayList();
            for(Element e : heroRows){
                Elements columns = e.getEach("<td>");
                String name = columns.getElement(1).innerHTML().substring(64).split("\"")[0];
                double advantage = Double.parseDouble(columns.getElement(2).innerHTML().substring(0,5).replace("%",""));
                double winRate = Double.parseDouble(columns.getElement(3).innerHTML().substring(0,5));
                int matches = Integer.parseInt(columns.getElement(4).innerHTML().split("<")[0].replace(",",""));
                HeroComparison h = new HeroComparison(name,advantage,winRate,matches);
                comparisons.add(h);
            }
            comparisons.sort(Comparator.comparing(HeroComparison::getHeroName));
            HeroComparison self = new HeroComparison(parent,0,0,0);
            comparisons.add(indexOfParent, self);
            return comparisons; // returns a list of heroes with stats in relation to the parent hero
        }
        catch(JauntException | NumberFormatException e){
            System.out.println(e);
            return new ArrayList();
        }
    }
    
    public static String findPrimaryAttribute(String name){
        String attr = "";
        try{
            UserAgent userAgent = new UserAgent();
            userAgent.visit("https://www.dotabuff.com/heroes/"+name);
            Element attTable = userAgent.doc.findFirst("<section class=hero_attributes").findFirst("<tbody>");
            attr = attTable.getAt("class").replace("primary-","");
        }catch(NullPointerException | ResponseException | NotFound e){ System.out.println("Exception: " + e); }
        return attr;
    }
    
}
