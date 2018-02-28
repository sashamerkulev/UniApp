package ru.merkulyevsasha.uniapp.presentation.library;

import java.util.List;

import ru.merkulyevsasha.uniapp.presentation.commons.BaseView;
import ru.merkulyevsasha.uniapp.presentation.dto.LibrarySearchItemUI;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

interface LibraryView extends BaseView{
    void showItems(List<LibrarySearchItemUI> items);
    void showNotFoundMessage();
}
