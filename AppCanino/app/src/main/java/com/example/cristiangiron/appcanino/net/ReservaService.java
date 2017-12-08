package com.example.cristiangiron.appcanino.net;

import com.example.cristiangiron.appcanino.Reserva;
import com.example.cristiangiron.appcanino.models.SimpleResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by CristianGiron on 13/06/2017.
 */

public interface ReservaService {

    @POST("reservas")
    Call<SimpleResponse> insert(@Body Reserva reserva);


}
