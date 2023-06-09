package com.unilith.Back.V1.Controller

import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Service.ViaCoresService
import com.unilith.Back.V1.Vo.V1.ViaCoresVo
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
@Tag(name = "Via Cores Endpoint")
@RestController
@RequestMapping("/via-cores")
class ViaCoresController {
    @Autowired
    private lateinit var service: ViaCoresService;

    @GetMapping(value = [""])
    fun findProperty():List<ViaCoresVo>{
        return service.findAll(Filtro());
    }

    @PostMapping(value = [""])
    fun create(@RequestBody viaCoresVo: ViaCoresVo): ViaCoresVo {
        return service.create(viaCoresVo);
    }

    @PutMapping(value = [""])
    fun update(@RequestBody viaCoresVo: ViaCoresVo): ViaCoresVo {
        return service.update(viaCoresVo);
    }
}