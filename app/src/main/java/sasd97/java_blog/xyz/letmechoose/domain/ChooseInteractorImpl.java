package sasd97.java_blog.xyz.letmechoose.domain;

import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.util.List;
import java.util.Random;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import sasd97.java_blog.xyz.letmechoose.data.AppRepository;
import sasd97.java_blog.xyz.letmechoose.domain.models.IdeaModel;

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
    public List<IdeaModel> addIdea(IdeaModel idea) {
        repository.addIdea(idea);
        return repository.getIdeas();
    }

    @Override
    public Single<List<IdeaModel>> getIdeas() {
        return repository.getCachedIdeas()
                .doOnSuccess(new Consumer<List<IdeaModel>>() {
                    @Override
                    public void accept(List<IdeaModel> ideaModels) throws Exception {
                        repository.setIdeas(ideaModels);
                    }
                });
    }

    @Override
    public List<IdeaModel> removeIdea(int position) {
        repository.removeIdea(position);
        return repository.getIdeas();
    }

    @Override
    public Completable saveIdeas() {
        return repository.saveIdeas();
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
