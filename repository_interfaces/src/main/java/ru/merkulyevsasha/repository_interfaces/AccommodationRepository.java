package ru.merkulyevsasha.repository_interfaces;

import java.util.List;

import io.reactivex.Single;
import ru.merkulyevsasha.domain_interfaces.accomodation.AccommodationItem;

/**
 * Created by sasha_merkulev on 03.03.2018.
 */

public interface AccommodationRepository {

    public Single<List<AccommodationItem>> search(String searchText);


}
