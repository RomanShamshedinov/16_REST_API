import client.PetStore;
import client.PetStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pet.Pet;

import java.io.IOException;

public class TestPost200 {

    @Test //Тест метода POST (200)
    public void testPost() throws IOException {
        int id = 15;
        Pet pet = Pet.createPet(id);
        PetStore petStore = new PetStoreService().getPetstore();
        petStore.delPetById(id).execute();
        int a = petStore.createPet(pet).execute().code();
        Pet retrofitPet = petStore.getPetById(id).execute().body();
        Assertions.assertEquals(pet, retrofitPet);
        System.out.println("Код состояния POST: " + a);
    }

}
