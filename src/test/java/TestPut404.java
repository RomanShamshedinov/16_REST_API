import client.PetStore;
import client.PetStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pet.Pet;

import java.io.IOException;

import static pet.Pet.createPet;

public class TestPut404 {
    @Test //Тест метода PUT (404), сравнение кода ошибки
    public void testPut() throws IOException {
        int code = 404;
        int id = 45000;
        Pet pet = createPet(id);
        PetStore petStore = new PetStoreService().getPetstore();
        petStore.delPetById(id).execute();
        int retrofitCode = petStore.putPet(pet).execute().code();
        Assertions.assertEquals(code, retrofitCode);
    }
}
