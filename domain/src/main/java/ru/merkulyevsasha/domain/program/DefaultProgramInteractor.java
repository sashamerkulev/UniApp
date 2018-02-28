package ru.merkulyevsasha.domain.program;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import ru.merkulyevsasha.domain_interfaces.program.ProgramInteractor;
import ru.merkulyevsasha.domain_interfaces.program.ProgramSearchItem;
import ru.merkulyevsasha.repository_interfaces.ProgramRepository;

/**
 * Created by sasha_merkulev on 27.02.2018.
 */

public class DefaultProgramInteractor implements ProgramInteractor {

    private final Scheduler scheduler;
    private final ProgramRepository repository;

    @Inject
    public DefaultProgramInteractor(Scheduler scheduler, ProgramRepository repository){
        this.scheduler = scheduler;
        this.repository = repository;
    }

    @Override
    public Single<List<ProgramSearchItem>> search(String level, String course, String year) {
        return repository.search(level, course, year)
                .subscribeOn(scheduler);
    }
}
