package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.Bairro
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Mapper.Custom.BairroMapper
import com.unilith.Back.V1.Mapper.DozerMapper
import com.unilith.Back.V1.Repository.BairroRepository
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Vo.V1.BairroVo
import org.springframework.beans.factory.annotation.Autowired
import java.util.logging.Level
import java.util.logging.Logger

class BairroService {

    lateinit var repository: BairroRepository

    @Autowired
    private lateinit var mapper: DozerMapper

    @Autowired
    private lateinit var bairroMapper: BairroMapper

    @Autowired
    private lateinit var auditoriaUtil: AuditoriaUtil

    private val logger = Logger.getLogger(BairroService::class.java.name)


    fun findAll(filtro: Filtro): List<BairroVo> {
        logger.log(Level.INFO, "Find All Bairro")
        val lista:List<Bairro> = repository.findAll()

        return bairroMapper.convertListVo(lista);

    }


    fun findById(id: Long): BairroVo {
        logger.log(Level.INFO, "Find One Bairro");

        val bairro: Bairro = repository.findById(id).orElseThrow({ ResourceNotFoundException("Objeto não Encontrado") });

        return bairroMapper.convertVo(bairro);


    }


    fun create(bairroVo: BairroVo?): BairroVo {
        logger.log(Level.INFO, "Save  Bairro");
        if (bairroVo == null) throw RequestObjectisNullException()

        var bairro: Bairro = mapper.parseObject(bairroVo, Bairro::class.java);

        auditoriaUtil.save(bairro)

        repository.save(bairro)

        return mapper.parseObject(bairro, BairroVo::class.java);
    }

    fun update(bairroVo: BairroVo?): BairroVo {

        if (bairroVo == null) throw RequestObjectisNullException()
        logger.log(Level.INFO, "Update Bairro ${bairroVo.id}");
        var bairro =
            repository.findById(bairroVo.id).orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${bairroVo.id})!!") });

        bairro.descricao = bairroVo.descricao;

        auditoriaUtil.update(bairro)
        repository.save(bairro)

        return mapper.parseObject(bairro, BairroVo::class.java);

    }

    fun delete(id: Long) {
        logger.info("Delete one Bairro ${id} ")
        val bairro = repository.findById(id)
            .orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${id})!!") })
        repository.delete(bairro);
    }
}
