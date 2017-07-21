package sasd97.java_blog.xyz.letmechoose.data;

import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import sasd97.java_blog.xyz.letmechoose.data.storages.CacheStorage;

/**
 * Created by alexander on 17/07/2017.
 */

public class AppRepositoryImpl implements AppRepository {

    private Gson gson;
    private CacheStorage cacheStorage;
    private List<String> ideas = new ArrayList<>();

    public AppRepositoryImpl(@NonNull Gson gson,
                             @NonNull CacheStorage cacheStorage) {
        this.gson = gson;
        this.cacheStorage = cacheStorage;
    }

    @Override
    public void setIdeas(List<String> ideas) {
        if (ideas == null) return;
        this.ideas = ideas;
    }

    @Override
    public List<String> addIdea(String idea) {
        ideas.add(idea);
        return ideas;
    }

    @Override
    public List<String> getIdeas() {
        return ideas;
    }

    @Override
    public List<String> removeIdea(int position) {
        ideas.remove(position);
        return ideas;
    }

    @Override
    public void clearIdeas() {
        ideas.clear();
    }

    @Override
    public String getCachedIdeas() {
        return cacheStorage.getString(IDEAS_KEY, "[]");
    }

    @Override
    public void saveIdeas() {
        String json = gson.toJson(ideas);
        cacheStorage.put(IDEAS_KEY, json);
    }
}
