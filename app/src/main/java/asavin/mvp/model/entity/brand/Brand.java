package asavin.mvp.model.entity.brand;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 1 on 08.12.2017.
 */
@Entity
public class Brand {
    String description;

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

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id(autoincrement = true)
    Long id;
    @NotNull
    String name;
    @NotNull
    String imageResource;
    @Keep
    public Brand(Long id, @NotNull String name, @NotNull String imageResource) {
        this.id = id;
        this.name = name;
        this.imageResource = imageResource;
    }

    @Keep
    public Brand() {
    }
    @Keep
    public Brand(@NotNull String name,String description, @NotNull String imageResource) {
        this.description = description;
        this.name = name;
        this.imageResource = imageResource;
    }

    @Generated(hash = 1921145971)
    public Brand(String description, Long id, @NotNull String name,
            @NotNull String imageResource) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.imageResource = imageResource;
    }
}
