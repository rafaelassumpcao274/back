package com.unilith.Back.V1.Controller


import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Service.UfService
import com.unilith.Back.V1.Vo.V1.UfVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/uf")
class UfController {
    @Autowired
    private lateinit var service: UfService;

    @GetMapping(value = ["/"])
    fun findProperty():List<UfVo>{
        return service.findAll(Filtro());
    }

    @PostMapping(value = ["/"])
    fun create(@RequestBody ufVo: UfVo):UfVo{
        return service.create(ufVo);
    }

    @PutMapping(value = ["/"])
    fun update(@RequestBody ufVo: UfVo):UfVo{
        return service.update(ufVo);
    }


}