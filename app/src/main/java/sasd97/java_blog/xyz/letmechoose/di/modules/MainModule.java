package sasd97.java_blog.xyz.letmechoose.di.modules;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import sasd97.java_blog.xyz.letmechoose.data.AppRepository;
import sasd97.java_blog.xyz.letmechoose.di.scope.MainScope;
import sasd97.java_blog.xyz.letmechoose.domain.ChooseInteractor;
import sasd97.java_blog.xyz.letmechoose.domain.ChooseInteractorImpl;
import sasd97.java_blog.xyz.letmechoose.presentation.choose.ChoosePresenter;
import sasd97.java_blog.xyz.letmechoose.presentation.main.MainPresenter;

/**
 * Created by alexander on 17/07/2017.
 */

@Module
public class MainModule {

    @Provides
    @MainScope
    MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @MainScope
    public ChooseInteractor provideChooseInteractor(Gson gson,
                                                    AppRepository repository) {
        return new ChooseInteractorImpl(gson, repository);
    }
}
