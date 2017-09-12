
package counterserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import org.python.core.PyFunction;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

public class WebAPI {
    
    public static ArrayList<HeroData> GenerateHeroList(){
       
        ArrayList<HeroData> hl = loadHeroList();
        if(hl.isEmpty()){
            try{
                PythonInterpreter pi = new PythonInterpreter();
                pi.exec("from pymodule import heroList");
                PyFunction pf = (PyFunction)pi.get("heroList");
                String raw = pf.__call__(new PyString(AppDetails.DAPIKEY)).toString();
                ArrayList<String> rawParts = new ArrayList();
                rawParts.addAll(Arrays.asList(raw.split("\\{")));
                rawParts.remove(0);
                rawParts.set(rawParts.size() - 1,rawParts.get(rawParts.size() - 1).replace("]", ""));
                rawParts.stream().forEach((s) -> {
                    HeroData h = new HeroData();
                    String[] objParts = s.split(",");
                    h.setUrlVertPortrait(objParts[0].split(": ")[1].replaceAll("u'|'|\"|u\"", "").trim());
                    h.setName(objParts[1].split(": ")[1].replaceAll("u'|'|\"|u\"", "").trim().replace(" ", "-"));
                    h.setUrlFullPortrait(objParts[2].split(": ")[1].replaceAll("u'|'|\"|u\"", "").trim());
                    h.setUrlSmallPortrait(objParts[3].split(": ")[1].replaceAll("u'|'|\"|u\"", "").trim());
                    h.setId(objParts[5].split(": ")[1].replaceAll("u'|'|\"|u\"", "").trim());
                    h.setUrlLargePortrait(objParts[6].split(": ")[1].replaceAll("u'|'|\"|u\"", "").trim());
                    h.setPrimaryAttribute(Scrapper.findPrimaryAttribute(h.getName().toLowerCase()));
                    hl.add(h);
                });
                Collections.sort(hl, (HeroData h1, HeroData h2) -> h1.getName().compareToIgnoreCase(h2.getName()));
            }catch(Exception e){ System.out.println("Exception: " + e); }
        }
        saveHeroList(hl);
        return hl;
    }
    
    private static void saveHeroList(ArrayList<HeroData> hl){
        try{
            File in = new File("hl.mb");
            if(!in.exists()){
                in.createNewFile();
            }
            FileOutputStream fs = new FileOutputStream(in);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(hl);
        }catch(Exception e){ System.out.println("Exception: " + e); }
    }
    
    private static ArrayList<HeroData> loadHeroList(){
        ArrayList<HeroData> hl = new ArrayList();
        try{
            File in = new File("hl.mb");
            if(in.exists()){
                FileInputStream fs = new FileInputStream(in);
                ObjectInputStream os = new ObjectInputStream(fs);
                hl = (ArrayList<HeroData>)os.readObject();
            }
        }catch(Exception e){ System.out.println("Exception: " + e); }
        return hl;
    }

}
