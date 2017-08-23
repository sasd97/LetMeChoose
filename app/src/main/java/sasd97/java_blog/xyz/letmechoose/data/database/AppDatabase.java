package sasd97.java_blog.xyz.letmechoose.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by alexander on 22/08/2017.
 */

@Database(entities = {IdeaEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "ideas.database";

    public abstract IdeaDao ideaDao();
}
