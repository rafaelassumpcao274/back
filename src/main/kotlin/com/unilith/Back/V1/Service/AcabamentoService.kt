package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.Acabamento
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Mapper.DozerMapper
import com.unilith.Back.V1.Repository.AcabamentoRepository
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Vo.V1.AcabamentoVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Level
import java.util.logging.Logger


@Service
class AcabamentoService {

    @Autowired
    private lateinit var repository: AcabamentoRepository

    @Autowired
    private lateinit var mapper: DozerMapper

    @Autowired
    private lateinit var auditoriaUtil: AuditoriaUtil

    private val logger = Logger.getLogger(AcabamentoService::class.java.name)

    fun findAll(filtro: Filtro): List<AcabamentoVo> {
        logger.log(Level.INFO, "Find All Acabamentos")
        val lista = repository.findAll()

        return mapper.parseListObject(lista, AcabamentoVo::class.java);

    }


    fun findById(id: Long): AcabamentoVo {
        logger.log(Level.INFO, "Find One Acabamento");

        val acabamento:Acabamento = repository.findById(id).orElseThrow({ ResourceNotFoundException("Objeto não Encontrado") });

        return mapper.parseObject(acabamento, AcabamentoVo::class.java);


    }


    fun create(acabamentoVo: AcabamentoVo?): AcabamentoVo {
        logger.log(Level.INFO, "Save  Acabamento");
        if (acabamentoVo == null) throw RequestObjectisNullException()

        var acabamento: Acabamento = mapper.parseObject(acabamentoVo,Acabamento::class.java);

        auditoriaUtil.save(acabamento)

        repository.save(acabamento)

        return mapper.parseObject(acabamento,AcabamentoVo::class.java);
    }

    fun update(acabamentoVo: AcabamentoVo?): AcabamentoVo {

        if (acabamentoVo == null) throw RequestObjectisNullException()
        logger.log(Level.INFO, "Update Acabamento ${acabamentoVo.id}");
        var acabamento =
            repository.findById(acabamentoVo.id).orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${acabamentoVo.id})!!") });

        acabamento.descricao = acabamentoVo.descricao;

        auditoriaUtil.update(acabamento)
        repository.save(acabamento)

        return mapper.parseObject(acabamento,AcabamentoVo::class.java);

    }

    fun delete(id: Long) {
        logger.info("Delete one acabamento ${id} ")
        val acabamento = repository.findById(id)
            .orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${id})!!") })
        repository.delete(acabamento);
    }
}