import client.PetStore;
import client.PetStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pet.Pet;

import java.io.IOException;

import static pet.Pet.createPet;

public class TestPut200 {
    @Test //Тест метода PUT (200), сравнение НЕ равенства имен животных
    public void testPut() throws IOException {
        int id = 455;
        Pet pet = createPet(id);
        PetStore petStore = new PetStoreService().getPetstore();
        petStore.delPetById(id).execute();
        petStore.createPet(pet).execute();
        Pet retrofitPet = petStore.getPetById(id).execute().body();
        pet.setName("Petia");
        int a = petStore.putPet(pet).execute().code();
        Pet retrofitPet2 = petStore.getPetById(id).execute().body();
        assert retrofitPet != null;
        assert retrofitPet2 != null;
        Assertions.assertNotEquals(retrofitPet.getName(), retrofitPet2.getName());
        System.out.println("Код состояния PUT: " + a);
    }
}
