package asavin.mvp.model.entity.hobbie;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

import asavin.mvp.model.entity.bucket.Bucket;

/**
 * Created by 1 on 06.12.2017.
 */
@Entity
public class Burning {
    @NotNull
    Long price;

    @NotNull
    Long brandId;



    @Keep
    public Burning(String name, String imageResource,Long brandId,Long price) {
        this.price = price;
        this.brandId = brandId;
        this.imageResource = imageResource;

        this.name = name;
    }

    @NotNull
    String imageResource;

    public void setImageResource(String imageResource){
        this.imageResource = imageResource;
    }
    public String getImageResource(){
        return this.imageResource;
    }

    public Burning(){}

    public Burning(String name,String imageResource) {
        this.imageResource = imageResource;
        this.name = name;
    }

    @Keep
    public Burning(Long id, @NotNull String name,String imageResource) {
        this.imageResource = imageResource;

        this.id = id;
        this.name = name;
    }
    @Generated(hash = 2105385287)
    public Burning(@NotNull Long price, @NotNull Long brandId,
            @NotNull String imageResource, Long id, @NotNull String name) {
        this.price = price;
        this.brandId = brandId;
        this.imageResource = imageResource;
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Id(autoincrement = true)

    Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getPrice() {
        return this.price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    public Long getBrandId() {
        return this.brandId;
    }
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

//    public Burning(int id, String name) {
//
//        this.id = id;
//        this.name = name;
//    }
    @NotNull
    String name;
}
