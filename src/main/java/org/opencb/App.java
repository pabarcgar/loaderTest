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
            System.out.println("Loading cosmic (Java 8 style) ...");
            cosmicRunner.load(cosmicFile, new CosmicLoader());
            System.out.println("\nLoading cosmic (Java 7 style) ...");
            cosmicRunner.loadJava7Style(cosmicFile, new CosmicLoader());

            LoaderRunner clinvarRunner = new LoaderRunner<ClinvarPublicSet>(ClinvarPublicSet.class);
            System.out.println("\nLoading clinvar (Java 8 style) ...");
            clinvarRunner.load(clinvarFile, new ClinvarLoader());
            System.out.println("\nLoading clinvar (Java 7 style) ...");
            clinvarRunner.loadJava7Style(clinvarFile, new ClinvarLoader());

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
