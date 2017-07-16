package sasd97.java_blog.xyz.letmechoose.domain;

import android.support.annotation.NonNull;

import java.util.List;

import sasd97.java_blog.xyz.letmechoose.data.AppRepository;

/**
 * Created by alexander on 17/07/2017.
 */

public class ChooseInteractorImpl implements ChooseInteractor {

    private AppRepository repository;

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
}
