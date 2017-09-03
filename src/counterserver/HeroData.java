
package counterserver;

public class HeroData implements java.io.Serializable{
    
    private String urlVertPortrait;
    private String urlFullPortrait;
    private String urlSmallPortrait;
    private String name;
    private String id;
    private String urlLargePortrait;
    private String primaryAttribute;

    public HeroData() {
        this.urlVertPortrait = null;
        this.urlSmallPortrait = null;
        this.name = null;
        this.id = null;
        this.urlLargePortrait = null;
        this.primaryAttribute = null;
    }

    public HeroData(String urlVertPortrait, String urlFullPortrait, String urlSmallPortrait, String name, String id, String urlLargePortrait, String primaryAttribute) {
        this.urlVertPortrait = urlVertPortrait;
        this.urlFullPortrait = urlFullPortrait;
        this.urlSmallPortrait = urlSmallPortrait;
        this.name = name;
        this.id = id;
        this.urlLargePortrait = urlLargePortrait;
        this.primaryAttribute = primaryAttribute;
    }

    public String getUrlVertPortrait() {
        return urlVertPortrait;
    }

    public void setUrlVertPortrait(String urlVertPortrait) {
        this.urlVertPortrait = urlVertPortrait;
    }

    public String getUrlFullPortrait() {
        return urlFullPortrait;
    }

    public void setUrlFullPortrait(String urlFullPortrait) {
        this.urlFullPortrait = urlFullPortrait;
    }

    public String getUrlSmallPortrait() {
        return urlSmallPortrait;
    }

    public void setUrlSmallPortrait(String urlSmallPortrait) {
        this.urlSmallPortrait = urlSmallPortrait;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlLargePortrait() {
        return urlLargePortrait;
    }

    public void setUrlLargePortrait(String urlLargePortrait) {
        this.urlLargePortrait = urlLargePortrait;
    }

    public String getPrimaryAttribute() {
        return primaryAttribute;
    }

    public void setPrimaryAttribute(String primaryAttribute) {
        this.primaryAttribute = primaryAttribute;
    }
       
}
