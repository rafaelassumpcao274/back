package com.unilith.Back.V1.Controller.AutoComplete

import com.unilith.Back.V1.Util.port.ApiCepPort
import com.unilith.Back.V1.Vo.V1.EnderecoVo

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Autocomplete da empresa Endpoint")
@RestController
@RequestMapping("/autocomplete/endereco")
class Endereco {


    @Autowired
    private lateinit var apiCepPort: ApiCepPort;

    @GetMapping(value = ["/cep"])
    fun buscarPorCep(@RequestParam descricao: String): EnderecoVo? {
        return apiCepPort.buscarViaCep(descricao);
    }
}
