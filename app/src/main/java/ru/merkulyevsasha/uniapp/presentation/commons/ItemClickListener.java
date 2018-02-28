package ru.merkulyevsasha.uniapp.presentation.commons;

@FunctionalInterface
public interface ItemClickListener<T> {
    void onItemClick(T item);
}
