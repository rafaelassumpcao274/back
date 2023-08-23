package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.Empresa
import com.unilith.Back.V1.Exceptions.RequestInvalidObjectException
import com.unilith.Back.V1.Exceptions.RequestObjectNotFoundException
import com.unilith.Back.V1.Exceptions.RequestObjectisNullException
import com.unilith.Back.V1.Exceptions.ResourceNotFoundException
import com.unilith.Back.V1.Filtro.Filtro
import com.unilith.Back.V1.Mapper.Custom.EmpresaMapper
import com.unilith.Back.V1.Mapper.Custom.EnderecoMapper
import com.unilith.Back.V1.Mapper.Custom.PaginationMapper
import com.unilith.Back.V1.Mapper.DozerMapper
import com.unilith.Back.V1.Repository.EmpresaRepository
import com.unilith.Back.V1.Repository.EnderecoRepository
import com.unilith.Back.V1.Util.AuditoriaUtil
import com.unilith.Back.V1.Util.DateUtils.DateFormat
import com.unilith.Back.V1.Util.DateUtils.DateUtil
import com.unilith.Back.V1.Vo.V1.EmpresaVo
import com.unilith.Back.V1.Vo.V1.Paginator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger


@Service
class EmpresaService {

    @Autowired
    lateinit var repository: EmpresaRepository

    @Autowired
    private lateinit var mapper: DozerMapper

    @Autowired
    private lateinit var empresaMapper: EmpresaMapper

    @Autowired
    private lateinit var enderecoRepository: EnderecoRepository;

    @Autowired
    private lateinit var customEnderecoService: CustomEnderecoService;

    @Autowired
    private lateinit var enderecoMapper: EnderecoMapper

    @Autowired
    private lateinit var auditoriaUtil: AuditoriaUtil

    @Autowired
    private lateinit var paginationMapper: PaginationMapper<Empresa>;

    private val logger = Logger.getLogger(EmpresaService::class.java.name)


    fun findAll(page: Optional<Int>,
                descricao: Optional<String>,
                dataIni: Optional<Date>,
                dataAte: Optional<Date>,
                totalItens: Optional<Int>
    ): Paginator<EmpresaVo> {
        logger.log(Level.INFO, "Find All Empresa")
        val filtro = Filtro();

        var pageable = PageRequest.of( page.orElse(0),10)

        if(dataIni.isPresent){
            filtro.dataIni = dataIni.get()
        }

        if(descricao.isPresent){
            filtro.descricao = descricao.get();
        }
        if(dataAte.isPresent){
            filtro.dataAte = dataAte.get()
        }


        var page:Page<Empresa> = repository.findAll(pageable)

        var pagination: Paginator<Empresa> = paginationMapper.convertPageToPagination(page);


        return  paginationMapper.convertVo(empresaMapper,pagination) ;

    }
    fun findByNomeEmpresa(nomeEmpresa:String): List<EmpresaVo> {
        logger.log(Level.INFO, "Find by Empresa name ${nomeEmpresa}");

        val empresas: List<Empresa> = repository.findAllByNomeEmpresaContaining(nomeEmpresa,PageRequest.of(0,10));

        return empresaMapper.convertListVo(empresas);


    }

    fun findById(id: Long): EmpresaVo {
        logger.log(Level.INFO, "Find One Endereco");

        val empresa: Empresa = repository.findById(id).orElseThrow({ RequestObjectNotFoundException() });

        return empresaMapper.convertVo(empresa);


    }


    fun create(empresaVo: EmpresaVo?): EmpresaVo {
        logger.log(Level.INFO, "Save  Endereco");
        if (empresaVo == null) throw RequestObjectisNullException()

        var empresa: Empresa = mapper.parseObject(empresaVo, Empresa::class.java);
        validarEmpresa(empresa)

        auditoriaUtil.save(empresa)

        empresa.endereco = customEnderecoService.buscarEndereco(empresa.endereco);
        auditoriaUtil.save(empresa.endereco);


        enderecoRepository.save(empresa.endereco);
        repository.save(empresa)

        return mapper.parseObject(empresa, EmpresaVo::class.java);
    }

    fun validarEmpresa(empresa:Empresa){

        if(empresa.cnpj != null && empresa.cnpj > 0){
            val cnpj = empresa.cnpj

            var countCnpj = repository.countByCnpj(cnpj)
            if(countCnpj > 0 ){
                throw RequestInvalidObjectException("Cnpj já esta cadastrado no sistema !!!")
            }
        }


    }

    fun update(empresaVo: EmpresaVo?): EmpresaVo {

        if (empresaVo == null) throw RequestObjectisNullException()
        logger.log(Level.INFO, "Update Endereco ${empresaVo.id}");
        var empresa =
            repository.findById(empresaVo.id).orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${empresaVo.id})!!") });

        empresa.cnpj = empresaVo.cnpj
        empresa.nomeEmpresa = empresaVo.nomeEmpresa;
        empresa.email = empresaVo.email;
        empresa.endereco = enderecoMapper.convertEntity(empresaVo.endereco);
        empresa.razaoSocial = empresaVo.razaoSocial;
        empresa.contato = empresaVo.contato;
        empresa.telefone = empresaVo.telefone;


        auditoriaUtil.update(empresa)
        repository.save(empresa)

        return mapper.parseObject(empresa, EmpresaVo::class.java);

    }

    fun delete(id: Long) {
        logger.info("Delete one Endereco ${id} ")
        val empresa = repository.findById(id)
            .orElseThrow({ ResourceNotFoundException("Objeto não encontrado com o id(${id})!!") })
        repository.delete(empresa);
    }

}
