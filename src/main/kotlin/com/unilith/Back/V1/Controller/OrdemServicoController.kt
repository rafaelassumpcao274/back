package com.unilith.Back.V1.Controller

import com.unilith.Back.V1.Service.OrdemServicoService
import com.unilith.Back.V1.Vo.V1.OrdemServicoVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/ordemservico")
class OrdemServicoController {

    @Autowired
    private lateinit var service: OrdemServicoService;

    @GetMapping(value = [""])
    fun findAll(@RequestParam("page") page: Optional<Int>,
                @RequestParam("dataIni") dataIni: Optional<Date>,
                @RequestParam("dataAte") dataAte: Optional<Date>,
                @RequestParam("totalItens") totalItens: Optional<Int>):List<OrdemServicoVo>{

        return service.findAll(page,dataIni,dataAte);
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id:Long):OrdemServicoVo{
        return service.findById(id);
    }

    @PostMapping(value = [""])
    fun create(@RequestBody ordemServicoVo: OrdemServicoVo): OrdemServicoVo {
        return service.create(ordemServicoVo);
    }

//    @PutMapping(value = [""])
//    fun update(@RequestBody tintaVo: TintaVo): TintaVo {
//        return service.update(tintaVo);
//    }

}
