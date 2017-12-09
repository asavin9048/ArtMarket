package asavin.mvp.model.entity.structure;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 1 on 07.12.2017.
 */
@Entity
public class HobbieProduct {
    @Id(autoincrement = true)
    long id;
    @NotNull
    String name;

    @Keep
    public HobbieProduct(long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    @Keep
    public HobbieProduct() {
    }



    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
