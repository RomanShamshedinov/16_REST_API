import client.PetStore;
import client.PetStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestGet404 {
    @Test //Тест метода GET (404)
    public void testGet() throws IOException {
        int code = 404;
        int id = 1500000;
        PetStore petStore = new PetStoreService().getPetstore();
        petStore.delPetById(id).execute();
        int retrofitCode = petStore.getPetById(id).execute().code();
        Assertions.assertEquals(code, retrofitCode);
        System.out.println("Код состояния GET: " + retrofitCode);
    }
}
