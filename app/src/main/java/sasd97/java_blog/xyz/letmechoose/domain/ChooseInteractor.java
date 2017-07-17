package sasd97.java_blog.xyz.letmechoose.domain;

import java.util.List;

/**
 * Created by alexander on 17/07/2017.
 */

public interface ChooseInteractor {
    List<String> addIdea(String idea);
    List<String> getIdeas();
    List<String> removeIdea(int position);
    String getRandomIdea();
}
