package asavin.mvp.model.entity.bucket;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.query.QueryBuilder;

import asavin.mvp.App;
import asavin.mvp.model.dao.BurningDao;
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.entity.hobbie.Burning;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 1 on 07.12.2017.
 */
@Entity
public class Bucket {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Id(autoincrement = true)
    Long id;

    @NotNull
    String productName;

    @NotNull
    long productId;


    @Keep
    public Bucket(long id, @NotNull String productName, long productId) {
        this.id = id;
        this.productName = productName;
        this.productId = productId;
    }
    @Keep
    public Bucket( @NotNull String productName, long productId) {
        this.productName = productName;
        this.productId = productId;
    }

    @Generated(hash = 1958797461)
    public Bucket() {
    }

    @Generated(hash = 1649353702)
    public Bucket(Long id, @NotNull String productName, long productId) {
        this.id = id;
        this.productName = productName;
        this.productId = productId;
    }
}
