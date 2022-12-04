package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.Uf
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Mapper.DozerMapper
import com.unilith.Back.V1.Repository.UfRepository
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Util.PropertyUtils
import com.unilith.Back.V1.Vo.V1.UfVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Level
import java.util.logging.Logger

@Service
class UfService  {

    @Autowired
    private lateinit var repository: UfRepository

    @Autowired
    private lateinit var mapper: DozerMapper

    @Autowired
    private lateinit var auditoriaUtil: AuditoriaUtil

    private val logger = Logger.getLogger(UfService::class.java.name)

    fun findAll(filtro: Filtro): List<UfVo> {
        logger.log(Level.INFO, "Find All Uf")
        val lista = repository.findAll()

        return mapper.parseListObject(lista, UfVo::class.java);

    }


    fun findById(id: Long): UfVo {
        logger.log(Level.INFO, "Find One Uf");

        val uf: Uf = repository.findById(id).orElseThrow({ ResourceNotFoundException("Objeto não Encontrado") });

        return mapper.parseObject(uf,UfVo::class.java);


    }

    fun <R> findByProperty():R{
        val uf = findById(1);
        return PropertyUtils().readInstanceProperty(uf,"descricao")
    }

    fun create(ufVo: UfVo?): UfVo {
        logger.log(Level.INFO, "Save  Uf");
        if (ufVo == null) throw RequestObjectisNullException()

        var uf: Uf = mapper.parseObject(ufVo,Uf::class.java);

        auditoriaUtil.save(uf)

        repository.save(uf)

        return mapper.parseObject(uf,UfVo::class.java);
    }

    fun update(ufVo: UfVo?): UfVo {

        if (ufVo == null) throw RequestObjectisNullException()
        logger.log(Level.INFO, "Update Uf ${ufVo.id}");
        var uf =
            repository.findById(ufVo.id).orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${ufVo.id})!!") });

        uf.descricao = ufVo.descricao;

        auditoriaUtil.update(uf)
        repository.save(uf)

        return mapper.parseObject(uf,UfVo::class.java);

    }

    fun delete(id: Long) {
        logger.info("Delete one uf ${id} ")
        val uf = repository.findById(id)
            .orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${id})!!") })
        repository.delete(uf);
    }




}