package com.unilith.Back.V1.Controller.AutoComplete

import com.unilith.Back.V1.Service.EmpresaService
import com.unilith.Back.V1.Vo.V1.EmpresaVo
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Tag(name = "Autocomplete da empresa Endpoint")
@RestController
@RequestMapping("/autocomplete/empresa")
class Empresa {

    @Autowired
    private lateinit var service: EmpresaService;

    @GetMapping(value = [""])
    fun findProperty(@RequestParam descricao:String): List<EmpresaVo>? {
        return service.findByNomeEmpresa(descricao);
    }
}
