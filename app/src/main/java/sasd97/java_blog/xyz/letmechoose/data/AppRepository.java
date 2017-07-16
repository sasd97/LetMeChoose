package sasd97.java_blog.xyz.letmechoose.data;

import java.util.List;

/**
 * Created by alexander on 17/07/2017.
 */

public interface AppRepository {
    List<String> addIdea(String idea);
    List<String> getIdeas();
}
