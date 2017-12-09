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
public class Feltpen {
    @NotNull
    Long price;

    @NotNull
    Long brandId;



    @Keep
    public Feltpen(String name, String imageResource,Long brandId,Long price) {
        this.price = price;
        this.brandId = brandId;
        this.imageResource = imageResource;

        this.name = name;
    }

    public Feltpen(String name) {
        this.name = name;
    }

    public Feltpen(){}

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }

    @NotNull

    String imageResource;

    @Keep
    public Feltpen(Long id, @NotNull String name, String imageResource) {
        this.imageResource = imageResource;
        this.id = id;
        this.name = name;
    }

    @Keep
    public Feltpen(String name, String imageResource) {
        this.imageResource = imageResource;
        this.name = name;
    }

    @Generated(hash = 1615722005)
    public Feltpen(@NotNull Long price, @NotNull Long brandId,
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

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public Feltpen(int id, String name) {
//
//        this.id = id;
//        this.name = name;
//    }
}
