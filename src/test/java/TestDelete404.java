import client.PetStore;
import client.PetStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pet.Pet;

import java.io.IOException;

import static pet.Pet.createPet;

public class TestDelete404 {
    @Test //Тест метода DELETE (404), сравнение по совпадению кода
    public void testDelete404() throws IOException {
        int code = 404;
        int id = 68000;
        Pet pet = createPet(id);
        PetStore petStore = new PetStoreService().getPetstore();
        petStore.createPet(pet).execute();
        petStore.delPetById(id).execute();
        int retrofitCode = petStore.delPetById(id).execute().code();
        Assertions.assertEquals(code, retrofitCode);
        System.out.println("Код состояния DELETE: " + retrofitCode);
    }
}
