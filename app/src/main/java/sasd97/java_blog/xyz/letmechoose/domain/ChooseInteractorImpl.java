package sasd97.java_blog.xyz.letmechoose.domain;

import android.support.annotation.NonNull;

import java.util.List;
import java.util.Random;

import sasd97.java_blog.xyz.letmechoose.data.AppRepository;

/**
 * Created by alexander on 17/07/2017.
 */

public class ChooseInteractorImpl implements ChooseInteractor {

    private AppRepository repository;
    private Random random = new Random();

    public ChooseInteractorImpl(@NonNull AppRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> addIdea(String idea) {
        repository.addIdea(idea);
        return repository.getIdeas();
    }

    @Override
    public List<String> getIdeas() {
        return repository.getIdeas();
    }

    @Override
    public List<String> removeIdea(int position) {
        repository.removeIdea(position);
        return repository.getIdeas();
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
