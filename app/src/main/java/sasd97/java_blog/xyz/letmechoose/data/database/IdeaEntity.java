package sasd97.java_blog.xyz.letmechoose.data.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import sasd97.java_blog.xyz.letmechoose.domain.models.IdeaModel;

/**
 * Created by alexander on 22/08/2017.
 */

@Entity(tableName = "ideas")
public class IdeaEntity {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "description")
    private String description;

    public static IdeaModel toModel(@NonNull IdeaEntity entity) {
        IdeaModel idea = new IdeaModel();
        idea.setDescription(entity.getDescription());
        return idea;
    }

    public static IdeaEntity fromModel(@NonNull IdeaModel model) {
        IdeaEntity entity = new IdeaEntity();
        entity.setDescription(model.getDescription());
        return entity;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IdeaEntity{");
        sb.append("uid=").append(uid);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
