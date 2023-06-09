package com.unilith.Back.V1.Controller

import com.unilith.Back.V1.Service.EmpresaService
import com.unilith.Back.V1.Vo.V1.EmpresaVo
import com.unilith.Back.V1.Vo.V1.Paginator
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@Tag(name = "Empresa Endpoint")
@RestController
@RequestMapping("/empresa")
class EmpresaController {

    @Autowired
    private lateinit var service: EmpresaService;


    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id:Long): EmpresaVo {
        return service.findById(id);
    }

    @GetMapping(value = [""])
    fun findAll(@RequestParam("page") page: Optional<Int>,
                @RequestParam("dataIni") dataIni: Optional<Date>,
                @RequestParam("dataAte") dataAte: Optional<Date>,
                @RequestParam("totalItens") totalItens: Optional<Int>
    ): Paginator<EmpresaVo> {
        return service.findAll(page,dataIni,dataAte,totalItens);
    }

    @PostMapping(value = [""])
    fun create(@RequestBody empresaVo: EmpresaVo): EmpresaVo {
        return service.create(empresaVo);
    }

    @PutMapping(value = [""])
    fun update(@RequestBody enderecoVo: EmpresaVo): EmpresaVo {
        return service.update(enderecoVo);
    }


}