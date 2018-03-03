package ru.merkulyevsasha.uniapp.dagger.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import ru.merkulyevsasha.uniapp.dagger.modules.AccommodationModule;
import ru.merkulyevsasha.uniapp.dagger.scopes.AccommodationScope;
import ru.merkulyevsasha.uniapp.presentation.accommodation.AccommodationFragment;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@AccommodationScope
@Subcomponent(modules = {AccommodationModule.class})
public abstract class AccommodationComponent extends AndroidInjector.Builder<AccommodationFragment>  {
    @Subcomponent.Builder
    public interface Builder {
        AccommodationComponent.Builder module(AccommodationModule module);

        AccommodationComponent build();
    }
}
