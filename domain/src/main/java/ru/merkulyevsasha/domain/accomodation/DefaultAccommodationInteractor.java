package ru.merkulyevsasha.domain.accomodation;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import ru.merkulyevsasha.domain_interfaces.accomodation.AccommodationInteractor;
import ru.merkulyevsasha.domain_interfaces.accomodation.AccommodationItem;
import ru.merkulyevsasha.repository_interfaces.AccommodationRepository;

/**
 * Created by sasha_merkulev on 03.03.2018.
 */

public class DefaultAccommodationInteractor implements AccommodationInteractor {

    private final Scheduler scheduler;
    private final AccommodationRepository repository;

    @Inject
    public DefaultAccommodationInteractor(Scheduler scheduler, AccommodationRepository repository){
        this.scheduler = scheduler;
        this.repository = repository;
    }

    @Override
    public Single<List<AccommodationItem>> search(String searchText) {
        return repository.search(searchText)
                .subscribeOn(scheduler);
    }
}
