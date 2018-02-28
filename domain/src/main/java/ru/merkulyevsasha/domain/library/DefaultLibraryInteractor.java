package ru.merkulyevsasha.domain.library;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import ru.merkulyevsasha.domain_interfaces.library.LibraryInteractor;
import ru.merkulyevsasha.domain_interfaces.library.LibraryItem;
import ru.merkulyevsasha.repository_interfaces.LibraryRepository;

/**
 * Created by sasha_merkulev on 28.02.2018.
 */

public class DefaultLibraryInteractor implements LibraryInteractor {

    private final Scheduler scheduler;
    private final LibraryRepository repository;

    @Inject
    public DefaultLibraryInteractor(Scheduler scheduler, LibraryRepository repository){
        this.scheduler = scheduler;
        this.repository = repository;
    }

    @Override
    public Single<List<LibraryItem>> search(String searchText) {
        return repository.search(searchText)
                .subscribeOn(scheduler);
    }
}
