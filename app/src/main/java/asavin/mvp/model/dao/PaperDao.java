package asavin.mvp.model.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import asavin.mvp.model.entity.painting.Paper;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PAPER".
*/
public class PaperDao extends AbstractDao<Paper, Long> {

    public static final String TABLENAME = "PAPER";

    /**
     * Properties of entity Paper.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Price = new Property(0, Long.class, "price", false, "PRICE");
        public final static Property BrandId = new Property(1, Long.class, "brandId", false, "BRAND_ID");
        public final static Property ImageResource = new Property(2, String.class, "imageResource", false, "IMAGE_RESOURCE");
        public final static Property Id = new Property(3, Long.class, "id", true, "_id");
        public final static Property Name = new Property(4, String.class, "name", false, "NAME");
    }


    public PaperDao(DaoConfig config) {
        super(config);
    }
    
    public PaperDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PAPER\" (" + //
                "\"PRICE\" INTEGER NOT NULL ," + // 0: price
                "\"BRAND_ID\" INTEGER NOT NULL ," + // 1: brandId
                "\"IMAGE_RESOURCE\" TEXT NOT NULL ," + // 2: imageResource
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 3: id
                "\"NAME\" TEXT NOT NULL );"); // 4: name
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PAPER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Paper entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getPrice());
        stmt.bindLong(2, entity.getBrandId());
        stmt.bindString(3, entity.getImageResource());
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(4, id);
        }
        stmt.bindString(5, entity.getName());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Paper entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getPrice());
        stmt.bindLong(2, entity.getBrandId());
        stmt.bindString(3, entity.getImageResource());
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(4, id);
        }
        stmt.bindString(5, entity.getName());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3);
    }    

    @Override
    public Paper readEntity(Cursor cursor, int offset) {
        Paper entity = new Paper( //
            cursor.getLong(offset + 0), // price
            cursor.getLong(offset + 1), // brandId
            cursor.getString(offset + 2), // imageResource
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // id
            cursor.getString(offset + 4) // name
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Paper entity, int offset) {
        entity.setPrice(cursor.getLong(offset + 0));
        entity.setBrandId(cursor.getLong(offset + 1));
        entity.setImageResource(cursor.getString(offset + 2));
        entity.setId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setName(cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Paper entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Paper entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Paper entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
