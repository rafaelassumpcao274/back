package com.unilith.Back.V1.Controller

import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Service.AcabamentoService
import com.unilith.Back.V1.Vo.V1.AcabamentoVo
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Tag(name = "Acabamento Endpoint")
@RestController
@RequestMapping("/acabamento")
class SAcabementoController {

    @Autowired
    private lateinit var service: AcabamentoService;

    @GetMapping(value = [""])
    fun findProperty():List<AcabamentoVo>{
        return service.findAll(Filtro());
    }

    @PostMapping(value = [""])
    fun create(@RequestBody acabamentoVo: AcabamentoVo): AcabamentoVo {
        return service.create(acabamentoVo);
    }

    @PutMapping(value = [""])
    fun update(@RequestBody acabamentoVo: AcabamentoVo): AcabamentoVo {
        return service.update(acabamentoVo);
    }
}

