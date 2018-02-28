package ru.merkulyevsasha.uniapp.dagger.modules;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ru.merkulyevsasha.uniapp.dagger.components.AccomodationComponent;
import ru.merkulyevsasha.uniapp.dagger.components.LibraryComponent;
import ru.merkulyevsasha.uniapp.dagger.components.MusicComponent;
import ru.merkulyevsasha.uniapp.dagger.components.NoticeComponent;
import ru.merkulyevsasha.uniapp.dagger.components.ProgramComponent;
import ru.merkulyevsasha.uniapp.dagger.components.ShopComponent;
import ru.merkulyevsasha.uniapp.dagger.scopes.AccomodationScope;
import ru.merkulyevsasha.uniapp.dagger.scopes.LibraryScope;
import ru.merkulyevsasha.uniapp.dagger.scopes.MusicScope;
import ru.merkulyevsasha.uniapp.dagger.scopes.NoticeScope;
import ru.merkulyevsasha.uniapp.dagger.scopes.ProgramScope;
import ru.merkulyevsasha.uniapp.dagger.scopes.ShopScope;
import ru.merkulyevsasha.uniapp.presentation.MainActivity;
import ru.merkulyevsasha.uniapp.dagger.scopes.MainActivityScope;
import ru.merkulyevsasha.uniapp.presentation.commons.FragmentRouter;
import ru.merkulyevsasha.uniapp.presentation.accomodation.AccomodationFragment;
import ru.merkulyevsasha.uniapp.presentation.library.LibraryFragment;
import ru.merkulyevsasha.uniapp.presentation.music.MusicFragment;
import ru.merkulyevsasha.uniapp.presentation.notice.NoticeFragment;
import ru.merkulyevsasha.uniapp.presentation.program.ProgramFragment;
import ru.merkulyevsasha.uniapp.presentation.shop.ShopFragment;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@Module(subcomponents = {AccomodationComponent.class, LibraryComponent.class, MusicComponent.class,
        NoticeComponent.class, ProgramComponent.class, ShopComponent.class})
abstract class MainActivityModule {

    @MainActivityScope
    @Binds
    abstract FragmentRouter providesFragmentRouter(MainActivity activity);

    @AccomodationScope
    @ContributesAndroidInjector(modules = {AccomodationModule.class})
    abstract AccomodationFragment injectorAccomodationFragment();

    @LibraryScope
    @ContributesAndroidInjector(modules = {LibraryModule.class})
    abstract LibraryFragment injectorLibraryFragment();

    @MusicScope
    @ContributesAndroidInjector(modules = {MusicModule.class})
    abstract MusicFragment injectorMusicFragment();

    @NoticeScope
    @ContributesAndroidInjector(modules = {NoticeModule.class})
    abstract NoticeFragment injectorNoticeFragment();

    @ProgramScope
    @ContributesAndroidInjector(modules = {ProgramModule.class})
    abstract ProgramFragment injectorProgramFragment();

    @ShopScope
    @ContributesAndroidInjector(modules = {ShopModule.class})
    abstract ShopFragment injectorShopFragment();

}
