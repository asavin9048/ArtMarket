package asavin.mvp.model.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import asavin.mvp.model.entity.guide.Guide;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "GUIDE".
*/
public class GuideDao extends AbstractDao<Guide, Long> {

    public static final String TABLENAME = "GUIDE";

    /**
     * Properties of entity Guide.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property ImageResource = new Property(2, String.class, "imageResource", false, "IMAGE_RESOURCE");
        public final static Property Url = new Property(3, String.class, "url", false, "URL");
    }


    public GuideDao(DaoConfig config) {
        super(config);
    }
    
    public GuideDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GUIDE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"IMAGE_RESOURCE\" TEXT NOT NULL ," + // 2: imageResource
                "\"URL\" TEXT NOT NULL );"); // 3: url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GUIDE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Guide entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindString(3, entity.getImageResource());
        stmt.bindString(4, entity.getUrl());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Guide entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindString(3, entity.getImageResource());
        stmt.bindString(4, entity.getUrl());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Guide readEntity(Cursor cursor, int offset) {
        Guide entity = new Guide( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.getString(offset + 2), // imageResource
            cursor.getString(offset + 3) // url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Guide entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setImageResource(cursor.getString(offset + 2));
        entity.setUrl(cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Guide entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Guide entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Guide entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}