package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.Tinta
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Mapper.DozerMapper
import com.unilith.Back.V1.Repository.TintaRepository
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Vo.V1.TintaVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Level
import java.util.logging.Logger

@Service
class TintaService {
    
    @Autowired
    private lateinit var repository: TintaRepository

    @Autowired
    private lateinit var mapper: DozerMapper

    @Autowired
    private lateinit var auditoriaUtil: AuditoriaUtil

    private val logger = Logger.getLogger(TintaService::class.java.name)

    fun findAll(filtro: Filtro): List<TintaVo> {
        logger.log(Level.INFO, "Find All Tinta")
        val lista = repository.findAll()

        return mapper.parseListObject(lista, TintaVo::class.java);

    }


    fun findById(id: Long): TintaVo {
        logger.log(Level.INFO, "Find One Tinta");

        val tinta: Tinta = repository.findById(id).orElseThrow({ ResourceNotFoundException("Objeto não Encontrado") });

        return mapper.parseObject(tinta, TintaVo::class.java);


    }


    fun create(tintaVo: TintaVo?): TintaVo {
        logger.log(Level.INFO, "Save  Tinta");
        if (tintaVo == null) throw RequestObjectisNullException()

        var tinta: Tinta = mapper.parseObject(tintaVo, Tinta::class.java);

        auditoriaUtil.save(tinta)

        repository.save(tinta)

        return mapper.parseObject(tinta, TintaVo::class.java);
    }

    fun update(tintaVo: TintaVo?): TintaVo {

        if (tintaVo == null) throw RequestObjectisNullException()
        logger.log(Level.INFO, "Update Tinta ${tintaVo.id}");
        var tinta =
            repository.findById(tintaVo.id).orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${tintaVo.id})!!") });

        tinta.descricao = tintaVo.descricao;

        auditoriaUtil.update(tinta)
        repository.save(tinta)

        return mapper.parseObject(tinta, TintaVo::class.java);

    }

    fun delete(id: Long) {
        logger.info("Delete one tinta ${id} ")
        val tinta = repository.findById(id)
            .orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${id})!!") })
        repository.delete(tinta);
    }
    
}