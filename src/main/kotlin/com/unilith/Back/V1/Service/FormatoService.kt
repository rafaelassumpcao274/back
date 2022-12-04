package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.Formato
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Mapper.Custom.FormatoMapper
import com.unilith.Back.V1.Repository.FormatoRepository
import com.unilith.Back.V1.Vo.V1.FormatoVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Level
import java.util.logging.Logger

@Service
class FormatoService {

    @Autowired
    private lateinit var repository: FormatoRepository

    @Autowired
    private lateinit var mapper: FormatoMapper

    private val logger = Logger.getLogger(FormatoService::class.java.name)


    fun findAll(filtro: Filtro): List<FormatoVo> {
        logger.log(Level.INFO, "Find All Formato")
        val lista = repository.findAll()
        return mapper.convertListVo(lista as ArrayList<Formato>);

    }


    fun findById(id: Long): FormatoVo {
        logger.log(Level.INFO, "Find One Formato");

        val formato: Formato = repository.findById(id).orElseThrow({ ResourceNotFoundException("Objeto não Encontrado") });

        return mapper.convertVo(formato);


    }

    fun create(formatoVo: FormatoVo?): FormatoVo {
        logger.log(Level.INFO, "Save  formato");
        if (formatoVo == null) throw RequestObjectisNullException()

        var formato: Formato = mapper.convertEntity(formatoVo);

        repository.save(formato)


        return mapper.convertVo(formato);
    }

    fun update(formatoVo: FormatoVo?): FormatoVo {

        if (formatoVo == null) throw RequestObjectisNullException()
        logger.log(Level.INFO, "Update  formato ${formatoVo.id}");
        var formato =
            repository.findById(formatoVo.id).orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${formatoVo.id})!!") });

        formato.descricao = formatoVo.descricao;


        return mapper.convertVo(formato);

    }

    fun delete(id: Long) {
        logger.info("Delete one formato ${id} ")
        val formato = repository.findById(id)
            .orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${id})!!") })
        repository.delete(formato);
    }
}

