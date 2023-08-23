package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.OrdemServico
import com.unilith.Back.V1.Entity.V1.OrdemServicoAcabamento
import com.unilith.Back.V1.Entity.V1.OrdemServicoTinta
import com.unilith.Back.V1.Entity.V1.OrdemServicoViaCores
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Mapper.DozerMapper
import com.unilith.Back.V1.Repository.OrdemServicoRepository
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Vo.V1.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger

@Service
class OrdemServicoService {

    @Autowired
    private lateinit var repository: OrdemServicoRepository

    @Autowired
    private lateinit var ordemServicoAcabamentoService: OrdemServicoAcabamentoService

    @Autowired
    private lateinit var ordemServicoTintaService: OrdemServicoTintaService

    @Autowired
    private lateinit var ordemServicoViaCoresService: OrdemServicoViaCoresService
    @Autowired
    private lateinit var mapper: DozerMapper

    @Autowired
    private lateinit var auditoriaUtil: AuditoriaUtil

    private val logger = Logger.getLogger(OrdemServicoService::class.java.name)

    fun findAll(page: Optional<Int>, dataIni: Optional<Date>, dataAte: Optional<Date>): List<OrdemServicoVo> {
        logger.log(Level.INFO, "Find All Ordem Servico")
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


        val lista:List<OrdemServico> = repository.findAll()
        return mapper.parseListObject(lista,OrdemServicoVo::class.java);

    }


    fun findById(id: Long): OrdemServicoVo {
        logger.log(Level.INFO, "Find One Ordem Servico");

        val ordemServico: OrdemServico = repository.findById(id).orElseThrow({ ResourceNotFoundException("Objeto não Encontrado") });

        var listaOrdemServicoAcabamento = ordemServicoAcabamentoService.repository.findAllByOrdemServico(ordemServico);
        var listaOrdemServicoTinta = ordemServicoTintaService.repository.findAllByOrdemServico(ordemServico);
        var listaOrdemServicoVias = ordemServicoViaCoresService.repository.findAllByOrdemServico(ordemServico);

        var ordemServicoVo =  mapper.parseObject(ordemServico,OrdemServicoVo::class.java);


        ordemServicoVo.listaAcabamento = listaOrdemServicoAcabamento
            .map { OrdemServicoAcabamento::acabamento }
            .map{osAcabamento -> mapper.parseObject(osAcabamento,AcabamentoVo::class.java)};

        ordemServicoVo.listaTintas = listaOrdemServicoTinta
            .map { OrdemServicoTinta::tinta }
            .map{osTinta -> mapper.parseObject(osTinta,TintaVo::class.java)};

        ordemServicoVo.listaVias = listaOrdemServicoVias
            .map { OrdemServicoViaCores::via }
            .map{osVia -> mapper.parseObject(osVia,ViaCoresVo::class.java)};

        return ordemServicoVo;

    }

    fun create(ordemServicoVo: OrdemServicoVo?): OrdemServicoVo {
        logger.log(Level.INFO, "Save  Ordem Servico");
        if (ordemServicoVo == null) throw RequestObjectisNullException()

        val ordemServico: OrdemServico = mapper.parseObject(ordemServicoVo,OrdemServico::class.java);
        auditoriaUtil.save(ordemServico)
        var ordemServicoNova =    mapper.parseObject(repository.save(ordemServico),OrdemServicoVo::class.java)

        if(ordemServicoVo.listaAcabamento != null){
            var listaAcamentos:List<AcabamentoVo> = ordemServicoVo.listaAcabamento!!
            listaAcamentos
                .map { acabamento -> OrdemServicoAcabamentoVo(0,ordemServicoNova,acabamento) }
                .map { ordemServicoAcabamentoService::create }
        }


        if(ordemServicoVo.listaTintas != null){

            ordemServicoVo.listaTintas!!
                .map { tintas ->  OrdemServicoTintaVo(0,ordemServicoNova,tintas) }
                .map { ordemServicoTintaService::create}

        }

        if(ordemServicoVo.listaVias != null){
            ordemServicoVo.listaVias!!
                .map { viaCores -> OrdemServicoViaCoresVo(0,ordemServicoNova,viaCores) }
                .map { ordemServicoViaCoresService::create }
        }

        return mapper.parseObject(ordemServico,OrdemServicoVo::class.java);
    }

//    fun update(papelVo: PapelVo?): PapelVo {
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

