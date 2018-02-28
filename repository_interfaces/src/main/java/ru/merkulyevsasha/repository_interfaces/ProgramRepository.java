package ru.merkulyevsasha.repository_interfaces;

import java.util.List;

import io.reactivex.Single;
import ru.merkulyevsasha.domain_interfaces.ProgramSearchItem;

public interface ProgramRepository {

    Single<List<ProgramSearchItem>> search(String level, String course, String year);
}
