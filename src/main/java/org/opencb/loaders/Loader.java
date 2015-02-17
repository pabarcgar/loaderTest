package org.opencb.loaders;

/**
 * Created by parce on 17/02/15.
 */
public interface Loader<T> {
    public void load(T object);
}
