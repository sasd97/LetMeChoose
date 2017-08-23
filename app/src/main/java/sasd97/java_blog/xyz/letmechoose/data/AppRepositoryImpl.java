package sasd97.java_blog.xyz.letmechoose.data;

import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import sasd97.java_blog.xyz.letmechoose.data.database.AppDatabase;
import sasd97.java_blog.xyz.letmechoose.data.database.IdeaEntity;
import sasd97.java_blog.xyz.letmechoose.domain.models.IdeaModel;

/**
 * Created by alexander on 17/07/2017.
 */

public class AppRepositoryImpl implements AppRepository {

    private AppDatabase database;
    private List<IdeaModel> ideas = new ArrayList<>();

    public AppRepositoryImpl(@NonNull AppDatabase database) {
        this.database = database;
    }

    @Override
    public void setIdeas(List<IdeaModel> ideas) {
        if (ideas == null) return;
        this.ideas = ideas;
    }

    @Override
    public List<IdeaModel> addIdea(IdeaModel idea) {
        ideas.add(idea);
        return ideas;
    }

    @Override
    public List<IdeaModel> getIdeas() {
        return ideas;
    }

    @Override
    public List<IdeaModel> removeIdea(int position) {
        ideas.remove(position);
        return ideas;
    }

    @Override
    public void clearIdeas() {
        ideas.clear();
    }

    @Override
    public Single<List<IdeaModel>> getCachedIdeas() {
        return database.ideaDao()
                .getAll()
                .flatMap(ideaEntities -> {
                    List<IdeaModel> models = new ArrayList<>();
                    for (IdeaEntity entity: ideaEntities) {
                        models.add(IdeaEntity.toModel(entity));
                    }
                    return Single.just(models);
                });
    }

    @Override
    public Completable saveIdeas() {
        List<IdeaEntity> models = new ArrayList<>();
        for (IdeaModel entity: ideas) {
            models.add(IdeaEntity.fromModel(entity));
        }

        return Completable
                .fromAction(() -> {
                    database.ideaDao().removeAll();
                    database.ideaDao().insertAll(models);
                });
    }
}
