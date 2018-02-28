package ru.merkulyevsasha.uniapp.dagger.modules;

import dagger.Binds;
import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;
import ru.merkulyevsasha.domain_interfaces.ProgramInteractor;
import ru.merkulyevsasha.repository.DefaultProgramRepository;
import ru.merkulyevsasha.repository_interfaces.ProgramRepository;
import ru.merkulyevsasha.uniapp.dagger.scopes.ProgramScope;
import ru.merkulyevsasha.domain.DefaultProgramInteractor;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@Module(includes = {AndroidSupportInjectionModule.class})
public abstract class ProgramModule {

    @ProgramScope
    @Binds
    abstract ProgramRepository providesRepository(DefaultProgramRepository repository);

    @ProgramScope
    @Binds
    abstract ProgramInteractor providesInteractor(DefaultProgramInteractor interactor);

}
