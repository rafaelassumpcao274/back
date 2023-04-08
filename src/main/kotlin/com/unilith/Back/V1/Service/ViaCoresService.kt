package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.ViaCores
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Mapper.DozerMapper
import com.unilith.Back.V1.Repository.ViaCoresRepository
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Vo.V1.ViaCoresVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Level
import java.util.logging.Logger

@Service
class ViaCoresService {

    @Autowired
    private lateinit var repository: ViaCoresRepository

    @Autowired
    private lateinit var mapper: DozerMapper

    @Autowired
    private lateinit var auditoriaUtil: AuditoriaUtil

    private val logger = Logger.getLogger(ViaCoresService::class.java.name)

    fun findAll(filtro: Filtro): List<ViaCoresVo> {
        logger.log(Level.INFO, "Find All ViaCores")
        val lista = repository.findAll()

        return mapper.parseListObject(lista, ViaCoresVo::class.java);

    }


    fun findById(id: Long): ViaCoresVo {
        logger.log(Level.INFO, "Find One ViaCores");

        val viasCores: ViaCores = repository.findById(id).orElseThrow({ ResourceNotFoundException("Objeto não Encontrado") });

        return mapper.parseObject(viasCores, ViaCoresVo::class.java);


    }


    fun create(viaCoresVo: ViaCoresVo?): ViaCoresVo {
        logger.log(Level.INFO, "Save  ViaCores");
        if (viaCoresVo == null) throw RequestObjectisNullException()

        var viasCores: ViaCores = mapper.parseObject(viaCoresVo, ViaCores::class.java);

        auditoriaUtil.save(viasCores)

        repository.save(viasCores)

        return mapper.parseObject(viasCores, ViaCoresVo::class.java);
    }

    fun update(viaCoresVo: ViaCoresVo?): ViaCoresVo {

        if (viaCoresVo == null) throw RequestObjectisNullException()
        logger.log(Level.INFO, "Update ViaCores ${viaCoresVo.id}");
        var viasCores =
            repository.findById(viaCoresVo.id).orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${viaCoresVo.id})!!") });

        viasCores.descricao = viaCoresVo.descricao;

        auditoriaUtil.update(viasCores)
        repository.save(viasCores)

        return mapper.parseObject(viasCores, ViaCoresVo::class.java);

    }

    fun delete(id: Long) {
        logger.info("Delete one viasCores ${id} ")
        val viasCores = repository.findById(id)
            .orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${id})!!") })
        repository.delete(viasCores);
    }
    
}