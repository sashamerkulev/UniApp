package ru.merkulyevsasha.uniapp.dagger.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import ru.merkulyevsasha.uniapp.dagger.modules.ProgramModule;
import ru.merkulyevsasha.uniapp.dagger.scopes.AccommodationScope;
import ru.merkulyevsasha.uniapp.presentation.program.ProgramFragment;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@AccommodationScope
@Subcomponent(modules = {ProgramModule.class})
public abstract class ProgramComponent extends AndroidInjector.Builder<ProgramFragment>  {
    @Subcomponent.Builder
    public interface Builder {
        ProgramComponent.Builder module(ProgramModule module);

        ProgramComponent build();
    }
}
