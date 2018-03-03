package ru.merkulyevsasha.uniapp.presentation.commons;

@FunctionalInterface
public interface ItemIndexClickListener<T> {
    void onItemClick(T item, int index);
}
