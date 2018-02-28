package ru.merkulyevsasha.uniapp.presentation.program;

import java.util.List;

import ru.merkulyevsasha.uniapp.presentation.commons.BaseView;
import ru.merkulyevsasha.uniapp.presentation.dto.ProgramSearchItemUI;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

interface ProgramView extends BaseView {

    void showItems(List<ProgramSearchItemUI> items);
    void showNotFoundMessage();

}
