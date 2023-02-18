package com.unilith.Back.V1.Controller

import com.unilith.Back.V1.Service.CidadeService
import com.unilith.Back.V1.Vo.V1.CidadeVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/cidade")
class CidadeController {
    @Autowired
    private lateinit var service: CidadeService;

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id:Long):CidadeVo{
        return service.findById(id);
    }

    @GetMapping(value = ["/"])
    fun findAll(@RequestParam("page") page: Optional<Int>,
                @RequestParam("dataIni") dataIni: Optional<Date>,
                @RequestParam("dataAte") dataAte: Optional<Date>
    ):List<CidadeVo>{
        return service.findAll(page,dataIni,dataAte);
    }

    @PostMapping(value = ["/"])
    fun create(@RequestBody cidadeVo: CidadeVo):CidadeVo{
        return service.create(cidadeVo);
    }

    @PutMapping(value = ["/"])
    fun update(@RequestBody cidadeVo: CidadeVo):CidadeVo{
        return service.update(cidadeVo);
    }


}