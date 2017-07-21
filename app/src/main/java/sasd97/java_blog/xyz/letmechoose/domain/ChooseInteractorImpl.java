package sasd97.java_blog.xyz.letmechoose.domain;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Random;

import sasd97.java_blog.xyz.letmechoose.data.AppRepository;
import sasd97.java_blog.xyz.letmechoose.data.storages.Storage;

/**
 * Created by alexander on 17/07/2017.
 */

public class ChooseInteractorImpl implements ChooseInteractor {

    private Gson gson;
    private AppRepository repository;
    private Random random = new Random();

    public ChooseInteractorImpl(@NonNull Gson gson,
                                @NonNull AppRepository repository) {
        this.gson = gson;
        this.repository = repository;
    }

    @Override
    public List<String> addIdea(String idea) {
        repository.addIdea(idea);
        return repository.getIdeas();
    }

    @Override
    public List<String> getIdeas() {
        String cachedValue = repository.getCachedIdeas();
        List<String> ideas = gson.fromJson(cachedValue, new TypeToken<List<String>>(){}.getType());
        repository.setIdeas(ideas);
        return ideas;
    }

    @Override
    public List<String> removeIdea(int position) {
        repository.removeIdea(position);
        return repository.getIdeas();
    }

    @Override
    public void saveIdeas() {
        repository.saveIdeas();
    }

    @Override
    public void clearIdeas() {
        repository.clearIdeas();
    }

    @Override
    public int getRandomPosition() {
        return random.nextInt(getSize());
    }

    @Override
    public int getSize() {
        return repository.getIdeas().size();
    }
}
