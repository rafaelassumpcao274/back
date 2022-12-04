package com.unilith.Back.V1.Service


import com.unilith.Back.V1.Entity.V1.Cidade
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Mapper.Custom.CidadeMapper
import com.unilith.Back.V1.Mapper.DozerMapper
import com.unilith.Back.V1.Repository.CidadeRepository
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Vo.V1.CidadeVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Level
import java.util.logging.Logger


@Service
class CidadeService {

    lateinit var repository: CidadeRepository

    @Autowired
    private lateinit var mapper: DozerMapper

    @Autowired
    private lateinit var cidadeMapper: CidadeMapper

    @Autowired
    private lateinit var auditoriaUtil: AuditoriaUtil

    private val logger = Logger.getLogger(CidadeService::class.java.name)


    fun findAll(filtro: Filtro): List<CidadeVo> {
        logger.log(Level.INFO, "Find All Cidade")
        val lista:List<Cidade> = repository.findAll()

        return cidadeMapper.convertListVo(lista);

    }


    fun findById(id: Long): CidadeVo {
        logger.log(Level.INFO, "Find One Cidade");

        val cidade: Cidade = repository.findById(id).orElseThrow({ ResourceNotFoundException("Objeto não Encontrado") });

        return cidadeMapper.convertVo(cidade);


    }


    fun create(cidadeVo: CidadeVo?): CidadeVo {
        logger.log(Level.INFO, "Save  Cidade");
        if (cidadeVo == null) throw RequestObjectisNullException()

        var cidade: Cidade = mapper.parseObject(cidadeVo, Cidade::class.java);

        auditoriaUtil.save(cidade)

        repository.save(cidade)

        return mapper.parseObject(cidade, CidadeVo::class.java);
    }

    fun update(cidadeVo: CidadeVo?): CidadeVo {

        if (cidadeVo == null) throw RequestObjectisNullException()
        logger.log(Level.INFO, "Update Cidade ${cidadeVo.id}");
        var cidade =
            repository.findById(cidadeVo.id).orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${cidadeVo.id})!!") });

        cidade.descricao = cidadeVo.descricao;

        auditoriaUtil.update(cidade)
        repository.save(cidade)

        return mapper.parseObject(cidade, CidadeVo::class.java);

    }

    fun delete(id: Long) {
        logger.info("Delete one Cidade ${id} ")
        val cidade = repository.findById(id)
            .orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${id})!!") })
        repository.delete(cidade);
    }
}