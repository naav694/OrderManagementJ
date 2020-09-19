package com.devmaw.ordermanagementj.di;

import android.app.Application;

import com.devmaw.ordermanagementj.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class,
        GlideModule.class,
        DatabaseModule.class,
        ViewModelFactoryModule.class,
        ViewModelModule.class,
        RetrofitModule.class,
        HelperModule.class,
})
public interface AppComponent extends AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
