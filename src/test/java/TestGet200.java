import client.PetStore;
import client.PetStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pet.Pet;
import java.io.IOException;
import static pet.Pet.createPet;

public class TestGet200 {
    @Test //Тест метода GET (200)
    public void testGet() throws IOException {
        int id = 38;
        Pet pet = createPet(id);
        PetStore petStore = new PetStoreService().getPetstore();
        petStore.delPetById(id).execute();
        petStore.createPet(pet).execute();
        Pet retrofitPet = petStore.getPetById(id).execute().body();
        Assertions.assertEquals(pet, retrofitPet);
        int a = petStore.getPetById(id).execute().code();
        System.out.println("Код состояния GET: " + a);
    }
}
