package com.unilith.Back.V1.Controller

import com.unilith.Back.V1.Service.BairroService
import com.unilith.Back.V1.Vo.V1.BairroVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/bairro")
class BairroController {

    @Autowired
    private lateinit var service: BairroService;

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id:Long): BairroVo {
        return service.findById(id);
    }

    @GetMapping(value = ["/"])
    fun findAll(@RequestParam("page") page: Optional<Int>,
                @RequestParam("dataIni") dataIni: Optional<Date>,
                @RequestParam("dataAte") dataAte: Optional<Date>
    ):List<BairroVo>{
        return service.findAll(page,dataIni,dataAte);
    }

    @PostMapping(value = ["/"])
    fun create(@RequestBody bairroVo: BairroVo): BairroVo {
        return service.create(bairroVo);
    }

    @PutMapping(value = ["/"])
    fun update(@RequestBody bairroVo: BairroVo): BairroVo {
        return service.update(bairroVo);
    }

}