package com.unilith.Back.V1.Controller

import com.unilith.Back.V1.Service.PapelService
import com.unilith.Back.V1.Vo.V1.PapelVo
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@Tag(name = "Papel Endpoint")
@RestController
@RequestMapping("/papel")
class PapelController {

    @Autowired
    private lateinit var service:PapelService;



    @GetMapping(value = ["/"])
    fun findAll(@RequestParam("page") page:Optional<Int>,
                @RequestParam("dataIni") dataIni:Optional<Date>,
                @RequestParam("dataAte") dataAte:Optional<Date>):List<PapelVo>{

        return service.findAll(page,dataIni,dataAte);
    }


    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id:Long): PapelVo {
        return service.findById(id);
    }


    @PostMapping(value = ["/"])
    fun create(@RequestBody papelVo: PapelVo): PapelVo {
        return service.create(papelVo);
    }

    @PutMapping(value = ["/"])
    fun update(@RequestBody papelVo: PapelVo): PapelVo {
        return service.update(papelVo);
    }


    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable(value="id",) id:Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>();
    }

}