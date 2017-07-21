package sasd97.java_blog.xyz.letmechoose.data;

import java.util.List;

/**
 * Created by alexander on 17/07/2017.
 */

public interface AppRepository {

    String IDEAS_KEY = "keys.cached.ideas";

    void setIdeas(List<String> ideas);

    List<String> addIdea(String idea);
    List<String> getIdeas();
    List<String> removeIdea(int position);
    void clearIdeas();

    String getCachedIdeas();
    void saveIdeas();
}
