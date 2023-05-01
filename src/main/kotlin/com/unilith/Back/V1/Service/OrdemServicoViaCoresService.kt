package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.OrdemServicoViaCores
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Mapper.DozerMapper
import com.unilith.Back.V1.Repository.OrdemServicoViaCoresRepository
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Vo.V1.OrdemServicoViaCoresVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger


@Service

class OrdemServicoViaCoresService {
    @Autowired
    lateinit var repository: OrdemServicoViaCoresRepository

    @Autowired
    private lateinit var mapper: DozerMapper


    @Autowired
    private lateinit var auditoriaUtil: AuditoriaUtil

    private val logger = Logger.getLogger(OrdemServicoViaCoresService::class.java.name)

    fun findAll(page: Optional<Int>, dataIni: Optional<Date>, dataAte: Optional<Date>): List<OrdemServicoViaCoresVo> {
        logger.log(Level.INFO, "Find All Ordem Servico")
        val filtro = Filtro();
        if (dataIni.isPresent) {
            filtro.dataIni = dataIni.get()
        }

        if (dataAte.isPresent) {
            filtro.dataAte = dataAte.get()
        }

        if (page.isPresent) {
            filtro.page = page.get()
        }


        val lista: List<OrdemServicoViaCores> = repository.findAll()
        return mapper.parseListObject(lista, OrdemServicoViaCoresVo::class.java);

    }


    fun findById(id: Long): OrdemServicoViaCoresVo {
        logger.log(Level.INFO, "Find One Ordem Servico");

        val ordemServico: OrdemServicoViaCores =
            repository.findById(id).orElseThrow({ ResourceNotFoundException("Objeto não Encontrado") });

        return mapper.parseObject(ordemServico, OrdemServicoViaCoresVo::class.java);


    }

    fun create(ordemServicoVo: OrdemServicoViaCoresVo?): OrdemServicoViaCoresVo {
        logger.log(Level.INFO, "Save  Ordem Servico");
        if (ordemServicoVo == null) throw RequestObjectisNullException()

        val ordermServico: OrdemServicoViaCores = mapper.parseObject(ordemServicoVo, OrdemServicoViaCores::class.java);

        repository.save(ordermServico)


        return mapper.parseObject(ordermServico, OrdemServicoViaCoresVo::class.java);
    }


    fun createAll(lista: List<OrdemServicoViaCoresVo>): List<OrdemServicoViaCoresVo> {

        if (lista.isEmpty()) throw  RequestObjectisNullException()

        val listaOrdemServicoAcabamento = mapper.parseListObject(lista, OrdemServicoViaCores::class.java)

        repository.saveAll(listaOrdemServicoAcabamento);

        return mapper.parseListObject(listaOrdemServicoAcabamento, OrdemServicoViaCoresVo::class.java);

    }


//    fun update(papelVo: PapelVo?): OrdemServicoViaCoresVo {
//
//        if (papelVo == null) throw RequestObjectisNullException()
//        logger.log(Level.INFO, "Update  Ordem Servico ${papelVo.id}");
//        val papel =
//            repository.findById(papelVo.id).orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${papelVo.id})!!") });
//
//        papel.quantidadePapel = papelVo.quantidadePapel;
//        papel.descricao = papelVo.descricao;
//
//        return mapper.convertVo(papel);
//
//    }

    fun delete(id: Long) {
        logger.info("Delete one Ordem Servico ${id} ")
        val papel = repository.findById(id)
            .orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${id})!!") })
        repository.delete(papel);
    }

}