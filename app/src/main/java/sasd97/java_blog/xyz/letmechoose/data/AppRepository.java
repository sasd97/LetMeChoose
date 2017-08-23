package sasd97.java_blog.xyz.letmechoose.data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import sasd97.java_blog.xyz.letmechoose.domain.models.IdeaModel;

/**
 * Created by alexander on 17/07/2017.
 */

public interface AppRepository {

    String IDEAS_KEY = "keys.cached.ideas";

    void setIdeas(List<IdeaModel> ideas);

    List<IdeaModel> addIdea(IdeaModel idea);
    List<IdeaModel> getIdeas();
    List<IdeaModel> removeIdea(int position);
    void clearIdeas();

    Single<List<IdeaModel>> getCachedIdeas();
    Completable saveIdeas();
}
