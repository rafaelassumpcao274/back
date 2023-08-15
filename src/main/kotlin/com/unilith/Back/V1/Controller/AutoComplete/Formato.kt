package com.unilith.Back.V1.Controller.AutoComplete

import com.unilith.Back.V1.Service.EmpresaService
import com.unilith.Back.V1.Service.FormatoService
import com.unilith.Back.V1.Vo.V1.EmpresaVo
import com.unilith.Back.V1.Vo.V1.FormatoVo
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Autocomplete da empresa Endpoint")
@RestController
@RequestMapping("/autocomplete/formato")
class Formato {

    @Autowired
    private lateinit var service: FormatoService;

    @GetMapping(value = [""])
    fun findProperty(@RequestParam descricao:String): List<FormatoVo>? {
        return service.findByDescricao(descricao);
    }
}