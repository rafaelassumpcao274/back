package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.Formato
import com.unilith.Back.V1.Entity.V1.Papel
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Mapper.Custom.PapelMapper
import com.unilith.Back.V1.Repository.PapelRepository
import com.unilith.Back.V1.Vo.V1.FormatoVo
import com.unilith.Back.V1.Vo.V1.PapelVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger

@Service
class PapelService {

    @Autowired
    private lateinit var repository: PapelRepository

    @Autowired
    private lateinit var mapper: PapelMapper

    private val logger = Logger.getLogger(PapelService::class.java.name)


    fun findAll(page: Optional<Int>,dataIni: Optional<Date>,dataAte: Optional<Date>): List<PapelVo> {
        logger.log(Level.INFO, "Find All Papel")
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


        val lista = repository.findAll()
        return mapper.convertListVo(lista as ArrayList<Papel>);

    }


    fun findById(id: Long): PapelVo {
        logger.log(Level.INFO, "Find One Papel");

        val papel: Papel = repository.findById(id).orElseThrow({ ResourceNotFoundException("Objeto não Encontrado") });

        return mapper.convertVo(papel);


    }
    fun findByDescricao(descricao:String): List<PapelVo> {
        logger.log(Level.INFO, "Find by Emṕresa name ${descricao}");

        val listaPapeis: List<Papel> = repository.findAllByDescricaoContaining(descricao, PageRequest.of(0,10));

        return mapper.convertListVo(listaPapeis);


    }

    fun create(papelVo: PapelVo?): PapelVo {
        logger.log(Level.INFO, "Save  papel");
        if (papelVo == null) throw RequestObjectisNullException()

        val papel: Papel = mapper.convertEntity(papelVo);

        repository.save(papel)


        return mapper.convertVo(papel);
    }

    fun update(papelVo: PapelVo?): PapelVo {

        if (papelVo == null) throw RequestObjectisNullException()
        logger.log(Level.INFO, "Update  papel ${papelVo.id}");
        val papel =
            repository.findById(papelVo.id).orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${papelVo.id})!!") });

        papel.quantidadePapel = papelVo.quantidadePapel;
        papel.descricao = papelVo.descricao;

        return mapper.convertVo(papel);

    }

    fun delete(id: Long) {
        logger.info("Delete one papel ${id} ")
        val papel = repository.findById(id)
            .orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${id})!!") })
        repository.delete(papel);
    }

}