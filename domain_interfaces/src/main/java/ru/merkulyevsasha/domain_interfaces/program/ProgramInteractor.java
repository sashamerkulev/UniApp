package ru.merkulyevsasha.domain_interfaces.program;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by sasha_merkulev on 27.02.2018.
 */

public interface ProgramInteractor {
    Single<List<ProgramSearchItem>> search(String level, String course, String year);
}
