package asavin.mvp.model.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import asavin.mvp.model.entity.brand.Brand;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BRAND".
*/
public class BrandDao extends AbstractDao<Brand, Long> {

    public static final String TABLENAME = "BRAND";

    /**
     * Properties of entity Brand.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Description = new Property(0, String.class, "description", false, "DESCRIPTION");
        public final static Property Id = new Property(1, Long.class, "id", true, "_id");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property ImageResource = new Property(3, String.class, "imageResource", false, "IMAGE_RESOURCE");
    }


    public BrandDao(DaoConfig config) {
        super(config);
    }
    
    public BrandDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BRAND\" (" + //
                "\"DESCRIPTION\" TEXT," + // 0: description
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 1: id
                "\"NAME\" TEXT NOT NULL ," + // 2: name
                "\"IMAGE_RESOURCE\" TEXT NOT NULL );"); // 3: imageResource
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BRAND\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Brand entity) {
        stmt.clearBindings();
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(1, description);
        }
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(2, id);
        }
        stmt.bindString(3, entity.getName());
        stmt.bindString(4, entity.getImageResource());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Brand entity) {
        stmt.clearBindings();
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(1, description);
        }
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(2, id);
        }
        stmt.bindString(3, entity.getName());
        stmt.bindString(4, entity.getImageResource());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1);
    }    

    @Override
    public Brand readEntity(Cursor cursor, int offset) {
        Brand entity = new Brand( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // description
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // id
            cursor.getString(offset + 2), // name
            cursor.getString(offset + 3) // imageResource
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Brand entity, int offset) {
        entity.setDescription(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setName(cursor.getString(offset + 2));
        entity.setImageResource(cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Brand entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Brand entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Brand entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
