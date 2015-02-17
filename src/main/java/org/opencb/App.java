package org.opencb;

import org.opencb.cellbase.core.common.clinical.ClinvarPublicSet;
import org.opencb.cellbase.core.common.clinical.Cosmic;
import org.opencb.loaders.ClinvarLoader;
import org.opencb.loaders.CosmicLoader;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App 
{
    public static void main( String[] args ) {
        try {
            Path cosmicFile = Paths.get(App.class.getClassLoader().getResource("cosmic.json").toURI());
            Path clinvarFile = Paths.get(App.class.getClassLoader().getResource("clinvar.json").toURI());

            LoaderRunner cosmicRunner = new LoaderRunner<Cosmic>(Cosmic.class);
            cosmicRunner.load(cosmicFile, new CosmicLoader());

            LoaderRunner clinvarRunner = new LoaderRunner<ClinvarPublicSet>(ClinvarPublicSet.class);
            clinvarRunner.load(clinvarFile, new ClinvarLoader());

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
