import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.junit.Test;
import org.junit.runner.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'wjyao' at '3/4/16 3:39 PM' with Gradle 2.6
 *
 * @author wjyao, @date 3/4/16 3:39 PM
 */
public class LibraryTest {
    @Test public void testSomeLibraryMethod() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient.Builder().proxy(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved("127.0.0.1", 8008))).build())
                .baseUrl("http://127.0.0.1:8080")
                .build();


        testServcie testServcie = retrofit.create(testServcie.class);

        ClassLoader classLoader = getClass().getClassLoader();
        String filePath = classLoader.getResource("1.png").getFile();

        RequestBody file = RequestBody.create(MediaType.parse("multipart/form-data"), new File(filePath));
        Map<String, RequestBody> map = new HashMap<String, RequestBody>();
        map.put("file\"; filename=\"1.jpeg", file);

        Call<ResponseBody> call = testServcie.upload(map);

        Response<ResponseBody> response = call.execute();
        System.out.println(response.code());
    }
}


interface testServcie {
    @Multipart
    @POST("/")
    Call<ResponseBody> upload(@PartMap Map<String, RequestBody> image);
}
