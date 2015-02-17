package org.opencb.loaders;

import org.opencb.cellbase.core.common.clinical.ClinvarPublicSet;

/**
 * Created by parce on 17/02/15.
 */
public class ClinvarLoader implements Loader<ClinvarPublicSet> {
    @Override
    public void load(ClinvarPublicSet clinvar) {
        System.out.println("Loading clinvar object " + clinvar.getClinvarSet().getID());
    }
}
