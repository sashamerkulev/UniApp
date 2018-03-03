package ru.merkulyevsasha.uniapp.dagger.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import ru.merkulyevsasha.uniapp.dagger.modules.MusicModule;
import ru.merkulyevsasha.uniapp.dagger.scopes.AccommodationScope;
import ru.merkulyevsasha.uniapp.presentation.music.MusicFragment;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@AccommodationScope
@Subcomponent(modules = {MusicModule.class})
public abstract class MusicComponent extends AndroidInjector.Builder<MusicFragment>  {
    @Subcomponent.Builder
    public interface Builder {
        MusicComponent.Builder module(MusicModule module);

        MusicComponent build();
    }
}
