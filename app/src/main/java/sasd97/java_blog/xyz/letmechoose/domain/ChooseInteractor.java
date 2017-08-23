package sasd97.java_blog.xyz.letmechoose.domain;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import sasd97.java_blog.xyz.letmechoose.domain.models.IdeaModel;

/**
 * Created by alexander on 17/07/2017.
 */

public interface ChooseInteractor {
    List<IdeaModel> addIdea(IdeaModel idea);
    Single<List<IdeaModel>> getIdeas();
    List<IdeaModel> removeIdea(int position);

    Completable saveIdeas();
    void clearIdeas();

    int getRandomPosition();
    int getSize();
}
