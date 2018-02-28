package ru.merkulyevsasha.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.merkulyevsasha.domain_interfaces.ProgramSearchItem;
import ru.merkulyevsasha.repository_interfaces.ProgramRepository;

public class DefaultProgramRepository implements ProgramRepository {

    @Inject
    public DefaultProgramRepository(){

    }

    @Override
    public Single<List<ProgramSearchItem>> search(String level, String course, String year) {
        return Single.fromCallable(new Callable<List<ProgramSearchItem>>() {
            @Override
            public List<ProgramSearchItem> call() throws Exception {
                List<ProgramSearchItem> result = new ArrayList<>();

                for(int i=0; i < 5; i++) {
                    result.add(new ProgramSearchItem(i,
                            String.format(Locale.getDefault(),"course%d", i),
                            String.format(Locale.getDefault(),"degree%d", i),
                            String.format(Locale.getDefault(),"year%d", i),
                            String.format(Locale.getDefault(),"name%d", i)
                            ));
                }

                return result;
            }
        });
    }
}
