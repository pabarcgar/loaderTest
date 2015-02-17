package org.opencb.loaders;


import org.opencb.cellbase.core.common.clinical.Cosmic;

/**
 * Created by parce on 17/02/15.
 */
public class CosmicLoader implements Loader<Cosmic> {
    @Override
    public void load(Cosmic cosmic) {
        System.out.println("Loading cosmic Object " + cosmic.getMutationID());
    }
}
