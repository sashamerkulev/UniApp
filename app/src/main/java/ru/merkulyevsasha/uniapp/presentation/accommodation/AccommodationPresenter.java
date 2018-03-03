package ru.merkulyevsasha.uniapp.presentation.accommodation;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.merkulyevsasha.domain_interfaces.accomodation.AccommodationInteractor;
import ru.merkulyevsasha.uniapp.presentation.commons.BasePresenter;
import ru.merkulyevsasha.uniapp.presentation.dto.AccommodationItemUI;
import ru.merkulyevsasha.uniapp.presentation.dto.ProgramItemUI;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

class AccommodationPresenter extends BasePresenter<AccommodationView>{

    private final AccommodationInteractor accomodation;

    @Inject
    AccommodationPresenter(AccommodationInteractor accomodation){
        this.accomodation = accomodation;
    }

    void onItemClicked(AccommodationItemUI item, int index){
        view.showItem(item, index);
    }

    void onCreateView() {
        onSearch("");
    }

    void onSearch(String searchText){
        accomodation.search(searchText)
                .observeOn(AndroidSchedulers.mainThread())
                .flattenAsFlowable(items -> items)
                .map(accommodationItem ->
                        new AccommodationItemUI(accommodationItem.getId(), accommodationItem.getName(),
                                accommodationItem.getAddress(), accommodationItem.getDescription(),
                                accommodationItem.getContact(), accommodationItem.getPhone(), accommodationItem.getPrice(),
                                accommodationItem.getImages()))
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
