package ru.merkulyevsasha.uniapp.dagger.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import ru.merkulyevsasha.uniapp.dagger.modules.ShopModule;
import ru.merkulyevsasha.uniapp.dagger.scopes.AccommodationScope;
import ru.merkulyevsasha.uniapp.presentation.shop.ShopFragment;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@AccommodationScope
@Subcomponent(modules = {ShopModule.class})
public abstract class ShopComponent extends AndroidInjector.Builder<ShopFragment>  {
    @Subcomponent.Builder
    public interface Builder {
        ShopComponent.Builder module(ShopModule module);

        ShopComponent build();
    }
}
