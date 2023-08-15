package com.unilith.Back.V1.Util

import com.google.gson.Gson
import com.unilith.Back.V1.Exceptions.RequestInvalidObjectException
import com.unilith.Back.V1.Exceptions.RequestObjectNotFoundException
import com.unilith.Back.V1.Mapper.ApiMapper.viaCepMapper
import com.unilith.Back.V1.Mapper.Custom.EnderecoMapper
import com.unilith.Back.V1.Vo.V1.EnderecoVo
import com.unilith.Back.V1.Vo.V1.ViaCep.ViaCep
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
class ViaCepService {

    @Autowired
    lateinit var enderecoMapper: EnderecoMapper;

    @Autowired
    lateinit var viaCepUtils: ViaCepUtils;
    @Autowired
    lateinit var viaCepMapper: viaCepMapper;

    var urlViacep: String = "http://viacep.com.br/ws/?/json"

    fun findByCep(cep: String): ViaCep {
        validacaoCep(cep);
        return requisicao(cep)
    }


    fun buscarViaCep(cep:String): EnderecoVo {
        validacaoCep(cep)

        var viacep = this.findByCep(cep);
        if(viacep.erro){
            throw RequestObjectNotFoundException();
        }
        return enderecoMapper.convertVo(viaCepMapper.convertEntity(viacep));

    }
    fun validacaoCep(cep: String){

        var re = Regex("[0-9]+")
        if (!cep.matches(re)) {
            viaCepUtils.removeCaracterInString(cep)
        }

        if (cep.length > 9 || cep.length < 8) {
            throw RequestInvalidObjectException("Cep com tamanho invalido!!!")
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