package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.Endereco
import com.unilith.Back.V1.Exceptions.RequestObjectNotFoundException
import com.unilith.Back.V1.Mapper.ApiMapper.viaCepMapper
import com.unilith.Back.V1.Mapper.Custom.EnderecoMapper
import com.unilith.Back.V1.Repository.BairroRepository
import com.unilith.Back.V1.Repository.CidadeRepository
import com.unilith.Back.V1.Repository.EnderecoRepository
import com.unilith.Back.V1.Repository.UfRepository
import com.unilith.Back.V1.Util.ViaCepApi
import com.unilith.Back.V1.Vo.V1.EnderecoVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomEnderecoService {

    @Autowired
    lateinit var viaCepApi:ViaCepApi
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


    @Autowired
    lateinit var viaCepMapper: viaCepMapper;

    fun buscarViaCep(cep:String):EnderecoVo{

        var viacep = viaCepApi.findByCep(cep);
        if(viacep.erro){
            throw RequestObjectNotFoundException();
        }
        return enderecoMapper.convertVo(viaCepMapper.convertEntity(viacep));

    }


    fun buscarEndereco(endereco:Endereco):Endereco{
        var novoEndereco: Endereco = endereco;

        if(endereco.descricao.isNullOrEmpty() && endereco.cep != null){
            novoEndereco = enderecoMapper.convertEntity(buscarViaCep(endereco.cep.toString()));
        }

        if(novoEndereco.bairro != null && !novoEndereco.bairro.descricao.isNullOrEmpty()){
            novoEndereco.bairro = bairroRepository.findOneByDescricaoEquals(endereco.bairro.descricao);
        }

        if(novoEndereco.bairro.cidade != null && !novoEndereco.bairro.cidade.descricao.isNullOrEmpty() ){
            novoEndereco.bairro.cidade = cidadeRepository.findOneByDescricaoEquals(endereco.bairro.cidade.descricao)
        }

        if(novoEndereco.bairro.cidade.uf != null && !novoEndereco.bairro.cidade.uf.descricao.isNullOrEmpty() ){
            novoEndereco.bairro.cidade.uf = ufRepository.findOneByDescricaoLike(endereco.bairro.cidade.uf.descricao)
        }


        return novoEndereco;
    }



}