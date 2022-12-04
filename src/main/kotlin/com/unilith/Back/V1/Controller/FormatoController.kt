package com.unilith.Back.V1.Controller

import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Service.FormatoService
import com.unilith.Back.V1.Vo.V1.FormatoVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/formato")
class FormatoController {


    @Autowired
    private lateinit var service:FormatoService


    @GetMapping(value = ["/"])
    fun findAll(@RequestParam("page") page:Optional<Int>,
                @RequestParam("dataIni") dataIni:Optional<Date>,
                @RequestParam("dataAte") dataAte:Optional<Date>
                ): List<FormatoVo>{

        val filtro = Filtro();
        if(dataIni.isPresent){
            filtro.dataIni = dataIni.get()
        }

        if(dataAte.isPresent){
            filtro.dataAte = dataAte.get()
        }

        if(page.isPresent){
            filtro.page= page.get()
        }


        return service.findAll(filtro);



    }


    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id:Long): FormatoVo {
        return service.findById(id);
    }


    @PostMapping(value = ["/"])
    fun create(@RequestBody formatoVo: FormatoVo): FormatoVo {
        return service.create(formatoVo);
    }

    @PutMapping(value = ["/"])
    fun update(@RequestBody formatoVo: FormatoVo): FormatoVo {
        return service.update(formatoVo);
    }


    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable(value="id",) id:Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>();
    }

}