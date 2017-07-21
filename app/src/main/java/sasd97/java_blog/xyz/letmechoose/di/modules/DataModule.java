package sasd97.java_blog.xyz.letmechoose.di.modules;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sasd97.java_blog.xyz.letmechoose.data.storages.CacheStorage;
import sasd97.java_blog.xyz.letmechoose.data.storages.PrefsStorage;

/**
 * Created by alexander on 21/07/2017.
 */

@Module
public class DataModule {

    @Provides
    @Singleton
    public Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    public CacheStorage provideCacheStorage(Context context) {
        return new CacheStorage(context.getCacheDir());
    }
}
