package asavin.mvp.model.entity.child;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 1 on 06.12.2017.
 */
@Entity
public class Coloring {

    @NotNull
    Long price;

    @NotNull
    Long brandId;



    @Keep
    public Coloring(String name, String imageResource,Long brandId,Long price) {
        this.price = price;
        this.brandId = brandId;
        this.imageResource = imageResource;

        this.name = name;
    }
//    public Coloring(){}
    @Id(autoincrement = true)
    Long id;

    @NotNull
    String imageResource;

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }

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
//
//    public Coloring(int id, String name) {
//
//        this.id = id;
//        this.name = name;
//    }
    @NotNull
    String name;

    public Coloring( String name,String imageResource) {
        this.imageResource = imageResource;
        this.name = name;
    }

    @Keep
    public Coloring(Long id, @NotNull String name,String imageResource) {
        this.id = id;
        this.name = name;

    }

    @Generated(hash = 1023775264)
    public Coloring() {
    }

    @Generated(hash = 1274808607)
    public Coloring(@NotNull Long price, @NotNull Long brandId, Long id,
            @NotNull String imageResource, @NotNull String name) {
        this.price = price;
        this.brandId = brandId;
        this.id = id;
        this.imageResource = imageResource;
        this.name = name;
    }
}
