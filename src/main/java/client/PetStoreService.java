package client;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class PetStoreService {
    private PetStore petstore;


    public final PetStore getPetstore() {
        if (petstore == null) {
            Retrofit retrofit = new Retrofit
                    .Builder()
                    .baseUrl("https://petstore.swagger.io/")
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
            petstore = retrofit.create(PetStore.class);
        }
        return petstore;
    }
}
