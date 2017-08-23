package sasd97.java_blog.xyz.letmechoose.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sasd97.java_blog.xyz.letmechoose.data.AppRepository;
import sasd97.java_blog.xyz.letmechoose.data.AppRepositoryImpl;
import sasd97.java_blog.xyz.letmechoose.data.database.AppDatabase;
import sasd97.java_blog.xyz.letmechoose.utils.RxSchedulers;
import sasd97.java_blog.xyz.letmechoose.utils.RxSchedulersImpl;

/**
 * Created by alexander on 17/07/2017.
 */

@Module
public class AppModule {

    private Context context;

    public AppModule(@NonNull Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public RxSchedulers provideSchedulers() {
        return new RxSchedulersImpl();
    }
}
