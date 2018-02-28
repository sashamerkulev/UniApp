package ru.merkulyevsasha.uniapp.dagger.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import ru.merkulyevsasha.uniapp.dagger.modules.LibraryModule;
import ru.merkulyevsasha.uniapp.dagger.scopes.AccomodationScope;
import ru.merkulyevsasha.uniapp.presentation.library.LibraryFragment;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@AccomodationScope
@Subcomponent(modules = {LibraryModule.class})
public abstract class LibraryComponent extends AndroidInjector.Builder<LibraryFragment>  {
    @Subcomponent.Builder
    public interface Builder {
        LibraryComponent.Builder module(LibraryModule module);

        LibraryComponent build();
    }
}
