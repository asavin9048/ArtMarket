package asavin.mvp.model.entity.painting;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 1 on 06.12.2017.
 */
@Entity
public class Easel {
    @NotNull
    Long price;

    @NotNull
    Long brandId;



    @Keep
    public Easel(String name, String imageResource,Long brandId,Long price) {
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
    @Keep
    public Easel( String name,String imageResource) {
        this.imageResource = imageResource;
        this.name = name;
    }


    public Easel(){}

    @Keep
    public Easel(Long id, @NotNull String name,String imageResource) {
        this.imageResource = imageResource;
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1231988458)
    public Easel(@NotNull Long price, @NotNull Long brandId,
            @NotNull String imageResource, Long id, @NotNull String name) {
        this.price = price;
        this.brandId = brandId;
        this.imageResource = imageResource;
        this.id = id;
        this.name = name;
    }
    @Id(autoincrement = true)
    Long id;
    @NotNull
    String name;
//
//    public Easel(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }

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
}
