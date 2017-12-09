package asavin.mvp.model.entity.bucket;

import android.content.Context;

import asavin.mvp.App;
import asavin.mvp.model.dao.BucketDao;
import asavin.mvp.model.dao.DaoSession;

/**
 * Created by 1 on 07.12.2017.
 */

public class BucketUtil {

    public static BucketUtil getBucket(){
        if (bucket == null)
            bucket = new BucketUtil();
       return bucket;
    }

    BucketDao bucketDao;
    private  static BucketUtil bucket;
    public  void addToBucket(long id,String tableName,Context ctx){
       if(bucketDao == null){
           DaoSession daoSession = ((App) ctx.getApplicationContext()).getDaoSession();
           bucketDao = daoSession.getBucketDao();
       }
       if(bucketDao.loadAll().size() == 0)
           bucketDao.insertOrReplace(new Bucket(1,tableName,id));
        else
            bucketDao.insert(new Bucket(tableName,id));
    }
}
