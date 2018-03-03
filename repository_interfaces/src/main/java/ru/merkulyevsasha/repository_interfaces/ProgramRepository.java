package ru.merkulyevsasha.repository_interfaces;

import java.util.List;

import io.reactivex.Single;
import ru.merkulyevsasha.domain_interfaces.program.ProgramItem;

public interface ProgramRepository {

    Single<List<ProgramItem>> search(String level, String course, String year);
}
