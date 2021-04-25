import client.PetStore;
import client.PetStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pet.Pet;

import java.io.IOException;

import static pet.Pet.createPet;

public class TestDelete200 {
    @Test //Тест метода DELETE (200), сравнение по совпадению кода при проверке GET
    public void testDelete() throws IOException {
        int code = 404;
        int id = 68;
        Pet pet = createPet(id);
        PetStore petStore = new PetStoreService().getPetstore();
        petStore.createPet(pet).execute();
        petStore.delPetById(id).execute();
        int retrofitCode = petStore.getPetById(id).execute().code();
        System.out.println("Код состояния GET после DELETE: " + retrofitCode);
        Assertions.assertEquals(code, retrofitCode);
    }
}
