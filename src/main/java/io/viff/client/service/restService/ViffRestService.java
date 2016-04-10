package io.viff.client.service.restService;

import io.viff.client.service.restService.response.UploadResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface ViffRestService {
    @Multipart
    @POST("/upload/{projectID}/{tag}")
    Call<UploadResponse> uploadScreenshot(@Path("projectID") String projectID, @Path("tag") String tag, @Part MultipartBody.Part file);

    @Multipart
    @POST("/upload/{projectID}/{tag}/{buildNumber}")
    Call<UploadResponse> uploadScreenshot(@Path("projectID") String projectID, @Path("tag") String tag, @Part("buildNumber") String buildNumber, @Part MultipartBody.Part file);

    @GET("/compare")
    Call<ResponseBody> viff(@Query("from") String from, @Query("to") String to);
}
