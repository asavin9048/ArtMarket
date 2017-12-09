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
public class Paint {

    @NotNull
    Long price;




    @Keep
    public Paint(String name, String imageResource,Long brandId,Long price) {
        this.price = price;
        this.brandId = brandId;
        this.imageResource = imageResource;

        this.name = name;
    }

    @NotNull
    Long brandId;



    @Keep
    public Paint(String name, String imageResource,Long brandId) {
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
    public Paint( String name,String imageResource) {
        this.imageResource = imageResource;
        this.name = name;
    }

    public Paint(){}

    @Keep
    public Paint(Long id, @NotNull String name,String imageResource) {
        this.id = id;
        this.name = name;
    }
    @Keep
    public Paint(Long id,String name,String imageResource,Long brandId/*Long brandId, @NotNull String imageResource, Long id,
            @NotNull String name*/) {
        this.brandId = brandId;
        this.imageResource = imageResource;
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1976489597)
    public Paint(@NotNull Long price, @NotNull Long brandId, @NotNull String imageResource, Long id, @NotNull String name) {
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

//    public Paint(int id, String name) {
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
    public Long getBrandId() {
        return this.brandId;
    }
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    public Long getPrice() {
        return this.price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
}
