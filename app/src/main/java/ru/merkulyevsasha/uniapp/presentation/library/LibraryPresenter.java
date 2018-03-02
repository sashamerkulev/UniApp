package ru.merkulyevsasha.uniapp.presentation.library;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.merkulyevsasha.domain_interfaces.library.LibraryInteractor;
import ru.merkulyevsasha.uniapp.presentation.commons.BasePresenter;
import ru.merkulyevsasha.uniapp.presentation.dto.LibrarySearchItemUI;
import ru.merkulyevsasha.uniapp.presentation.dto.ProgramSearchItemUI;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

class LibraryPresenter extends BasePresenter<LibraryView>{

    private final LibraryInteractor library;

    @Inject
    LibraryPresenter(LibraryInteractor library){
        this.library = library;
    }

    void onSearchItemSelected(LibrarySearchItemUI item) {

    }

    void onCreateView() {
        library.search("")
                .observeOn(AndroidSchedulers.mainThread())
                .flattenAsFlowable(items -> items)
                .map(libraryItem ->
                        new LibrarySearchItemUI(libraryItem.getId(), libraryItem.getAuthor(),
                                libraryItem.getTitle(), libraryItem.getSubject(), libraryItem.getCourse(), libraryItem.getDate()))
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
