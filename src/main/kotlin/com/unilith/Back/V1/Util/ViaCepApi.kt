package com.unilith.Back.V1.Util

import com.google.gson.Gson
import com.unilith.Back.V1.Exceptions.RequestInvalidObjectException
import com.unilith.Back.V1.Vo.V1.ViaCep.ViaCep
import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
class ViaCepApi {

    var urlViacep: String = "http://viacep.com.br/ws/?/json"

    fun findByCep(cep: String): ViaCep {
        validacaoCep(cep);
        return requisicao(cep)
    }

    fun validacaoCep(cep: String){

        if (cep.length > 8) {
            throw RequestInvalidObjectException("Cep com tamanho invalido!!!")
        }


        var re = Regex("[0-9]+")
        if (!cep.matches(re)) {
            throw RequestInvalidObjectException("Cep deve conter somente numeros");
        }

    }

    fun requisicao(cep: String): ViaCep {
        var gson = Gson()
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create(urlViacep.replace("?", cep)))
            .build();

        val response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (!response.statusCode().equals(200)) {
            throw RequestInvalidObjectException();
        }

        return gson.fromJson(response.body(), ViaCep::class.java)
    }
}