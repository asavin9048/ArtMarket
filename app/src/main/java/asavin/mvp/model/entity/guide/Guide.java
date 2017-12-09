package asavin.mvp.model.entity.guide;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Guide {

    @Keep
    public Guide( @NotNull String name, String imageResource,String url) {
        this.url = url;
        this.imageResource = imageResource;
        this.name = name;
    }

    @NotNull
    String url;

    @NotNull
    String imageResource;

    public void setImageResource(String imageResource){
        this.imageResource = imageResource;
    }
    public String getImageResource(){
        return this.imageResource;
    }

    public Guide(){}

    @Keep
    public Guide(Long id, @NotNull String name, String imageResource,String url) {
        this.url = url;
        this.imageResource = imageResource;
        this.id = id;
        this.name = name;
    }
    @Id(autoincrement = true)
    Long id;
    @NotNull
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

//    public Guide(int id, String name) {
//
//        this.id = id;
//        this.name = name;
//    }
}
