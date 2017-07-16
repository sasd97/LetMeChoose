package sasd97.java_blog.xyz.letmechoose.di;

import javax.inject.Singleton;

import dagger.Component;
import sasd97.java_blog.xyz.letmechoose.di.modules.AppModule;
import sasd97.java_blog.xyz.letmechoose.di.modules.MainModule;

/**
 * Created by alexander on 17/07/2017.
 */

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    MainComponent plusMainComponent();
}
