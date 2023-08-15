package com.unilith.Back.V1.Controller.AutoComplete

import com.unilith.Back.V1.Service.EnderecoService
import com.unilith.Back.V1.Service.PapelService
import com.unilith.Back.V1.Util.ViaCepService
import com.unilith.Back.V1.Vo.V1.EnderecoVo
import com.unilith.Back.V1.Vo.V1.PapelVo
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Autocomplete da papel Endpoint")
@RestController
@RequestMapping("/autocomplete/papel")
class Papel {

    @Autowired
    private lateinit var service: PapelService;

    @GetMapping(value = [""])
    fun buscarPorCep(@RequestParam descricao:String): List<PapelVo> {
        return service.findByDescricao(descricao);
    }
}
