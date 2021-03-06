package ru.merkulyevsasha.uniapp.dagger.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@Scope
@Retention(RUNTIME)
public @interface LibraryScope {
}
