package com.unilith.Back.V1.Service

import com.unilith.Back.V1.Entity.V1.Endereco
import com.unilith.Back.V1.Repository.BairroRepository
import com.unilith.Back.V1.Repository.CidadeRepository
import com.unilith.Back.V1.Repository.EnderecoRepository
import com.unilith.Back.V1.Repository.UfRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class CustomEnderecoService {

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

            if(endereco.bairro?.cidade?.uf != null && !endereco.bairro!!.cidade?.uf?.descricao.isNullOrEmpty() ){
                endereco.bairro!!.cidade?.uf = endereco.bairro!!.cidade?.uf?.let {
                    ufRepository.findOneByDescricaoLike(
                        it.descricao)
                }
            }

            if(endereco.bairro?.cidade != null && !endereco.bairro?.cidade!!.descricao.isNullOrEmpty() ){
                endereco.bairro!!.cidade = endereco.bairro!!.cidade?.let { cidadeRepository.findOneByDescricaoEquals(it.descricao) }
            }

            if(endereco.bairro != null && !endereco.bairro!!.descricao.isNullOrEmpty()){
                endereco.bairro = bairroRepository.findOneByDescricaoEquals(endereco.bairro!!.descricao);
            }


        }catch (e: EmptyResultDataAccessException){
            if(endereco.cep == null || endereco.cep == 0){
                throw NullPointerException("Endereco Não encontrado !!!")
            }

        }


        return endereco;
    }



}