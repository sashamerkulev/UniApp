package ru.merkulyevsasha.repository.accomodation;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.merkulyevsasha.domain_interfaces.accomodation.AccommodationItem;
import ru.merkulyevsasha.repository_interfaces.AccommodationRepository;

/**
 * Created by sasha_merkulev on 03.03.2018.
 */

public class DefaultAccommodationRepository implements AccommodationRepository {

    private static final int MAX_FLAT_VIEW_IMAGE = 6;

    @Inject
    public DefaultAccommodationRepository(){

    }

    @Override
    public Single<List<AccommodationItem>> search(String searchText) {
        return Single.fromCallable(new Callable<List<AccommodationItem>>() {
            @Override
            public List<AccommodationItem> call() throws Exception {
                List<AccommodationItem> result = new ArrayList<>();
                Random r = new Random();

                for(int i=0;i < 100; i++){

                    int maxImages = r.nextInt(MAX_FLAT_VIEW_IMAGE);
                    List<String> images = new ArrayList<>();
                    for(int j =0; j < maxImages; j++){
                        int image = 0;
                        while (image == 0) image = r.nextInt(MAX_FLAT_VIEW_IMAGE);
                        images.add(String.format(Locale.getDefault(), "kv%d", image));
                    }

                    result.add(new AccommodationItem(i,
                            String.format(Locale.getDefault(),"name%d", i),
                            String.format(Locale.getDefault(),"address%d", i),
                            String.format(Locale.getDefault(),"description%d", i),
                            String.format(Locale.getDefault(),"contact%d", i),
                            String.format(Locale.getDefault(),"phone%d", i),
                            i* 1000,
                            images
                    ));
                }

                return result;
            }
        });

    }
}
