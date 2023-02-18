package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.Endereco
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Mapper.Custom.EnderecoMapper
import com.unilith.Back.V1.Mapper.DozerMapper
import com.unilith.Back.V1.Repository.EnderecoRepository
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Vo.V1.EnderecoVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger


@Service
class EnderecoService {
    @Autowired
    lateinit var repository: EnderecoRepository

    @Autowired
    private lateinit var mapper: DozerMapper

    @Autowired
    private lateinit var enderecoMapper: EnderecoMapper

    @Autowired
    private lateinit var auditoriaUtil: AuditoriaUtil

    private val logger = Logger.getLogger(EnderecoService::class.java.name)


    fun findAll(page: Optional<Int>,
                dataIni: Optional<Date>,
                dataAte: Optional<Date>
    ): List<EnderecoVo> {
        logger.log(Level.INFO, "Find All Endereco")
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

        val lista:List<Endereco> = repository.findAll()

        return enderecoMapper.convertListVo(lista);

    }


    fun findById(id: Long): EnderecoVo {
        logger.log(Level.INFO, "Find One Endereco");

        val endereco: Endereco = repository.findById(id).orElseThrow({ ResourceNotFoundException("Objeto não Encontrado") });

        return enderecoMapper.convertVo(endereco);


    }


    fun create(enderecoVo: EnderecoVo?): EnderecoVo {
        logger.log(Level.INFO, "Save  Endereco");
        if (enderecoVo == null) throw RequestObjectisNullException()

        var endereco: Endereco = mapper.parseObject(enderecoVo, Endereco::class.java);

        auditoriaUtil.save(endereco)

        repository.save(endereco)

        return mapper.parseObject(endereco, EnderecoVo::class.java);
    }

    fun update(enderecoVo: EnderecoVo?): EnderecoVo {

        if (enderecoVo == null) throw RequestObjectisNullException()
        logger.log(Level.INFO, "Update Endereco ${enderecoVo.id}");
        var endereco =
            repository.findById(enderecoVo.id).orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${enderecoVo.id})!!") });

        endereco.descricao = enderecoVo.descricao;

        auditoriaUtil.update(endereco)
        repository.save(endereco)

        return mapper.parseObject(endereco, EnderecoVo::class.java);

    }

    fun delete(id: Long) {
        logger.info("Delete one Endereco ${id} ")
        val endereco = repository.findById(id)
            .orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${id})!!") })
        repository.delete(endereco);
    }

}