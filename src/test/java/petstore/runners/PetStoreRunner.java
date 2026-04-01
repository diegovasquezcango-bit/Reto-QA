package petstore.runners;

import com.intuit.karate.junit5.Karate;

class PetStoreRunner {

    @Karate.Test
    Karate ejecutarPruebas() {
        return Karate.run("../features/petstore").relativeTo(getClass());
    }
}