package ru.merkulyevsasha.uniapp.presentation.accommodation;

import java.util.List;

import ru.merkulyevsasha.uniapp.presentation.commons.BaseView;
import ru.merkulyevsasha.uniapp.presentation.dto.AccommodationItemUI;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

interface AccommodationView extends BaseView{
    void showItem(AccommodationItemUI item, int index);
    void showItems(List<AccommodationItemUI> items);

    void showNotFoundMessage();
}
