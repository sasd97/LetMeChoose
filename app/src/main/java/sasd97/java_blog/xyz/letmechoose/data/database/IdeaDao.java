package sasd97.java_blog.xyz.letmechoose.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by alexander on 22/08/2017.
 */

@Dao
public interface IdeaDao {

    @Query("SELECT * from ideas")
    Single<List<IdeaEntity>> getAll();

    @Insert
    void insertAll(@NonNull List<IdeaEntity> entities);

    @Query("DELETE FROM ideas")
    void removeAll();
}
