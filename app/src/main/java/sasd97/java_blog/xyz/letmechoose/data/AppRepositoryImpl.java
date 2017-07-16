package sasd97.java_blog.xyz.letmechoose.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander on 17/07/2017.
 */

public class AppRepositoryImpl implements AppRepository {

    private List<String> ideas = new ArrayList<>();

    @Override
    public List<String> addIdea(String idea) {
        ideas.add(idea);
        return ideas;
    }

    @Override
    public List<String> getIdeas() {
        return ideas;
    }
}
