package ru.merkulyevsasha.repository_interfaces;

import java.util.List;

import io.reactivex.Single;
import ru.merkulyevsasha.domain_interfaces.library.LibraryItem;

/**
 * Created by sasha_merkulev on 28.02.2018.
 */

public interface LibraryRepository {

    public Single<List<LibraryItem>> search(String searchText);

}
