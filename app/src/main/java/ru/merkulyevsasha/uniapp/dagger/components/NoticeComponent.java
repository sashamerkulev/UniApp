package ru.merkulyevsasha.uniapp.dagger.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import ru.merkulyevsasha.uniapp.dagger.modules.NoticeModule;
import ru.merkulyevsasha.uniapp.dagger.scopes.AccomodationScope;
import ru.merkulyevsasha.uniapp.presentation.notice.NoticeFragment;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@AccomodationScope
@Subcomponent(modules = {NoticeModule.class})
public abstract class NoticeComponent extends AndroidInjector.Builder<NoticeFragment>  {
    @Subcomponent.Builder
    public interface Builder {
        NoticeComponent.Builder module(NoticeModule module);

        NoticeComponent build();
    }
}
