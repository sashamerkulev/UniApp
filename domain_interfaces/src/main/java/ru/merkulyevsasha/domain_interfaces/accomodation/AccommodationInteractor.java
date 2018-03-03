package ru.merkulyevsasha.domain_interfaces.accomodation;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by sasha_merkulev on 03.03.2018.
 */

public interface AccommodationInteractor {

    Single<List<AccommodationItem>> search(String searchText);

}
