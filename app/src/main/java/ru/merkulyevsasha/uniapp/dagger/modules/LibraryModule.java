package ru.merkulyevsasha.uniapp.dagger.modules;

import dagger.Binds;
import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;
import ru.merkulyevsasha.domain.library.DefaultLibraryInteractor;
import ru.merkulyevsasha.domain_interfaces.library.LibraryInteractor;
import ru.merkulyevsasha.repository.library.DefaultLibraryRepository;
import ru.merkulyevsasha.repository_interfaces.LibraryRepository;
import ru.merkulyevsasha.uniapp.dagger.scopes.LibraryScope;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@Module(includes = {AndroidSupportInjectionModule.class})
public abstract class LibraryModule {

    @LibraryScope
    @Binds
    abstract LibraryRepository providesRepository(DefaultLibraryRepository repository);

    @LibraryScope
    @Binds
    abstract LibraryInteractor providesInteractor(DefaultLibraryInteractor interactor);


}
