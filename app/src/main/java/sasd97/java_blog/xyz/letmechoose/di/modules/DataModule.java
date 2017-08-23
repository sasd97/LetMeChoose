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
    public AppDatabase provideDatabase(@NonNull Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME).build();
    }

    @Provides
    @Singleton
    public AppRepository provideRepository(@NonNull AppDatabase database) {
        return new AppRepositoryImpl(database);
    }
}
