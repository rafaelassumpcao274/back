package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.Endereco
import com.unilith.Back.V1.Exceptions.RequestObjectNotFoundException
import com.unilith.Back.V1.Mapper.ApiMapper.viaCepMapper
import com.unilith.Back.V1.Mapper.Custom.EnderecoMapper
import com.unilith.Back.V1.Repository.BairroRepository
import com.unilith.Back.V1.Repository.CidadeRepository
import com.unilith.Back.V1.Repository.EnderecoRepository
import com.unilith.Back.V1.Repository.UfRepository
import com.unilith.Back.V1.Util.ViaCepService
import com.unilith.Back.V1.Vo.V1.EnderecoVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class CustomEnderecoService {

    @Autowired
    lateinit var viaCepApi:ViaCepService;
    @Autowired
    lateinit var enderecoMapper: EnderecoMapper;
    @Autowired
    lateinit var repository: EnderecoRepository;
    @Autowired
    lateinit var bairroRepository: BairroRepository;
    @Autowired
    lateinit var cidadeRepository: CidadeRepository;
    @Autowired
    lateinit var ufRepository: UfRepository;



    fun     buscarEndereco(endereco:Endereco):Endereco{
        try{

            if(endereco.bairro.cidade.uf != null && !endereco.bairro.cidade.uf.descricao.isNullOrEmpty() ){
                endereco.bairro.cidade.uf = ufRepository.findOneByDescricaoLike(endereco.bairro.cidade.uf.descricao)
            }

            if(endereco.bairro.cidade != null && !endereco.bairro.cidade.descricao.isNullOrEmpty() ){
                endereco.bairro.cidade = cidadeRepository.findOneByDescricaoEquals(endereco.bairro.cidade.descricao)
            }

            if(endereco.bairro != null && !endereco.bairro.descricao.isNullOrEmpty()){
                endereco.bairro = bairroRepository.findOneByDescricaoEquals(endereco.bairro.descricao);
            }


        }catch (e: EmptyResultDataAccessException){
            if(endereco.cep == null || endereco.cep == 0){
                throw NullPointerException("Endereco Não encontrado !!!")
            }
            var enderecoViaCep = enderecoMapper.convertEntity(viaCepApi.buscarViaCep(endereco.cep.toString()))

            enderecoViaCep.numero = endereco.numero
            enderecoViaCep.complemento = endereco.complemento

            if(endereco.bairro.cidade.uf.id == null || endereco.bairro.cidade.uf.id.equals(0L)){

                endereco.bairro.cidade.uf = ufRepository.save(enderecoViaCep.bairro.cidade.uf)

            }
            enderecoViaCep.bairro.cidade.uf = endereco.bairro.cidade.uf
            if(endereco.bairro.cidade.id == null || endereco.bairro.cidade.id.equals(0L)){
                cidadeRepository.save(enderecoViaCep.bairro.cidade)
                endereco.bairro.cidade = enderecoViaCep.bairro.cidade
            }
            enderecoViaCep.bairro.cidade =  endereco.bairro.cidade
            if(endereco.bairro.id == null || endereco.bairro.id.equals(0L)){
                bairroRepository.save(enderecoViaCep.bairro)
                endereco.bairro = enderecoViaCep.bairro
            }
            enderecoViaCep.bairro =   endereco.bairro

            return enderecoViaCep

        }


        return endereco;
    }



}