package ru.merkulyevsasha.uniapp.dagger.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import ru.merkulyevsasha.uniapp.dagger.modules.AccomodationModule;
import ru.merkulyevsasha.uniapp.dagger.scopes.AccomodationScope;
import ru.merkulyevsasha.uniapp.presentation.accomodation.AccomodationFragment;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@AccomodationScope
@Subcomponent(modules = {AccomodationModule.class})
public abstract class AccomodationComponent extends AndroidInjector.Builder<AccomodationFragment>  {
    @Subcomponent.Builder
    public interface Builder {
        AccomodationComponent.Builder module(AccomodationModule module);

        AccomodationComponent build();
    }
}
