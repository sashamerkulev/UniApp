package ru.merkulyevsasha.uniapp.dagger.modules;

import dagger.Binds;
import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;
import ru.merkulyevsasha.domain.accomodation.DefaultAccommodationInteractor;
import ru.merkulyevsasha.domain_interfaces.accomodation.AccommodationInteractor;
import ru.merkulyevsasha.repository.accomodation.DefaultAccommodationRepository;
import ru.merkulyevsasha.repository_interfaces.AccommodationRepository;
import ru.merkulyevsasha.uniapp.dagger.scopes.AccommodationScope;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@Module(includes = {AndroidSupportInjectionModule.class})
public abstract class AccommodationModule {

    @AccommodationScope
    @Binds
    abstract AccommodationRepository providesRepository(DefaultAccommodationRepository repository);

    @AccommodationScope
    @Binds
    abstract AccommodationInteractor providesInteractor(DefaultAccommodationInteractor interactor);
}
