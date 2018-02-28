package ru.merkulyevsasha.uniapp.presentation.program;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.merkulyevsasha.domain_interfaces.program.ProgramInteractor;
import ru.merkulyevsasha.uniapp.presentation.commons.BasePresenter;
import ru.merkulyevsasha.uniapp.presentation.dto.ProgramSearchItemUI;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

class ProgramPresenter extends BasePresenter<ProgramView> {

    private final ProgramInteractor program;

    @Inject
    ProgramPresenter(ProgramInteractor program){
        this.program = program;
    }

    void onSearchItemSelected(ProgramSearchItemUI item) {

    }

    void onSearch(String level, String course, String year) {
        program.search(level, course, year)
        .observeOn(AndroidSchedulers.mainThread())
                .flattenAsFlowable(items -> items)
                .map(programSearchItem ->
                        new ProgramSearchItemUI(programSearchItem.getId(), programSearchItem.getCourse(),
                                programSearchItem.getDegree(), programSearchItem.getYear(), programSearchItem.getName()))
                .startWith(ProgramSearchItemUI.createHeader())
                .toList()
                .filter(notUsed -> view != null)
                .subscribe(
                        items -> {
                            if (items.size() > 1) view.showItems(items);
                            else view.showNotFoundMessage();
                        },
                        this::error);
    }

    private void error(Throwable throwable){
        if (view == null) return;
        view.showErrorMessage(throwable.getMessage());
    }
}
