package ru.merkulyevsasha.domain_interfaces.library;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by sasha_merkulev on 28.02.2018.
 */

public interface LibraryInteractor {

    public Single<List<LibraryItem>> search(String searchText);

}
