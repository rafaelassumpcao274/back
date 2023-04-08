package com.unilith.Back.V1.Controller

import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Service.TintaService
import com.unilith.Back.V1.Vo.V1.TintaVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tinta")
class TintaController {

    @Autowired
    private lateinit var service: TintaService;

    @GetMapping(value = [""])
    fun findProperty():List<TintaVo>{
        return service.findAll(Filtro());
    }

    @PostMapping(value = [""])
    fun create(@RequestBody tintaVo: TintaVo): TintaVo {
        return service.create(tintaVo);
    }

    @PutMapping(value = [""])
    fun update(@RequestBody tintaVo: TintaVo): TintaVo {
        return service.update(tintaVo);
    }
}