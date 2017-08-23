package sasd97.java_blog.xyz.letmechoose.di;

import dagger.Subcomponent;
import sasd97.java_blog.xyz.letmechoose.di.modules.MainModule;
import sasd97.java_blog.xyz.letmechoose.di.scope.MainScope;
import sasd97.java_blog.xyz.letmechoose.presentation.choose.ChoosePresenter;
import sasd97.java_blog.xyz.letmechoose.presentation.main.MainPresenter;

/**
 * Created by alexander on 17/07/2017.
 */

@Subcomponent(modules = {MainModule.class})
@MainScope
public interface MainComponent {
    MainPresenter getMainPresenter();
    ChoosePresenter getChoosePresenter();
}
