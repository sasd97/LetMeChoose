package sasd97.java_blog.xyz.letmechoose;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.Stetho;

import sasd97.java_blog.xyz.letmechoose.di.AppComponent;
import sasd97.java_blog.xyz.letmechoose.di.DaggerAppComponent;
import sasd97.java_blog.xyz.letmechoose.di.modules.AppModule;

/**
 * Created by alexander on 16/07/2017.
 */

public class LetMeChooseApp extends Application {

    private AppComponent appComponent;

    public static LetMeChooseApp get(@NonNull Context context) {
        return (LetMeChooseApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent = buildDi();

        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private AppComponent buildDi() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
