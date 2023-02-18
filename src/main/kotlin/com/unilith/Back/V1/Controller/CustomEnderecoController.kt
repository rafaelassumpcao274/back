package com.unilith.Back.V1.Controller

import com.unilith.Back.V1.Service.CustomEnderecoService
import com.unilith.Back.V1.Service.EnderecoService
import com.unilith.Back.V1.Vo.V1.EnderecoVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

class CustomEnderecoController {
    @RestController
    @RequestMapping("/customEndereco")
    class EnderecoController {
        @Autowired
        private lateinit var service: EnderecoService;

        @Autowired
        private lateinit var customEnderecoService: CustomEnderecoService

        @GetMapping(value = ["/{cep}"])
        fun findById(@PathVariable cep:String): EnderecoVo {
            return customEnderecoService.buscarViaCep(cep);
        }

        @GetMapping(value = ["/"])
        fun findAll(@RequestParam("page") page: Optional<Int>,
                    @RequestParam("dataIni") dataIni: Optional<Date>,
                    @RequestParam("dataAte") dataAte: Optional<Date>
        ):List<EnderecoVo>{
            return service.findAll(page,dataIni,dataAte);
        }

        @PostMapping(value = ["/"])
        fun create(@RequestBody enderecoVo: EnderecoVo): EnderecoVo {
            return service.create(enderecoVo);
        }

        @PutMapping(value = ["/"])
        fun update(@RequestBody enderecoVo: EnderecoVo): EnderecoVo {
            return service.update(enderecoVo);
        }

    }
}