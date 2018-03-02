package ru.merkulyevsasha.repository.library;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.merkulyevsasha.domain_interfaces.library.LibraryItem;
import ru.merkulyevsasha.repository_interfaces.LibraryRepository;

/**
 * Created by sasha_merkulev on 28.02.2018.
 */

public class DefaultLibraryRepository implements LibraryRepository {

    @Inject
    public DefaultLibraryRepository(){

    }

    @Override
    public Single<List<LibraryItem>> search(String searchText) {
        return Single.fromCallable(new Callable<List<LibraryItem>>() {
            @Override
            public List<LibraryItem> call() throws Exception {
                List<LibraryItem> result = new ArrayList<>();

                for(int i=0;i < 100; i++){
                    result.add(new LibraryItem(i,
                            String.format(Locale.getDefault(),"author%d", i),
                            String.format(Locale.getDefault(),"title%d", i),
                            String.format(Locale.getDefault(),"subject%d", i),
                            String.format(Locale.getDefault(),"course%d", i),
                            new Date()
                            ));
                }

                return result;
            }
        });
    }
}
